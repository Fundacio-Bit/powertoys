package org.fundaciobit.powertoys.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.powertoys.back.controller.webdb.CompilacioController;
import org.fundaciobit.powertoys.back.form.webdb.CompilacioFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.CompilacioForm;
import org.fundaciobit.powertoys.model.fields.CompilacioFields;
import org.fundaciobit.powertoys.persistence.CompilacioJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/compilacio")
@SessionAttributes(types = { CompilacioForm.class, CompilacioFilterForm.class })
public class CompilacioAdminController extends CompilacioController {

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return true;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public String getTileForm() {
        return "compilacioFormAdmin";
    }

    @Override
    public String getTileList() {
        return "compilacioListAdmin";
    }

    @Override
    public CompilacioFilterForm getCompilacioFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        CompilacioFilterForm compilacioFilterForm;
        compilacioFilterForm = super.getCompilacioFilterForm(pagina, mav, request);

        if (compilacioFilterForm.isNou()) {
            compilacioFilterForm.addHiddenField(CompilacioFields.COMPILACIOID);
            compilacioFilterForm.addHiddenField(CompilacioFields.OUTPUT);

            compilacioFilterForm.setAddButtonVisible(false);
            compilacioFilterForm.setEditButtonVisible(false);
            // compilacioFilterForm.setDeleteButtonVisible(false);
            compilacioFilterForm.setViewButtonVisible(true);
            AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                    (new RepoCompilacioAdminController()).getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
            compilacioFilterForm.addAdditionalButton(returnButton);
        }

        return compilacioFilterForm;
    }

    @Override
    public CompilacioForm getCompilacioForm(CompilacioJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        CompilacioForm compilacioForm = super.getCompilacioForm(_jpa, __isView, request, mav);

        compilacioForm.setCancelButtonVisible(false);
        AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
        compilacioForm.addAdditionalButton(returnButton);

        return compilacioForm;
    }
}
