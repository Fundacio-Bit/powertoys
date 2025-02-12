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
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.fundaciobit.powertoys.back.form.webdb.*;
import org.fundaciobit.powertoys.back.form.webdb.EarInfoForm;

import org.fundaciobit.powertoys.back.validator.webdb.EarInfoWebValidator;

import org.fundaciobit.powertoys.persistence.EarInfoJPA;
import org.fundaciobit.powertoys.model.entity.EarInfo;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un EarInfo
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="earInfo.earInfo.plural", order=10, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/earInfo")
@SessionAttributes(types = { EarInfoForm.class, EarInfoFilterForm.class })
public class EarInfoController
    extends org.fundaciobit.powertoys.back.controller.PowerToysBaseController<EarInfo, java.lang.Long> implements EarInfoFields {

  @EJB(mappedName = org.fundaciobit.powertoys.ejb.EarInfoService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarInfoService earInfoEjb;

  @Autowired
  private EarInfoWebValidator earInfoWebValidator;

  @Autowired
  protected EarInfoRefList earInfoRefList;

  // References 
  @Autowired
  protected EarRefList earRefList;

  /**
   * Llistat de totes EarInfo
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EarInfoFilterForm ff;
    ff = (EarInfoFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar EarInfo de forma paginada
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
    llistat(mav, request, getEarInfoFilterForm(pagina, mav, request));
    return mav;
  }

  public EarInfoFilterForm getEarInfoFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EarInfoFilterForm earInfoFilterForm;
    earInfoFilterForm = (EarInfoFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(earInfoFilterForm == null) {
      earInfoFilterForm = new EarInfoFilterForm();
      earInfoFilterForm.setContexte(getContextWeb());
      earInfoFilterForm.setEntityNameCode(getEntityNameCode());
      earInfoFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      earInfoFilterForm.setNou(true);
    } else {
      earInfoFilterForm.setNou(false);
    }
    earInfoFilterForm.setPage(pagina == null ? 1 : pagina);
    return earInfoFilterForm;
  }

  /**
   * Segona i següent peticions per llistar EarInfo de forma paginada
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
      @ModelAttribute EarInfoFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEarInfoFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de EarInfo de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<EarInfo> llistat(ModelAndView mav, HttpServletRequest request,
     EarInfoFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<EarInfo> earInfo = processarLlistat(earInfoEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("earInfoItems", earInfo);

    mav.addObject("earInfoFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, earInfo, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, earInfo);

    return earInfo;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EarInfoFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<EarInfo> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field earid
    {
      _listSKV = getReferenceListForEarid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfEarForEarid(_tmp);
      if (filterForm.getGroupByFields().contains(EARID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, EARID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    EarInfoFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<EarInfo> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_EARINFO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(EARID, filterForm.getMapOfEarForEarid());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou EarInfo
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEarInfoGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EarInfoForm earInfoForm = getEarInfoForm(null, false, request, mav);
    mav.addObject("earInfoForm" ,earInfoForm);
    fillReferencesForForm(earInfoForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EarInfoForm getEarInfoForm(EarInfoJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EarInfoForm earInfoForm;
    if(_jpa == null) {
      earInfoForm = new EarInfoForm(new EarInfoJPA(), true);
    } else {
      earInfoForm = new EarInfoForm(_jpa, false);
      earInfoForm.setView(__isView);
    }
    earInfoForm.setContexte(getContextWeb());
    earInfoForm.setEntityNameCode(getEntityNameCode());
    earInfoForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return earInfoForm;
  }

  public void fillReferencesForForm(EarInfoForm earInfoForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (earInfoForm.getListOfEarForEarid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForEarid(request, mav, earInfoForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      earInfoForm.setListOfEarForEarid(_listSKV);
    }
    
  }

  /**
   * Guardar un nou EarInfo
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEarInfoPost(@ModelAttribute EarInfoForm earInfoForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EarInfoJPA earInfo = earInfoForm.getEarInfo();

    try {
      preValidate(request, earInfoForm, result);
      getWebValidator().validate(earInfoForm, result);
      postValidate(request,earInfoForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        earInfo = create(request, earInfo);
        createMessageSuccess(request, "success.creation", earInfo.getEarinfoID());
        earInfoForm.setEarInfo(earInfo);
        return getRedirectWhenCreated(request, earInfoForm);
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

  @RequestMapping(value = "/view/{earinfoID}", method = RequestMethod.GET)
  public ModelAndView veureEarInfoGet(@PathVariable("earinfoID") java.lang.Long earinfoID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarInfoGet(earinfoID,
        request, response, true);
  }


  protected ModelAndView editAndViewEarInfoGet(@PathVariable("earinfoID") java.lang.Long earinfoID,
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
    EarInfoJPA earInfo = findByPrimaryKey(request, earinfoID);

    if (earInfo == null) {
      createMessageWarning(request, "error.notfound", earinfoID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EarInfoForm earInfoForm = getEarInfoForm(earInfo, __isView, request, mav);
      earInfoForm.setView(__isView);
      if(__isView) {
        earInfoForm.setAllFieldsReadOnly(ALL_EARINFO_FIELDS);
        earInfoForm.setSaveButtonVisible(false);
        earInfoForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(earInfoForm, request, mav);
      mav.addObject("earInfoForm", earInfoForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un EarInfo existent
   */
  @RequestMapping(value = "/{earinfoID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEarInfoGet(@PathVariable("earinfoID") java.lang.Long earinfoID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEarInfoGet(earinfoID,
        request, response, false);
  }



  /**
   * Editar un EarInfo existent
   */
  @RequestMapping(value = "/{earinfoID}/edit", method = RequestMethod.POST)
  public String editarEarInfoPost(@ModelAttribute EarInfoForm earInfoForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EarInfoJPA earInfo = earInfoForm.getEarInfo();

    try {
      preValidate(request, earInfoForm, result);
      getWebValidator().validate(earInfoForm, result);
      postValidate(request, earInfoForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        earInfo = update(request, earInfo);
        createMessageSuccess(request, "success.modification", earInfo.getEarinfoID());
        status.setComplete();
        return getRedirectWhenModified(request, earInfoForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          earInfo.getEarinfoID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, earInfoForm, __e);
    }

  }


  /**
   * Eliminar un EarInfo existent
   */
  @RequestMapping(value = "/{earinfoID}/delete")
  public String eliminarEarInfo(@PathVariable("earinfoID") java.lang.Long earinfoID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      EarInfo earInfo = this.findByPrimaryKey(request, earinfoID);
      if (earInfo == null) {
        String __msg = createMessageError(request, "error.notfound", earinfoID);
        return getRedirectWhenDelete(request, earinfoID, new Exception(__msg));
      } else {
        delete(request, earInfo);
        createMessageSuccess(request, "success.deleted", earinfoID);
        return getRedirectWhenDelete(request, earinfoID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", earinfoID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, earinfoID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute EarInfoFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEarInfo(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __earinfoID, Throwable e) {
    java.lang.Long earinfoID = (java.lang.Long)__earinfoID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (earinfoID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(earinfoID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "earInfo.earInfo";
  }

  public String getEntityNameCodePlural() {
    return "earInfo.earInfo.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("earInfo.earinfoID");
  }

  @InitBinder("earInfoFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("earInfoForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "earInfo.earinfoID");
  }

  public EarInfoWebValidator getWebValidator() {
    return earInfoWebValidator;
  }


  public void setWebValidator(EarInfoWebValidator __val) {
    if (__val != null) {
      this.earInfoWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de EarInfo
   */
  @RequestMapping(value = "/{earinfoID}/cancel")
  public String cancelEarInfo(@PathVariable("earinfoID") java.lang.Long earinfoID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, earinfoID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de EarInfo
   */
  @RequestMapping(value = "/cancel")
  public String cancelEarInfo(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForEarid(HttpServletRequest request,
       ModelAndView mav, EarInfoForm earInfoForm, Where where)  throws I18NException {
    if (earInfoForm.isHiddenField(EARID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (earInfoForm.isReadOnlyField(EARID)) {
      _where = EarFields.EARID.equal(earInfoForm.getEarInfo().getEarid());
    }
    return getReferenceListForEarid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForEarid(HttpServletRequest request,
       ModelAndView mav, EarInfoFilterForm earInfoFilterForm,
       List<EarInfo> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (earInfoFilterForm.isHiddenField(EARID)
       && !earInfoFilterForm.isGroupByField(EARID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(EARID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (EarInfo _item : list) {
        _pkList.add(_item.getEarid());
        }
        _w = EarFields.EARID.in(_pkList);
      }
    return getReferenceListForEarid(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForEarid(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return earRefList.getReferenceList(EarFields.EARID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,EarInfoForm earInfoForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EarInfoForm earInfoForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EarInfoFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EarInfoFilterForm filterForm,  List<EarInfo> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EarInfoForm earInfoForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EarInfoForm earInfoForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long earinfoID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long earinfoID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "earInfoFormWebDB";
  }

  public String getTileList() {
    return "earInfoListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "EarInfo_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EarInfoJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earinfoID) throws I18NException {
    return (EarInfoJPA) earInfoEjb.findByPrimaryKey(earinfoID);
  }


  public EarInfoJPA create(HttpServletRequest request, EarInfoJPA earInfo)
    throws I18NException, I18NValidationException {
    return (EarInfoJPA) earInfoEjb.create(earInfo);
  }


  public EarInfoJPA update(HttpServletRequest request, EarInfoJPA earInfo)
    throws I18NException, I18NValidationException {
    return (EarInfoJPA) earInfoEjb.update(earInfo);
  }


  public void delete(HttpServletRequest request, EarInfo earInfo) throws I18NException {
    earInfoEjb.delete(earInfo);
  }

} // Final de Classe

