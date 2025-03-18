package org.fundaciobit.powertoys.back.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.back.controller.webdb.RepoCompilacioController;
import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioForm;
import org.fundaciobit.powertoys.logic.RepoCompilacioAdminLogicaService;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.fundaciobit.powertoys.model.fields.RepoCompilacioFields;
import org.fundaciobit.powertoys.persistence.RepoCompilacioJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@MenuOption(labelCode = "repoCompilacio.repoCompilacio.plural", order = 3, group = "ADMIN", addSeparatorBefore = true)
@Controller
@RequestMapping(value = RepoCompilacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { RepoCompilacioForm.class, RepoCompilacioFilterForm.class })
public class RepoCompilacioAdminController extends RepoCompilacioController {

  public static final String CONTEXTWEB = "/admin/repocompilacio";

  @EJB(mappedName = RepoCompilacioAdminLogicaService.JNDI_NAME)
  protected RepoCompilacioAdminLogicaService repoCompilacioLogicaEjb;

  @Override
  public String getTileForm() {
    return "repoCompilacioFormAdmin";
  }

  @Override
  public String getTileList() {
    return "repoCompilacioListAdmin";
  }

  @Override
  public RepoCompilacioFilterForm getRepoCompilacioFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request)
      throws I18NException {
    RepoCompilacioFilterForm repoCompilacioFilterForm;
    repoCompilacioFilterForm = super.getRepoCompilacioFilterForm(pagina, mav, request);

    if (repoCompilacioFilterForm.isNou()) {
      repoCompilacioFilterForm.addHiddenField(RepoCompilacioFields.REPOCOMPILACIOID);

      // repoCompilacioFilterForm.setEditButtonVisible(false);
      // repoCompilacioFilterForm.setAddButtonVisible(false);
      // repoCompilacioFilterForm.setDeleteButtonVisible(false);
      AdditionalButton veureExecucionsNocturnesButton = new AdditionalButton("fas fa-eye",
          "repocompilacio.veurecompilacions",
          getContextWeb() + "/veureExecucionsNocturnes", AdditionalButtonStyle.PRIMARY);
      repoCompilacioFilterForm.addAdditionalButton(veureExecucionsNocturnesButton);

      repoCompilacioFilterForm.setOrderBy(RepoCompilacioFields.ORDRE.getJavaName());
      // repoCompilacioFilterForm.setOrderAsc(false);
    }

    return repoCompilacioFilterForm;
  }

  @Override
  public RepoCompilacioForm getRepoCompilacioForm(RepoCompilacioJPA _jpa, boolean __isView, HttpServletRequest request,
      ModelAndView mav) throws I18NException {
    RepoCompilacioForm repoComilacioForm = super.getRepoCompilacioForm(_jpa, __isView, request, mav);

    List<StringKeyValue> orgs = new ArrayList<>();
    List<StringKeyValue> repos = new ArrayList<>();
    for (String org : repoCompilacioLogicaEjb.getOrganizations()) {
      orgs.add(new StringKeyValue(org, org));
      try {
        repoCompilacioLogicaEjb.getRepositories(org).forEach(repo -> {
          repos.add(new StringKeyValue(repo.getName(), repo.getFullName()));
        });
      } catch (Exception e) {
        String missatgeError = "Error al consultar els repositoris de l'organització " + org + ": " + e.getMessage();
        HtmlUtils.saveMessageError(request, missatgeError);
        log.error(missatgeError, e);
        throw new I18NException("genapp.comodi", missatgeError);
      }
    }
    repoComilacioForm.setListOfValuesForOrganitzacioGitHub(orgs);
    repoComilacioForm.setListOfValuesForRepositoriGitHub(repos);

    if (repoComilacioForm.isNou()) {
      repoComilacioForm.getRepoCompilacio().setActiu(true);

      // repoComilacioForm.setReadOnlyFields(new
      // HashSet<Field<?>>(Arrays.asList(RepoCompilacioFields.NOM)) );
    }

    // repoComilacioForm.setCancelButtonVisible(false);
    // AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left",
    // "ear.tornar",
    // getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
    // repoComilacioForm.addAdditionalButton(returnButton);

    return repoComilacioForm;
  }

  @Override
  public void postList(HttpServletRequest request, ModelAndView mav, RepoCompilacioFilterForm filterForm,
      List<RepoCompilacio> list)
      throws I18NException {
    filterForm.getAdditionalButtonsByPK().clear();

    for (RepoCompilacio r : list) {
      long repoID = r.getRepocompilacioID();
      String jsOpenModalContinuar = "javascript:createDivModal(traduccions.type['titol.compilacio.continuar'], traduccions.type['missatge.compilacio.continuar'], '"
          + request.getContextPath() + getContextWeb() + "/executeCompilacio/" + repoID
          + "', '', 'execute-comp-id', 'fa-play-circle');\r\n" + //
          "        $('#execute-comp-id').modal('show');\r\n";
      AdditionalButton executeCompButton = new AdditionalButton("fas fa-play-circle",
          "repocompilacio.executarcompilacio",
          jsOpenModalContinuar,
          AdditionalButtonStyle.INFO);
      // AdditionalButton executeCompButton = new AdditionalButton("fas
      // fa-play-circle",
      // "repocompilacio.executarcompilacio",
      // getContextWeb() + "/executeCompilacio/" + repoID,
      // AdditionalButtonStyle.INFO);

      filterForm.addAdditionalButtonByPK(repoID, executeCompButton);
    }
  }

  @RequestMapping(value = "/veureExecucionsNocturnes")
  public String veureExecucionsNocturnes(HttpServletRequest request, HttpServletResponse response)
      throws I18NException {

    log.info("Redirigint per a veure les execucions nocturnes");

    return "redirect:" + (new CompilacioAdminController()).getContextWeb() + "/list/1";
  }

  @RequestMapping(value = "/executeCompilacio/{repoCompilacioID}")
  public String executeCompilacio(HttpServletRequest request, HttpServletResponse response,
      @PathVariable Long repoCompilacioID) throws I18NException {

    log.info("Executant compilació forçada del repositori " + repoCompilacioID);

    RepoCompilacioJPA repoAcompilar = findByPrimaryKey(request, repoCompilacioID);
    Compilacio compilacioFeta;
    try {
      compilacioFeta = repoCompilacioLogicaEjb.descarregarICompilarLatestTag(repoAcompilar);
    } catch (Exception e) {
      String missatgeError = "Error al descarregar i compilar el repositori " + repoCompilacioID + ": "
          + repoAcompilar.getNom() + ": " + e.getMessage();
      HtmlUtils.saveMessageError(request, missatgeError);
      log.error(missatgeError, e);
      throw new I18NException("genapp.comodi", missatgeError);
    }

    String missatge = "Compilació forçada del repositori " + repoCompilacioID + " executada correctament: "
        + repoAcompilar.getNom();
    HtmlUtils.saveMessageSuccess(request, missatge);
    log.info(missatge);
    log.info("CODI DE SORTIDA: " + compilacioFeta.getExitCode());
    log.info("SORTIDA: " + compilacioFeta.getOutput());

    return "redirect:" + (new CompilacioAdminController()).getContextWeb() + "/list/1";
  }

}
