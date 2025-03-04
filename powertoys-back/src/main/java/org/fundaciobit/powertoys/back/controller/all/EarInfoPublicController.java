package org.fundaciobit.powertoys.back.controller.all;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.powertoys.logic.EarInfoPublicLogicaService;
import org.fundaciobit.powertoys.logic.EarPublicLogicaService;
import org.fundaciobit.powertoys.model.fields.EarInfoFields;
import org.fundaciobit.powertoys.back.controller.webdb.EarInfoController;
import org.fundaciobit.powertoys.back.form.webdb.EarInfoFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.EarInfoForm;
import org.fundaciobit.powertoys.persistence.EarInfoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/public/earInfo")
@SessionAttributes(types = { EarInfoForm.class, EarInfoFilterForm.class })
public class EarInfoPublicController extends EarInfoController {

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
        // TODO:deixar aquest si es deixaaquesta funcionalitat
        // return true;
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

    @Override
    public String getTileForm() {
        return "earInfoFormPublic";

    }

    @Override
    public String getTileList() {
        return "earInfoListPublic";
    }

    @Override
    public EarInfoFilterForm getEarInfoFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EarInfoFilterForm earInfoFilterForm;
        earInfoFilterForm = super.getEarInfoFilterForm(pagina, mav, request);

        if (earInfoFilterForm.isNou()) {
            earInfoFilterForm.setAddButtonVisible(false);
            earInfoFilterForm.setEditButtonVisible(false);
            earInfoFilterForm.setDeleteButtonVisible(false);
            AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                    (new EarNoSimplePublicController()).getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
            earInfoFilterForm.addAdditionalButton(returnButton);
        }

        return earInfoFilterForm;
    }

    @Override
    public EarInfoForm getEarInfoForm(EarInfoJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EarInfoForm earInfoForm = super.getEarInfoForm(_jpa, __isView, request, mav);

        earInfoForm.setCancelButtonVisible(false);
        AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
        earInfoForm.addAdditionalButton(returnButton);

        return earInfoForm;
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        long earId = (long) request.getSession().getAttribute("earID");
        return EarInfoFields.EARID.equal(earId);
    }

    @Override
    public EarInfoJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earInfoID) throws I18NException {
        return (EarInfoJPA) earInfoLogicaEjb.findByPrimaryKey(earInfoID);
    }
}
