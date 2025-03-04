package org.fundaciobit.powertoys.back.controller.all;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.logic.EarInfoPublicLogicaService;
import org.fundaciobit.powertoys.logic.EarPublicLogicaService;
import org.fundaciobit.powertoys.logic.FitxerPublicLogicaService;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar.EarWarInfo;
import org.fundaciobit.powertoys.back.controller.PowerToysFilesFormManager;
import org.fundaciobit.powertoys.back.controller.webdb.EarController;
import org.fundaciobit.powertoys.back.form.webdb.EarFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.EarForm;
import org.fundaciobit.powertoys.model.entity.Ear;
import org.fundaciobit.powertoys.model.entity.EarInfo;
import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.powertoys.model.fields.EarFields;
import org.fundaciobit.powertoys.model.fields.EarInfoFields;
import org.fundaciobit.powertoys.persistence.EarJPA;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

// @MenuOption(labelCode = "ear.ear.plural", order = 2, group = "PUBLIC", addSeparatorBefore = false)
@Controller
@RequestMapping(value = "/public/earNoSimple")
@SessionAttributes(types = { EarForm.class, EarFilterForm.class })
public class EarNoSimplePublicController extends EarController {

    @Override
    public boolean isActiveList() {
        return false;
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
        // TODO:deixar aquest si es deixaaquesta funcionalitat
        // return false;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return false;
        // TODO:deixar aquest si es deixaaquesta funcionalitat
        // return true;
    }

    @EJB(mappedName = EarInfoPublicLogicaService.JNDI_NAME)
    protected EarInfoPublicLogicaService earInfoLogicaEjb;

    @EJB(mappedName = EarPublicLogicaService.JNDI_NAME)
    protected EarPublicLogicaService earLogicaEjb;

    @EJB(mappedName = FitxerPublicLogicaService.JNDI_NAME)
    protected FitxerPublicLogicaService fitxerLogicaEjb;

    @Override
    protected FilesFormManager<Fitxer> getFilesFormManager() {
        return new PowerToysFilesFormManager(fitxerLogicaEjb);
    }

    @Override
    public String getTileForm() {
        return "earNoSimpleFormPublic";

    }

    @Override
    public String getTileList() {
        return "earNoSimpleListPublic";
    }

    @Override
    public EarFilterForm getEarFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EarFilterForm earFilterForm;
        earFilterForm = super.getEarFilterForm(pagina, mav, request);

        if (earFilterForm.isNou()) {
            earFilterForm.addHiddenField(EarFields.EARID);
            earFilterForm.addHiddenField(EarFields.NOM);

            earFilterForm.setEditButtonVisible(false);
            earFilterForm.setAddButtonVisible(false);
            earFilterForm.setViewButtonVisible(false);

            AdditionalButton processEarButton = new AdditionalButton("fas fa-upload", "ear.processarear",
                    getContextWeb() + "/new", AdditionalButtonStyle.PRIMARY);
            earFilterForm.addAdditionalButton(processEarButton);

            earFilterForm.setOrderBy(EarFields.DATA.getJavaName());
            earFilterForm.setOrderAsc(false);
        }

        return earFilterForm;
    }

    @Override
    public EarForm getEarForm(EarJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EarForm earForm = super.getEarForm(_jpa, __isView, request, mav);

        if (earForm.isNou()) {
            earForm.addHiddenField(EarFields.NOM);
            earForm.addHiddenField(EarFields.DATA);

            earForm.setSaveButtonVisible(false);
            AdditionalButton processEarButton = new AdditionalButton("fas fa-file-import", "ear.processar",
                    "javascript:$('form#earForm').submit();", AdditionalButtonStyle.PRIMARY);
            earForm.addAdditionalButton(processEarButton);

            earForm.setTitleCode("ear.processarearnosimple");
        }

        earForm.setCancelButtonVisible(false);
        AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
        earForm.addAdditionalButton(returnButton);

        return earForm;
    }

    @Override
    public void preValidate(HttpServletRequest request, EarForm earForm, BindingResult result)
            throws I18NException {
        log.info("EAR al preValidate");

        EarJPA ear = earForm.getEar();

        Fitxer fitxer = fitxerEjb.findByPrimaryKey(ear.getFitxerID());
        String nom = fitxer.getNom();

        log.info("Fitxer EAR al preValidate, actualitzam nom i data");

        ear.setNom(nom);
        ear.setData(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, EarForm earForm) {
        log.info("fitxer EAR llegit al preValidate, actualitzam nom i detall");

        EarJPA ear = earForm.getEar();
        long newId = ear.getEarID();

        HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("ear.processat", ear.getFitxer().getNom()));

        return "redirect:" + getContextWeb() + "/view/" + newId;
    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav, EarFilterForm filterForm, List<Ear> list)
            throws I18NException {
        filterForm.getAdditionalButtonsByPK().clear();

        for (Ear e : list) {
            long earID = e.getEarID();
            AdditionalButton infoEarButton = new AdditionalButton("fas fa-eye", "ear.veureear",
                    getContextWeb() + "/veureEarInfos/" + earID,
                    AdditionalButtonStyle.INFO);

            filterForm.addAdditionalButtonByPK(earID, infoEarButton);
        }
    }

    @RequestMapping(value = "/veureEarInfos/{earID}")
    public String veureEarInfos(HttpServletRequest request, HttpServletResponse response,
            @PathVariable Long earID) throws I18NException {

        request.getSession().setAttribute("earID", earID);
        log.info("Redirigint per a verue els earInfo de l'EAR " + earID);

        return "redirect:" + (new EarInfoPublicController()).getContextWeb() + "/list/1";
    }

    @Override
    public void delete(HttpServletRequest request, Ear ear) throws I18NException {
        earInfoLogicaEjb.delete(EarInfoFields.EARID.equal(ear.getEarID()));
        earLogicaEjb.deleteIncludingFiles(ear, fitxerEjb);
    }

    @Override
    public EarJPA create(HttpServletRequest request, EarJPA ear)
            throws I18NException, I18NValidationException {
        log.info("Processant EAR al create");
        Fitxer fitxer = fitxerEjb.findByPrimaryKey(ear.getFitxerID());
        String nom = fitxer.getNom();

        File earWarFile = null;
        List<EarWarInfo> trobats = new ArrayList<EarWarInfo>();
        earWarFile = FileSystemManager.getFile(ear.getFitxerID());
        try {
            SearchJBossModulesInEar.processFileEarWar(earWarFile, nom, trobats);
        } catch (Exception e) {
            String missatgeError = "Error a l'actualitzar el nom i detall de l'EAR: " + e.getMessage();
            HtmlUtils.saveMessageError(request, missatgeError);
            log.error(missatgeError, e);
            throw new I18NException("genapp.comodi", missatgeError);
        }

        log.info("trobats al create: " + trobats.size());
        log.info("fitxer EAR llegit al create, actualitzam base de dades");

        // Actualitzam BD:
        EarJPA earJPA = (EarJPA) earLogicaEjb.create(ear);
        long newId = earJPA.getEarID();

        String detall = "";
        List<EarInfo> earInfoCreats = new ArrayList<EarInfo>();
        for (EarWarInfo earWarInfo : trobats) {
            try {
                String errors = "<p style=\"font-family: Courier;\">" + earWarInfo.getErrors() + "</p>";
                String redhatJarsToModules = "<p style=\"font-family: Courier;\">" + earWarInfo.getRedhatJarsToModules()
                        + "</p>";
                String jbossDeploymentStructure = "<p style=\"font-family: Courier;\">"
                        + earWarInfo.getJbossDeploymentStructure() + "</p>";
                String potencialCanviDeJarAModul = "<p style=\"font-family: Courier;\">"
                        + earWarInfo.getPotencialCanviDeJarAModul() + "</p>";

                earInfoCreats.add(earInfoLogicaEjb.create(newId, earWarInfo.getFileName(),
                        errors,
                        redhatJarsToModules, jbossDeploymentStructure,
                        potencialCanviDeJarAModul));
            } catch (Exception e) {
                String missatgeError = "Error al crear l'EarInfo amb fileName " + earWarInfo.getFileName() + ": "
                        + e.getMessage();
                HtmlUtils.saveMessageError(request, missatgeError);
                log.error(missatgeError, e);
            }
            detall += earWarInfoToString(earWarInfo) + "\n";
            detall += "--------------------------------------\n";
        }
        log.info("trobats detall: " + detall);

        if (earInfoCreats.size() < trobats.size()) {
            try {
                for (EarInfo earInfo : earInfoCreats) {
                    earInfoLogicaEjb.delete(earInfo);
                }
                earLogicaEjb.deleteIncludingFiles(ear, fitxerEjb);
            } catch (Exception e) {
                String missatgeError = "Error al esborrar els EarInfo creats: " + e.getMessage();
                HtmlUtils.saveMessageError(request, missatgeError);
                log.error(missatgeError);
            }

            String missatgeError = "No s'han pogut crear tots els EarInfo";
            HtmlUtils.saveMessageError(request, missatgeError);
            log.error(missatgeError);
            throw new I18NException("genapp.comodi", missatgeError);
        }

        return earJPA;
    }

    @Override
    public EarJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earID) throws I18NException {
        return (EarJPA) earLogicaEjb.findByPrimaryKey(earID);
    }

    @Override
    public EarJPA update(HttpServletRequest request, EarJPA ear)
            throws I18NException, I18NValidationException {
        return (EarJPA) earLogicaEjb.update(ear);
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
