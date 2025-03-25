package org.fundaciobit.powertoys.back.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.powertoys.back.controller.webdb.CompilacioController;
import org.fundaciobit.powertoys.back.form.webdb.CompilacioFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.CompilacioForm;
import org.fundaciobit.powertoys.commons.utils.Constants;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.fields.CompilacioFields;
import org.fundaciobit.powertoys.persistence.CompilacioJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author jpou
 *
 */
@Controller
@RequestMapping(value = CompilacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { CompilacioForm.class, CompilacioFilterForm.class })
public class CompilacioAdminController extends CompilacioController {

    public static final String CONTEXTWEB = "/admin/compilacio";

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
            compilacioFilterForm.setDeleteButtonVisible(false);// ja l'habilitarem per a cada fila que correspongui
            compilacioFilterForm.setViewButtonVisible(true);
            AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                    RepoCompilacioAdminController.CONTEXTWEB + "/list/1", AdditionalButtonStyle.DANGER);
            compilacioFilterForm.addAdditionalButton(returnButton);

            compilacioFilterForm.setOrderBy(CompilacioFields.DATAFI.getJavaName());
            compilacioFilterForm.setOrderAsc(false);

            // convertirem CompilacioFields.EXITCODE en columna "Resultat"
            compilacioFilterForm.addHiddenField(CompilacioFields.EXITCODE);
            AdditionalField<Long, String> additionalField = new AdditionalField<Long, String>();
            additionalField.setCodeName("compilacio.resultat");
            // additionalField.setCodeName("=" + I18NUtils.tradueix("compilacio.resultat")+
            // "<br/>");
            additionalField.setPosition(1);
            additionalField.setEscapeXml(false);
            // Els valors s'ompliran al mètode postList()
            additionalField.setValueMap(new HashMap<Long, String>());
            compilacioFilterForm.addAdditionalField(additionalField);
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
        CompilacioJPA compilacio = compilacioForm.getCompilacio();
        AdditionalButton refreshButton = new AdditionalButton("fas fa-sync-alt", "compilacio.refrescar",
                getContextWeb() + "/view/" + compilacio.getCompilacioID(),
                AdditionalButtonStyle.INFO);
        compilacioForm.addAdditionalButton(refreshButton);

        if (compilacio.getExitCode() == Constants.EXIT_CODE_IN_PROGRESS) {
            compilacioForm.setDeleteButtonVisible(false);
            HtmlUtils.saveMessageInfo(request, I18NUtils.tradueix("compilacio.encurs"));
        }
        return compilacioForm;
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        HttpSession session = request.getSession();
        Object repoIdAttr = session.getAttribute(RepoCompilacioAdminController.REPO_ID_SESSION_ATTRIBUTE_NAME);
        if (repoIdAttr != null) {
            long repoID = (long) repoIdAttr;
            // session.removeAttribute(RepoCompilacioAdminController.REPO_ID_SESSION_ATTRIBUTE_NAME);
            return CompilacioFields.REPOCOMPILACIOID.equal(repoID);
        }

        return null;
    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav, CompilacioFilterForm filterForm,
            List<Compilacio> list) throws I18NException {
        Map<Long, String> codiSortidaN = (Map<Long, String>) filterForm.getAdditionalField(1)
                .getValueMap();
        filterForm.getAdditionalButtonsByPK().clear();

        for (Compilacio compilacio : list) {
            String resultatCellContent = "";
            boolean mostrarBotoDelete = false;
            long compilacioId = compilacio.getCompilacioID();

            if (compilacio.getExitCode() == Constants.EXIT_CODE_NO_ERRORS) {
                resultatCellContent = "<div style=\"margin: 5px auto;display: table;\"><img src=\""
                        + request.getContextPath() + "/img/icn_alert_success.png\" alt=\"ok\" title=\"ok\"/></div>";
                mostrarBotoDelete = true;
            } else if (compilacio.getExitCode() == Constants.EXIT_CODE_IN_PROGRESS) {
                resultatCellContent = "<div class=\"spinner spinner-18px\" title=\""
                        + I18NUtils.tradueix("compilacio.encurs") + "\"></div>";
            } else {
                resultatCellContent = "<div style=\"margin: 5px auto;display: table;\"><img src=\""
                        + request.getContextPath() + "/img/icn_alert_error.png\" alt=\"error\" title=\"error\"/></div>";
                mostrarBotoDelete = true;
            }

            StringBuilder str = new StringBuilder();
            str.append(resultatCellContent);
            codiSortidaN.put(compilacioId, str.toString());

            if (mostrarBotoDelete) {
                AdditionalButton deleteButton = new AdditionalButton("fas fa-trash", "genapp.delete",
                        "javascript:openModal('" + request.getContextPath() + getContextWeb() + "/"
                                + compilacioId + "/delete','show');",
                        AdditionalButtonStyle.DANGER);
                filterForm.addAdditionalButtonByPK(compilacioId, deleteButton);
            }
        }
    }

    @Override
    public void delete(HttpServletRequest request, Compilacio compilacio) throws I18NException {
        if (compilacio.getExitCode() == Constants.EXIT_CODE_IN_PROGRESS) {
            throw new I18NException("compilacio.encurs");
        }
        compilacioEjb.delete(compilacio);
    }
}
