package org.fundaciobit.powertoys.back.controller.webdb;

import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.validation.ValidationWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.fundaciobit.powertoys.back.form.webdb.*;
import org.fundaciobit.powertoys.back.form.webdb.EarForm;

import org.fundaciobit.powertoys.back.validator.webdb.EarWebValidator;

import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.powertoys.persistence.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.powertoys.persistence.EarJPA;
import org.fundaciobit.powertoys.model.entity.Ear;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un Ear
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="ear.ear.plural", order=0, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/ear")
@SessionAttributes(types = { EarForm.class, EarFilterForm.class })
public class EarController
    extends org.fundaciobit.powertoys.back.controller.powertoysFilesBaseController<Ear, java.lang.Long, EarForm> implements EarFields {

  @EJB(mappedName = org.fundaciobit.powertoys.ejb.EarService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarService earEjb;

  @Autowired
  private EarWebValidator earWebValidator;

  @Autowired
  protected EarRefList earRefList;

  /**
   * Llistat de totes Ear
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EarFilterForm ff;
    ff = (EarFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Ear de forma paginada
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.GET)
  public ModelAndView llistatPaginat(HttpServletRequest request,
    HttpServletResponse response, @PathVariable Integer pagina)
      throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileList());
    llistat(mav, request, getEarFilterForm(pagina, mav, request));
    return mav;
  }

  public EarFilterForm getEarFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EarFilterForm earFilterForm;
    earFilterForm = (EarFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(earFilterForm == null) {
      earFilterForm = new EarFilterForm();
      earFilterForm.setContexte(getContextWeb());
      earFilterForm.setEntityNameCode(getEntityNameCode());
      earFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      earFilterForm.setNou(true);
    } else {
      earFilterForm.setNou(false);
    }
    earFilterForm.setPage(pagina == null ? 1 : pagina);
    return earFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Ear de forma paginada
   * 
   * @param request
   * @param pagina
   * @param filterForm
   * @return
   * @throws I18NException
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.POST)
  public ModelAndView llistatPaginat(HttpServletRequest request,
      HttpServletResponse response,@PathVariable Integer pagina,
      @ModelAttribute EarFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEarFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Ear de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Ear> llistat(ModelAndView mav, HttpServletRequest request,
     EarFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Ear> ear = processarLlistat(earEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("earItems", ear);

    mav.addObject("earFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, ear, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, ear);

    return ear;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EarFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Ear> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    EarFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Ear> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_EAR_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Ear
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEarGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EarForm earForm = getEarForm(null, false, request, mav);
    mav.addObject("earForm" ,earForm);
    fillReferencesForForm(earForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EarForm getEarForm(EarJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EarForm earForm;
    if(_jpa == null) {
      earForm = new EarForm(new EarJPA(), true);
    } else {
      earForm = new EarForm(_jpa, false);
      earForm.setView(__isView);
    }
    earForm.setContexte(getContextWeb());
    earForm.setEntityNameCode(getEntityNameCode());
    earForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return earForm;
  }

  public void fillReferencesForForm(EarForm earForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Ear
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEarPost(@ModelAttribute EarForm earForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EarJPA ear = earForm.getEar();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, ear, earForm); // FILE
      preValidate(request, earForm, result);
      getWebValidator().validate(earForm, result);
      postValidate(request,earForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        ear = create(request, ear);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", ear.getEarID());
        earForm.setEar(ear);
        return getRedirectWhenCreated(request, earForm);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{earID}", method = RequestMethod.GET)
  public ModelAndView veureEarGet(@PathVariable("earID") java.lang.Long earID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarGet(earID,
        request, response, true);
  }


  protected ModelAndView editAndViewEarGet(@PathVariable("earID") java.lang.Long earID,
      HttpServletRequest request,
      HttpServletResponse response, boolean __isView) throws I18NException {
    if((!__isView) && !isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      if(__isView && !isActiveFormView()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
      }
    }
    EarJPA ear = findByPrimaryKey(request, earID);

    if (ear == null) {
      createMessageWarning(request, "error.notfound", earID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EarForm earForm = getEarForm(ear, __isView, request, mav);
      earForm.setView(__isView);
      if(__isView) {
        earForm.setAllFieldsReadOnly(ALL_EAR_FIELDS);
        earForm.setSaveButtonVisible(false);
        earForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(earForm, request, mav);
      mav.addObject("earForm", earForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Ear existent
   */
  @RequestMapping(value = "/{earID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEarGet(@PathVariable("earID") java.lang.Long earID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarGet(earID,
        request, response, false);
  }



  /**
   * Editar un Ear existent
   */
  @RequestMapping(value = "/{earID}/edit", method = RequestMethod.POST)
  public String editarEarPost(@ModelAttribute EarForm earForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EarJPA ear = earForm.getEar();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, ear, earForm); // FILE
      preValidate(request, earForm, result);
      getWebValidator().validate(earForm, result);
      postValidate(request, earForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        ear = update(request, ear);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", ear.getEarID());
        status.setComplete();
        return getRedirectWhenModified(request, earForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          ear.getEarID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, earForm, __e);
    }

  }


  /**
   * Eliminar un Ear existent
   */
  @RequestMapping(value = "/{earID}/delete")
  public String eliminarEar(@PathVariable("earID") java.lang.Long earID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Ear ear = this.findByPrimaryKey(request, earID);
      if (ear == null) {
        String __msg = createMessageError(request, "error.notfound", earID);
        return getRedirectWhenDelete(request, earID, new Exception(__msg));
      } else {
        delete(request, ear);
        createMessageSuccess(request, "success.deleted", earID);
        return getRedirectWhenDelete(request, earID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", earID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, earID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute EarFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEar(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return java.lang.Long.parseLong(value, 10);
}

  @Override
  public String[] getArgumentsMissatge(Object __earID, Throwable e) {
    java.lang.Long earID = (java.lang.Long)__earID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (earID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(earID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "ear.ear";
  }

  public String getEntityNameCodePlural() {
    return "ear.ear.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("ear.earID");
  }

  @InitBinder("earFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("earForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "ear.earID");
  }

  public EarWebValidator getWebValidator() {
    return earWebValidator;
  }


  public void setWebValidator(EarWebValidator __val) {
    if (__val != null) {
      this.earWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Ear
   */
  @RequestMapping(value = "/{earID}/cancel")
  public String cancelEar(@PathVariable("earID") java.lang.Long earID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, earID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Ear
   */
  @RequestMapping(value = "/cancel")
  public String cancelEar(HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, null);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, Ear ear,
      EarForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxerID(), form.isFitxerIDDelete(),
        form.isNou()? null : ear.getFitxer());
    ((EarJPA)ear).setFitxer(f);
    if (f != null) { 
      ear.setFitxerID(f.getFitxerID());
    } else {
      ear.setFitxerID(0);
    }

  }

  // FILE
  @Override
  public void deleteFiles(Ear ear) {
    deleteFile(ear.getFitxerID());
  }
  // Mètodes a sobreescriure 

  public boolean isActiveList() {
    return true;
  }


  public boolean isActiveFormNew() {
    return true;
  }


  public boolean isActiveFormEdit() {
    return true;
  }


  public boolean isActiveDelete() {
    return true;
  }


  public boolean isActiveFormView() {
    return isActiveFormEdit();
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,EarForm earForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EarForm earForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EarFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EarFilterForm filterForm,  List<Ear> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EarForm earForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EarForm earForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long earID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long earID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "earFormWebDB";
  }

  public String getTileList() {
    return "earListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Ear_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EarJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earID) throws I18NException {
    return (EarJPA) earEjb.findByPrimaryKey(earID);
  }


  public EarJPA create(HttpServletRequest request, EarJPA ear)
    throws I18NException, I18NValidationException {
    return (EarJPA) earEjb.create(ear);
  }


  public EarJPA update(HttpServletRequest request, EarJPA ear)
    throws I18NException, I18NValidationException {
    return (EarJPA) earEjb.update(ear);
  }


  public void delete(HttpServletRequest request, Ear ear) throws I18NException {
    earEjb.delete(ear);
  }

} // Final de Classe

