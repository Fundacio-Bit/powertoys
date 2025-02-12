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
import org.fundaciobit.powertoys.back.form.webdb.EarSimpleForm;

import org.fundaciobit.powertoys.back.validator.webdb.EarSimpleWebValidator;

import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.powertoys.persistence.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.powertoys.persistence.EarSimpleJPA;
import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un EarSimple
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="earSimple.earSimple.plural", order=20, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/earSimple")
@SessionAttributes(types = { EarSimpleForm.class, EarSimpleFilterForm.class })
public class EarSimpleController
    extends org.fundaciobit.powertoys.back.controller.PowerToysFilesBaseController<EarSimple, java.lang.Long, EarSimpleForm> implements EarSimpleFields {

  @EJB(mappedName = org.fundaciobit.powertoys.ejb.EarSimpleService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarSimpleService earSimpleEjb;

  @Autowired
  private EarSimpleWebValidator earSimpleWebValidator;

  @Autowired
  protected EarSimpleRefList earSimpleRefList;

  /**
   * Llistat de totes EarSimple
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EarSimpleFilterForm ff;
    ff = (EarSimpleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar EarSimple de forma paginada
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
    llistat(mav, request, getEarSimpleFilterForm(pagina, mav, request));
    return mav;
  }

  public EarSimpleFilterForm getEarSimpleFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EarSimpleFilterForm earSimpleFilterForm;
    earSimpleFilterForm = (EarSimpleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(earSimpleFilterForm == null) {
      earSimpleFilterForm = new EarSimpleFilterForm();
      earSimpleFilterForm.setContexte(getContextWeb());
      earSimpleFilterForm.setEntityNameCode(getEntityNameCode());
      earSimpleFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      earSimpleFilterForm.setNou(true);
    } else {
      earSimpleFilterForm.setNou(false);
    }
    earSimpleFilterForm.setPage(pagina == null ? 1 : pagina);
    return earSimpleFilterForm;
  }

  /**
   * Segona i següent peticions per llistar EarSimple de forma paginada
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
      @ModelAttribute EarSimpleFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEarSimpleFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de EarSimple de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<EarSimple> llistat(ModelAndView mav, HttpServletRequest request,
     EarSimpleFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<EarSimple> earSimple = processarLlistat(earSimpleEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("earSimpleItems", earSimple);

    mav.addObject("earSimpleFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, earSimple, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, earSimple);

    return earSimple;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EarSimpleFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<EarSimple> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    EarSimpleFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<EarSimple> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_EARSIMPLE_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou EarSimple
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEarSimpleGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EarSimpleForm earSimpleForm = getEarSimpleForm(null, false, request, mav);
    mav.addObject("earSimpleForm" ,earSimpleForm);
    fillReferencesForForm(earSimpleForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EarSimpleForm getEarSimpleForm(EarSimpleJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EarSimpleForm earSimpleForm;
    if(_jpa == null) {
      earSimpleForm = new EarSimpleForm(new EarSimpleJPA(), true);
    } else {
      earSimpleForm = new EarSimpleForm(_jpa, false);
      earSimpleForm.setView(__isView);
    }
    earSimpleForm.setContexte(getContextWeb());
    earSimpleForm.setEntityNameCode(getEntityNameCode());
    earSimpleForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return earSimpleForm;
  }

  public void fillReferencesForForm(EarSimpleForm earSimpleForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou EarSimple
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEarSimplePost(@ModelAttribute EarSimpleForm earSimpleForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EarSimpleJPA earSimple = earSimpleForm.getEarSimple();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, earSimple, earSimpleForm); // FILE
      preValidate(request, earSimpleForm, result);
      getWebValidator().validate(earSimpleForm, result);
      postValidate(request,earSimpleForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        earSimple = create(request, earSimple);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", earSimple.getEarSimpleID());
        earSimpleForm.setEarSimple(earSimple);
        return getRedirectWhenCreated(request, earSimpleForm);
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

  @RequestMapping(value = "/view/{earSimpleID}", method = RequestMethod.GET)
  public ModelAndView veureEarSimpleGet(@PathVariable("earSimpleID") java.lang.Long earSimpleID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarSimpleGet(earSimpleID,
        request, response, true);
  }


  protected ModelAndView editAndViewEarSimpleGet(@PathVariable("earSimpleID") java.lang.Long earSimpleID,
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
    EarSimpleJPA earSimple = findByPrimaryKey(request, earSimpleID);

    if (earSimple == null) {
      createMessageWarning(request, "error.notfound", earSimpleID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EarSimpleForm earSimpleForm = getEarSimpleForm(earSimple, __isView, request, mav);
      earSimpleForm.setView(__isView);
      if(__isView) {
        earSimpleForm.setAllFieldsReadOnly(ALL_EARSIMPLE_FIELDS);
        earSimpleForm.setSaveButtonVisible(false);
        earSimpleForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(earSimpleForm, request, mav);
      mav.addObject("earSimpleForm", earSimpleForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un EarSimple existent
   */
  @RequestMapping(value = "/{earSimpleID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEarSimpleGet(@PathVariable("earSimpleID") java.lang.Long earSimpleID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarSimpleGet(earSimpleID,
        request, response, false);
  }



  /**
   * Editar un EarSimple existent
   */
  @RequestMapping(value = "/{earSimpleID}/edit", method = RequestMethod.POST)
  public String editarEarSimplePost(@ModelAttribute EarSimpleForm earSimpleForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EarSimpleJPA earSimple = earSimpleForm.getEarSimple();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, earSimple, earSimpleForm); // FILE
      preValidate(request, earSimpleForm, result);
      getWebValidator().validate(earSimpleForm, result);
      postValidate(request, earSimpleForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        earSimple = update(request, earSimple);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", earSimple.getEarSimpleID());
        status.setComplete();
        return getRedirectWhenModified(request, earSimpleForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          earSimple.getEarSimpleID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, earSimpleForm, __e);
    }

  }


  /**
   * Eliminar un EarSimple existent
   */
  @RequestMapping(value = "/{earSimpleID}/delete")
  public String eliminarEarSimple(@PathVariable("earSimpleID") java.lang.Long earSimpleID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      EarSimple earSimple = this.findByPrimaryKey(request, earSimpleID);
      if (earSimple == null) {
        String __msg = createMessageError(request, "error.notfound", earSimpleID);
        return getRedirectWhenDelete(request, earSimpleID, new Exception(__msg));
      } else {
        delete(request, earSimple);
        createMessageSuccess(request, "success.deleted", earSimpleID);
        return getRedirectWhenDelete(request, earSimpleID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", earSimpleID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, earSimpleID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute EarSimpleFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEarSimple(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __earSimpleID, Throwable e) {
    java.lang.Long earSimpleID = (java.lang.Long)__earSimpleID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (earSimpleID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(earSimpleID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "earSimple.earSimple";
  }

  public String getEntityNameCodePlural() {
    return "earSimple.earSimple.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("earSimple.earSimpleID");
  }

  @InitBinder("earSimpleFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("earSimpleForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "earSimple.earSimpleID");
  }

  public EarSimpleWebValidator getWebValidator() {
    return earSimpleWebValidator;
  }


  public void setWebValidator(EarSimpleWebValidator __val) {
    if (__val != null) {
      this.earSimpleWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de EarSimple
   */
  @RequestMapping(value = "/{earSimpleID}/cancel")
  public String cancelEarSimple(@PathVariable("earSimpleID") java.lang.Long earSimpleID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, earSimpleID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de EarSimple
   */
  @RequestMapping(value = "/cancel")
  public String cancelEarSimple(HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, null);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, EarSimple earSimple,
      EarSimpleForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxerID(), form.isFitxerIDDelete(),
        form.isNou()? null : earSimple.getFitxer());
    ((EarSimpleJPA)earSimple).setFitxer(f);
    if (f != null) { 
      earSimple.setFitxerID(f.getFitxerID());
    } else {
      earSimple.setFitxerID(0);
    }

  }

  // FILE
  @Override
  public void deleteFiles(EarSimple earSimple) {
    deleteFile(earSimple.getFitxerID());
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

  public void preValidate(HttpServletRequest request,EarSimpleForm earSimpleForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EarSimpleForm earSimpleForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EarSimpleFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EarSimpleFilterForm filterForm,  List<EarSimple> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EarSimpleForm earSimpleForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EarSimpleForm earSimpleForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long earSimpleID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long earSimpleID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "earSimpleFormWebDB";
  }

  public String getTileList() {
    return "earSimpleListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "EarSimple_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EarSimpleJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earSimpleID) throws I18NException {
    return (EarSimpleJPA) earSimpleEjb.findByPrimaryKey(earSimpleID);
  }


  public EarSimpleJPA create(HttpServletRequest request, EarSimpleJPA earSimple)
    throws I18NException, I18NValidationException {
    return (EarSimpleJPA) earSimpleEjb.create(earSimple);
  }


  public EarSimpleJPA update(HttpServletRequest request, EarSimpleJPA earSimple)
    throws I18NException, I18NValidationException {
    return (EarSimpleJPA) earSimpleEjb.update(earSimple);
  }


  public void delete(HttpServletRequest request, EarSimple earSimple) throws I18NException {
    earSimpleEjb.delete(earSimple);
  }

} // Final de Classe

