package org.fundaciobit.powertoys.back.controller.all;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.logic.EarSimplePublicLogicaService;
import org.fundaciobit.powertoys.logic.FitxerPublicLogicaService;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar.EarWarInfo;
import org.fundaciobit.powertoys.back.controller.PowerToysFilesFormManager;
import org.fundaciobit.powertoys.back.controller.webdb.EarSimpleController;
import org.fundaciobit.powertoys.back.form.webdb.EarSimpleFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.EarSimpleForm;
import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.powertoys.model.fields.EarSimpleFields;
import org.fundaciobit.powertoys.persistence.EarSimpleJPA;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@MenuOption(labelCode = "earSimple.earSimple.plural", order = 10, group = "PUBLIC", addSeparatorBefore = true)
@Controller
@RequestMapping(value = "/public/earSimple")
@SessionAttributes(types = { EarSimpleForm.class, EarSimpleFilterForm.class })
public class EarSimplePublicController extends EarSimpleController {

    @EJB(mappedName = EarSimplePublicLogicaService.JNDI_NAME)
    protected EarSimplePublicLogicaService earSimpleLogicaEjb;

    @EJB(mappedName = FitxerPublicLogicaService.JNDI_NAME)
    protected FitxerPublicLogicaService fitxerLogicaEjb;

    @Override
    protected FilesFormManager<Fitxer> getFilesFormManager() {
        return new PowerToysFilesFormManager(fitxerLogicaEjb);
    }

    @Override
    public String getTileForm() {
        return "earSimpleFormPublic";

    }

    @Override
    public String getTileList() {
        return "earSimpleListPublic";
    }

    @Override
    public EarSimpleFilterForm getEarSimpleFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EarSimpleFilterForm earSimpleFilterForm;
        earSimpleFilterForm = super.getEarSimpleFilterForm(pagina, mav, request);

        if (earSimpleFilterForm.isNou()) {
            earSimpleFilterForm.addHiddenField(EarSimpleFields.EARSIMPLEID);
            earSimpleFilterForm.addHiddenField(EarSimpleFields.NOM);
            earSimpleFilterForm.addHiddenField(EarSimpleFields.DETALL);

            earSimpleFilterForm.setEditButtonVisible(false);
            earSimpleFilterForm.setAddButtonVisible(false);
            earSimpleFilterForm.setViewButtonVisible(true);
            AdditionalButton processEarButton = new AdditionalButton("fas fa-upload", "ear.processarear",
                    getContextWeb() + "/new", AdditionalButtonStyle.PRIMARY);
            earSimpleFilterForm.addAdditionalButton(processEarButton);
        }

        return earSimpleFilterForm;
    }

    @Override
    public EarSimpleForm getEarSimpleForm(EarSimpleJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EarSimpleForm earSimpleForm = super.getEarSimpleForm(_jpa, __isView, request, mav);

        if (earSimpleForm.isNou()) {
            earSimpleForm.addHiddenField(EarSimpleFields.NOM);
            earSimpleForm.addHiddenField(EarSimpleFields.DETALL);
            earSimpleForm.addHiddenField(EarSimpleFields.DATA);

            earSimpleForm.setSaveButtonVisible(false);
            AdditionalButton processEarButton = new AdditionalButton("fas fa-file-import", "ear.processar",
                    "javascript:$('form#earSimpleForm').submit();", AdditionalButtonStyle.PRIMARY);
            earSimpleForm.addAdditionalButton(processEarButton);

            earSimpleForm.setTitleCode("ear.processarearsimple");
        }

        earSimpleForm.setCancelButtonVisible(false);
        AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
        earSimpleForm.addAdditionalButton(returnButton);

        return earSimpleForm;
    }

    @Override
    public void preValidate(HttpServletRequest request, EarSimpleForm earSimpleForm, BindingResult result)
            throws I18NException {
        log.info("Processant EAR al preValidate");

        EarSimpleJPA earSimple = earSimpleForm.getEarSimple();
        File earWarFile = null;
        List<EarWarInfo> trobats = new ArrayList<EarWarInfo>();

        Fitxer fitxer = fitxerEjb.findByPrimaryKey(earSimple.getFitxerID());
        String nom = fitxer.getNom();
        String detall = "";

        earWarFile = FileSystemManager.getFile(earSimple.getFitxerID());
        try {
            SearchJBossModulesInEar.processFileEarWar(earWarFile, nom, trobats);
        } catch (Exception e) {
            String missatgeError = "Error a l'actualitzar el nom i detall de l'EAR: " + e.getMessage();
            HtmlUtils.saveMessageError(request, missatgeError);
            log.error(missatgeError, e);
            throw new I18NException("genapp.comodi", missatgeError);
        }

        log.info("fitxer EAR llegit al preValidate, actualitzam nom i detall");

        for (EarWarInfo earWarInfo : trobats) {
            detall += earWarInfoToString(earWarInfo) + "\n";
            detall += "--------------------------------------\n";
        }
        log.info("trobats: " + detall);

        detall = "<p style=\"font-family: Courier;\">" + detall.replaceAll("\n", "<br\\>\n") + "</p>";
        earSimple.setNom(nom);
        earSimple.setDetall(detall);
        earSimple.setData(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, EarSimpleForm earSimpleForm) {
        EarSimpleJPA earSimple = earSimpleForm.getEarSimple();
        long newId = earSimple.getEarSimpleID();
        HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("ear.processat", earSimple.getFitxer().getNom()));

        return "redirect:" + getContextWeb() + "/view/" + newId;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public void delete(HttpServletRequest request, EarSimple earSimple) throws I18NException {
        earSimpleLogicaEjb.deleteIncludingFiles(earSimple, fitxerEjb);
    }

    @Override
    public EarSimpleJPA create(HttpServletRequest request, EarSimpleJPA earSimple)
            throws I18NException, I18NValidationException {
        return (EarSimpleJPA) earSimpleLogicaEjb.create(earSimple);
    }

    @Override
    public EarSimpleJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earSimpleID) throws I18NException {
        return (EarSimpleJPA) earSimpleLogicaEjb.findByPrimaryKey(earSimpleID);
    }

    @Override
    public EarSimpleJPA update(HttpServletRequest request, EarSimpleJPA earSimple)
            throws I18NException, I18NValidationException {
        return (EarSimpleJPA) earSimpleLogicaEjb.update(earSimple);
    }

    public String earWarInfoToString(EarWarInfo earWarInfo) {
        String result = "";
        result += "FileName: " + earWarInfo.getFileName() + "\n";
        result += "RedhatJarsToModules: " + earWarInfo.getRedhatJarsToModules() + "\n";
        result += "JbossDeploymentStructure: " + earWarInfo.getJbossDeploymentStructure() + "\n";
        result += "PotencialCanviDeJarAModul: " + earWarInfo.getPotencialCanviDeJarAModul() + "\n";
        result += "Errors: " + earWarInfo.getErrors() + "\n";
        return result;
    }
}
