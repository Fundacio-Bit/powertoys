package org.fundaciobit.powertoys.back.controller.webdb;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.utils.Utils;
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

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.fundaciobit.powertoys.back.form.webdb.*;
import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioForm;

import org.fundaciobit.powertoys.back.validator.webdb.RepoCompilacioWebValidator;

import org.fundaciobit.powertoys.persistence.RepoCompilacioJPA;
import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un RepoCompilacio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="repoCompilacio.repoCompilacio.plural", order=90, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/repoCompilacio")
@SessionAttributes(types = { RepoCompilacioForm.class, RepoCompilacioFilterForm.class })
public class RepoCompilacioController
    extends org.fundaciobit.powertoys.back.controller.PowerToysBaseController<RepoCompilacio, java.lang.Long> implements RepoCompilacioFields {

  @EJB(mappedName = org.fundaciobit.powertoys.ejb.RepoCompilacioService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.RepoCompilacioService repoCompilacioEjb;

  @Autowired
  private RepoCompilacioWebValidator repoCompilacioWebValidator;

  @Autowired
  protected RepoCompilacioRefList repoCompilacioRefList;

  /**
   * Llistat de totes RepoCompilacio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    RepoCompilacioFilterForm ff;
    ff = (RepoCompilacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar RepoCompilacio de forma paginada
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
    llistat(mav, request, getRepoCompilacioFilterForm(pagina, mav, request));
    return mav;
  }

  public RepoCompilacioFilterForm getRepoCompilacioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    RepoCompilacioFilterForm repoCompilacioFilterForm;
    repoCompilacioFilterForm = (RepoCompilacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(repoCompilacioFilterForm == null) {
      repoCompilacioFilterForm = new RepoCompilacioFilterForm();
      repoCompilacioFilterForm.setContexte(getContextWeb());
      repoCompilacioFilterForm.setEntityNameCode(getEntityNameCode());
      repoCompilacioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      repoCompilacioFilterForm.setNou(true);
    } else {
      repoCompilacioFilterForm.setNou(false);
    }
    repoCompilacioFilterForm.setPage(pagina == null ? 1 : pagina);
    return repoCompilacioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar RepoCompilacio de forma paginada
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
      @ModelAttribute RepoCompilacioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getRepoCompilacioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de RepoCompilacio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<RepoCompilacio> llistat(ModelAndView mav, HttpServletRequest request,
     RepoCompilacioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<RepoCompilacio> repoCompilacio = processarLlistat(repoCompilacioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("repoCompilacioItems", repoCompilacio);

    mav.addObject("repoCompilacioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, repoCompilacio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, repoCompilacio);

    return repoCompilacio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(RepoCompilacioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<RepoCompilacio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field organitzacioGitHub
    {
      _listSKV = getReferenceListForOrganitzacioGitHub(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForOrganitzacioGitHub(_tmp);
      if (filterForm.getGroupByFields().contains(ORGANITZACIOGITHUB)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ORGANITZACIOGITHUB, false);
      };
    }

    // Field repositoriGitHub
    {
      _listSKV = getReferenceListForRepositoriGitHub(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForRepositoriGitHub(_tmp);
      if (filterForm.getGroupByFields().contains(REPOSITORIGITHUB)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, REPOSITORIGITHUB, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ACTIU);


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    RepoCompilacioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<RepoCompilacio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_REPOCOMPILACIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ORGANITZACIOGITHUB, filterForm.getMapOfValuesForOrganitzacioGitHub());
    __mapping.put(REPOSITORIGITHUB, filterForm.getMapOfValuesForRepositoriGitHub());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou RepoCompilacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearRepoCompilacioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    RepoCompilacioForm repoCompilacioForm = getRepoCompilacioForm(null, false, request, mav);
    mav.addObject("repoCompilacioForm" ,repoCompilacioForm);
    fillReferencesForForm(repoCompilacioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public RepoCompilacioForm getRepoCompilacioForm(RepoCompilacioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    RepoCompilacioForm repoCompilacioForm;
    if(_jpa == null) {
      repoCompilacioForm = new RepoCompilacioForm(new RepoCompilacioJPA(), true);
    } else {
      repoCompilacioForm = new RepoCompilacioForm(_jpa, false);
      repoCompilacioForm.setView(__isView);
    }
    repoCompilacioForm.setContexte(getContextWeb());
    repoCompilacioForm.setEntityNameCode(getEntityNameCode());
    repoCompilacioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return repoCompilacioForm;
  }

  public void fillReferencesForForm(RepoCompilacioForm repoCompilacioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (repoCompilacioForm.getListOfValuesForOrganitzacioGitHub() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForOrganitzacioGitHub(request, mav, repoCompilacioForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      repoCompilacioForm.setListOfValuesForOrganitzacioGitHub(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (repoCompilacioForm.getListOfValuesForRepositoriGitHub() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForRepositoriGitHub(request, mav, repoCompilacioForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      repoCompilacioForm.setListOfValuesForRepositoriGitHub(_listSKV);
    }
    
  }

  /**
   * Guardar un nou RepoCompilacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearRepoCompilacioPost(@ModelAttribute RepoCompilacioForm repoCompilacioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    RepoCompilacioJPA repoCompilacio = repoCompilacioForm.getRepoCompilacio();

    try {
      preValidate(request, repoCompilacioForm, result);
      getWebValidator().validate(repoCompilacioForm, result);
      postValidate(request,repoCompilacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        repoCompilacio = create(request, repoCompilacio);
        createMessageSuccess(request, "success.creation", repoCompilacio.getRepocompilacioID());
        repoCompilacioForm.setRepoCompilacio(repoCompilacio);
        return getRedirectWhenCreated(request, repoCompilacioForm);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{repocompilacioID}", method = RequestMethod.GET)
  public ModelAndView veureRepoCompilacioGet(@PathVariable("repocompilacioID") java.lang.Long repocompilacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewRepoCompilacioGet(repocompilacioID,
        request, response, true);
  }


  protected ModelAndView editAndViewRepoCompilacioGet(@PathVariable("repocompilacioID") java.lang.Long repocompilacioID,
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
    RepoCompilacioJPA repoCompilacio = findByPrimaryKey(request, repocompilacioID);

    if (repoCompilacio == null) {
      createMessageWarning(request, "error.notfound", repocompilacioID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      RepoCompilacioForm repoCompilacioForm = getRepoCompilacioForm(repoCompilacio, __isView, request, mav);
      repoCompilacioForm.setView(__isView);
      if(__isView) {
        repoCompilacioForm.setAllFieldsReadOnly(ALL_REPOCOMPILACIO_FIELDS);
        repoCompilacioForm.setSaveButtonVisible(false);
        repoCompilacioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(repoCompilacioForm, request, mav);
      mav.addObject("repoCompilacioForm", repoCompilacioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un RepoCompilacio existent
   */
  @RequestMapping(value = "/{repocompilacioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarRepoCompilacioGet(@PathVariable("repocompilacioID") java.lang.Long repocompilacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewRepoCompilacioGet(repocompilacioID,
        request, response, false);
  }



  /**
   * Editar un RepoCompilacio existent
   */
  @RequestMapping(value = "/{repocompilacioID}/edit", method = RequestMethod.POST)
  public String editarRepoCompilacioPost(@ModelAttribute RepoCompilacioForm repoCompilacioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    RepoCompilacioJPA repoCompilacio = repoCompilacioForm.getRepoCompilacio();

    try {
      preValidate(request, repoCompilacioForm, result);
      getWebValidator().validate(repoCompilacioForm, result);
      postValidate(request, repoCompilacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        repoCompilacio = update(request, repoCompilacio);
        createMessageSuccess(request, "success.modification", repoCompilacio.getRepocompilacioID());
        status.setComplete();
        return getRedirectWhenModified(request, repoCompilacioForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          repoCompilacio.getRepocompilacioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, repoCompilacioForm, __e);
    }

  }


  /**
   * Eliminar un RepoCompilacio existent
   */
  @RequestMapping(value = "/{repocompilacioID}/delete")
  public String eliminarRepoCompilacio(@PathVariable("repocompilacioID") java.lang.Long repocompilacioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      RepoCompilacio repoCompilacio = this.findByPrimaryKey(request, repocompilacioID);
      if (repoCompilacio == null) {
        String __msg = createMessageError(request, "error.notfound", repocompilacioID);
        return getRedirectWhenDelete(request, repocompilacioID, new Exception(__msg));
      } else {
        delete(request, repoCompilacio);
        createMessageSuccess(request, "success.deleted", repocompilacioID);
        return getRedirectWhenDelete(request, repocompilacioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", repocompilacioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, repocompilacioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute RepoCompilacioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarRepoCompilacio(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __repocompilacioID, Throwable e) {
    java.lang.Long repocompilacioID = (java.lang.Long)__repocompilacioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (repocompilacioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(repocompilacioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "repoCompilacio.repoCompilacio";
  }

  public String getEntityNameCodePlural() {
    return "repoCompilacio.repoCompilacio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("repoCompilacio.repocompilacioID");
  }

  @InitBinder("repoCompilacioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("repoCompilacioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "repoCompilacio.repocompilacioID");
  }

  public RepoCompilacioWebValidator getWebValidator() {
    return repoCompilacioWebValidator;
  }


  public void setWebValidator(RepoCompilacioWebValidator __val) {
    if (__val != null) {
      this.repoCompilacioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de RepoCompilacio
   */
  @RequestMapping(value = "/{repocompilacioID}/cancel")
  public String cancelRepoCompilacio(@PathVariable("repocompilacioID") java.lang.Long repocompilacioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, repocompilacioID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de RepoCompilacio
   */
  @RequestMapping(value = "/cancel")
  public String cancelRepoCompilacio(HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, null);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
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


  public List<StringKeyValue> getReferenceListForOrganitzacioGitHub(HttpServletRequest request,
       ModelAndView mav, RepoCompilacioForm repoCompilacioForm, Where where)  throws I18NException {
    if (repoCompilacioForm.isHiddenField(ORGANITZACIOGITHUB)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForOrganitzacioGitHub(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForOrganitzacioGitHub(HttpServletRequest request,
       ModelAndView mav, RepoCompilacioFilterForm repoCompilacioFilterForm,
       List<RepoCompilacio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (repoCompilacioFilterForm.isHiddenField(ORGANITZACIOGITHUB)
       && !repoCompilacioFilterForm.isGroupByField(ORGANITZACIOGITHUB)
       && !repoCompilacioFilterForm.isFilterByField(ORGANITZACIOGITHUB)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForOrganitzacioGitHub(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForOrganitzacioGitHub(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("org1" , "org1"));
    __tmp.add(new StringKeyValue("org2" , "org2"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForRepositoriGitHub(HttpServletRequest request,
       ModelAndView mav, RepoCompilacioForm repoCompilacioForm, Where where)  throws I18NException {
    if (repoCompilacioForm.isHiddenField(REPOSITORIGITHUB)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForRepositoriGitHub(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForRepositoriGitHub(HttpServletRequest request,
       ModelAndView mav, RepoCompilacioFilterForm repoCompilacioFilterForm,
       List<RepoCompilacio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (repoCompilacioFilterForm.isHiddenField(REPOSITORIGITHUB)
       && !repoCompilacioFilterForm.isGroupByField(REPOSITORIGITHUB)
       && !repoCompilacioFilterForm.isFilterByField(REPOSITORIGITHUB)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForRepositoriGitHub(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForRepositoriGitHub(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("repo1" , "repo1"));
    __tmp.add(new StringKeyValue("repo2" , "repo2"));
    return __tmp;
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,RepoCompilacioForm repoCompilacioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,RepoCompilacioForm repoCompilacioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, RepoCompilacioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, RepoCompilacioFilterForm filterForm,  List<RepoCompilacio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, RepoCompilacioForm repoCompilacioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, RepoCompilacioForm repoCompilacioForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long repocompilacioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long repocompilacioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "repoCompilacioFormWebDB";
  }

  public String getTileList() {
    return "repoCompilacioListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "RepoCompilacio_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public RepoCompilacioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long repocompilacioID) throws I18NException {
    return (RepoCompilacioJPA) repoCompilacioEjb.findByPrimaryKey(repocompilacioID);
  }


  public RepoCompilacioJPA create(HttpServletRequest request, RepoCompilacioJPA repoCompilacio)
    throws I18NException, I18NValidationException {
    return (RepoCompilacioJPA) repoCompilacioEjb.create(repoCompilacio);
  }


  public RepoCompilacioJPA update(HttpServletRequest request, RepoCompilacioJPA repoCompilacio)
    throws I18NException, I18NValidationException {
    return (RepoCompilacioJPA) repoCompilacioEjb.update(repoCompilacio);
  }


  public void delete(HttpServletRequest request, RepoCompilacio repoCompilacio) throws I18NException {
    repoCompilacioEjb.delete(repoCompilacio);
  }

} // Final de Classe

