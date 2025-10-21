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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;

import org.fundaciobit.powertoys.back.form.webdb.*;
import org.fundaciobit.powertoys.back.form.webdb.CompilacioForm;

import org.fundaciobit.powertoys.back.validator.webdb.CompilacioWebValidator;

import org.fundaciobit.powertoys.persistence.CompilacioJPA;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.genapp.common.web.tiles.Tile;
import org.fundaciobit.genapp.common.web.tiles.TileAttribute;
import org.fundaciobit.genapp.common.web.tiles.TileType;
import org.fundaciobit.powertoys.back.utils.Tab;

/**
 * Controller per gestionar un Compilacio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="compilacio.compilacio.plural", order=10, group=Tab.MENU_WEBDB)
@Controller
@RequestMapping(value = "/webdb/compilacio")
@SessionAttributes(types = { CompilacioForm.class, CompilacioFilterForm.class })
@Tile(name="compilacioFormWebDB", contentJsp="/WEB-INF/jsp/webdb/compilacioForm.jsp", extendsTile=Tab.MENU_WEBDB,
      type=TileType.WEBDB_FORM , attributes={ @TileAttribute(name="titol", value="compilacio.compilacio")})
@Tile(name="compilacioListWebDB", contentJsp="/WEB-INF/jsp/webdb/compilacioList.jsp", extendsTile=Tab.MENU_WEBDB,
       type=TileType.WEBDB_LIST, attributes={ @TileAttribute(name="titol", value="compilacio.compilacio") })
public class CompilacioController
    extends org.fundaciobit.powertoys.back.controller.PowerToysBaseController<Compilacio, java.lang.Long> implements CompilacioFields {

  @EJB(mappedName = org.fundaciobit.powertoys.ejb.CompilacioService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.CompilacioService compilacioEjb;

  @Autowired
  private CompilacioWebValidator compilacioWebValidator;

  @Autowired
  protected CompilacioRefList compilacioRefList;

  // References 
  @Autowired
  protected RepoCompilacioRefList repoCompilacioRefList;

  /**
   * Llistat de totes Compilacio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    CompilacioFilterForm ff;
    ff = (CompilacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Compilacio de forma paginada
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
    llistat(mav, request, getCompilacioFilterForm(pagina, mav, request));
    return mav;
  }

  public CompilacioFilterForm getCompilacioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    CompilacioFilterForm compilacioFilterForm;
    compilacioFilterForm = (CompilacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(compilacioFilterForm == null) {
      compilacioFilterForm = new CompilacioFilterForm();
      compilacioFilterForm.setContexte(getContextWeb());
      compilacioFilterForm.setEntityNameCode(getEntityNameCode());
      compilacioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      compilacioFilterForm.setNou(true);
    } else {
      compilacioFilterForm.setNou(false);
    }
    compilacioFilterForm.setPage(pagina == null ? 1 : pagina);
    return compilacioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Compilacio de forma paginada
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
      @ModelAttribute CompilacioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getCompilacioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Compilacio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Compilacio> llistat(ModelAndView mav, HttpServletRequest request,
     CompilacioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Compilacio> compilacio = processarLlistat(compilacioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("compilacioItems", compilacio);

    mav.addObject("compilacioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, compilacio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, compilacio);

    return compilacio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(CompilacioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Compilacio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field repocompilacioID
    {
      _listSKV = getReferenceListForRepocompilacioID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfRepoCompilacioForRepocompilacioID(_tmp);
      if (filterForm.getGroupByFields().contains(REPOCOMPILACIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, REPOCOMPILACIOID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    CompilacioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Compilacio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_COMPILACIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(REPOCOMPILACIOID, filterForm.getMapOfRepoCompilacioForRepocompilacioID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Compilacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearCompilacioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    CompilacioForm compilacioForm = getCompilacioForm(null, false, request, mav);
    mav.addObject("compilacioForm" ,compilacioForm);
    fillReferencesForForm(compilacioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public CompilacioForm getCompilacioForm(CompilacioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    CompilacioForm compilacioForm;
    if(_jpa == null) {
      compilacioForm = new CompilacioForm(new CompilacioJPA(), true);
    } else {
      compilacioForm = new CompilacioForm(_jpa, false);
      compilacioForm.setView(__isView);
    }
    compilacioForm.setContexte(getContextWeb());
    compilacioForm.setEntityNameCode(getEntityNameCode());
    compilacioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return compilacioForm;
  }

  public void fillReferencesForForm(CompilacioForm compilacioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (compilacioForm.getListOfRepoCompilacioForRepocompilacioID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForRepocompilacioID(request, mav, compilacioForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      compilacioForm.setListOfRepoCompilacioForRepocompilacioID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Compilacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearCompilacioPost(@ModelAttribute CompilacioForm compilacioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    CompilacioJPA compilacio = compilacioForm.getCompilacio();

    try {
      preValidate(request, compilacioForm, result);
      getWebValidator().validate(compilacioForm, result);
      postValidate(request,compilacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        compilacio = create(request, compilacio);
        createMessageSuccess(request, "success.creation", compilacio.getCompilacioID());
        compilacioForm.setCompilacio(compilacio);
        return getRedirectWhenCreated(request, compilacioForm);
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

  @RequestMapping(value = "/view/{compilacioID}", method = RequestMethod.GET)
  public ModelAndView veureCompilacioGet(@PathVariable("compilacioID") java.lang.Long compilacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewCompilacioGet(compilacioID,
        request, response, true);
  }


  protected ModelAndView editAndViewCompilacioGet(@PathVariable("compilacioID") java.lang.Long compilacioID,
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
    CompilacioJPA compilacio = findByPrimaryKey(request, compilacioID);

    if (compilacio == null) {
      createMessageWarning(request, "error.notfound", compilacioID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      CompilacioForm compilacioForm = getCompilacioForm(compilacio, __isView, request, mav);
      compilacioForm.setView(__isView);
      if(__isView) {
        compilacioForm.setAllFieldsReadOnly(ALL_COMPILACIO_FIELDS);
        compilacioForm.setSaveButtonVisible(false);
        compilacioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(compilacioForm, request, mav);
      mav.addObject("compilacioForm", compilacioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Compilacio existent
   */
  @RequestMapping(value = "/{compilacioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarCompilacioGet(@PathVariable("compilacioID") java.lang.Long compilacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewCompilacioGet(compilacioID,
        request, response, false);
  }



  /**
   * Editar un Compilacio existent
   */
  @RequestMapping(value = "/{compilacioID}/edit", method = RequestMethod.POST)
  public String editarCompilacioPost(@ModelAttribute CompilacioForm compilacioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    CompilacioJPA compilacio = compilacioForm.getCompilacio();

    try {
      preValidate(request, compilacioForm, result);
      getWebValidator().validate(compilacioForm, result);
      postValidate(request, compilacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        compilacio = update(request, compilacio);
        createMessageSuccess(request, "success.modification", compilacio.getCompilacioID());
        status.setComplete();
        return getRedirectWhenModified(request, compilacioForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          compilacio.getCompilacioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, compilacioForm, __e);
    }

  }


  /**
   * Eliminar un Compilacio existent
   */
  @RequestMapping(value = "/{compilacioID}/delete")
  public String eliminarCompilacio(@PathVariable("compilacioID") java.lang.Long compilacioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Compilacio compilacio = this.findByPrimaryKey(request, compilacioID);
      if (compilacio == null) {
        String __msg = createMessageError(request, "error.notfound", compilacioID);
        return getRedirectWhenDelete(request, compilacioID, new Exception(__msg));
      } else {
        delete(request, compilacio);
        createMessageSuccess(request, "success.deleted", compilacioID);
        return getRedirectWhenDelete(request, compilacioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", compilacioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, compilacioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute CompilacioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarCompilacio(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __compilacioID, Throwable e) {
    java.lang.Long compilacioID = (java.lang.Long)__compilacioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (compilacioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(compilacioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "compilacio.compilacio";
  }

  public String getEntityNameCodePlural() {
    return "compilacio.compilacio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("compilacio.compilacioID");
  }

  @InitBinder("compilacioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("compilacioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "compilacio.compilacioID");
  }

  public CompilacioWebValidator getWebValidator() {
    return compilacioWebValidator;
  }


  public void setWebValidator(CompilacioWebValidator __val) {
    if (__val != null) {
      this.compilacioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Compilacio
   */
  @RequestMapping(value = "/{compilacioID}/cancel")
  public String cancelCompilacio(@PathVariable("compilacioID") java.lang.Long compilacioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, compilacioID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Compilacio
   */
  @RequestMapping(value = "/cancel")
  public String cancelCompilacio(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForRepocompilacioID(HttpServletRequest request,
       ModelAndView mav, CompilacioForm compilacioForm, Where where)  throws I18NException {
    if (compilacioForm.isHiddenField(REPOCOMPILACIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (compilacioForm.isReadOnlyField(REPOCOMPILACIOID)) {
      _where = RepoCompilacioFields.REPOCOMPILACIOID.equal(compilacioForm.getCompilacio().getRepocompilacioID());
    }
    return getReferenceListForRepocompilacioID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForRepocompilacioID(HttpServletRequest request,
       ModelAndView mav, CompilacioFilterForm compilacioFilterForm,
       List<Compilacio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (compilacioFilterForm.isHiddenField(REPOCOMPILACIOID)
       && !compilacioFilterForm.isGroupByField(REPOCOMPILACIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(REPOCOMPILACIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Compilacio _item : list) {
        _pkList.add(_item.getRepocompilacioID());
        }
        _w = RepoCompilacioFields.REPOCOMPILACIOID.in(_pkList);
      }
    return getReferenceListForRepocompilacioID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForRepocompilacioID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return repoCompilacioRefList.getReferenceList(RepoCompilacioFields.REPOCOMPILACIOID, where );
  }


    @Override
    /** Ha de ser igual que el RequestMapping de la Classe */
    public String getContextWeb() {
        RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
        final String[] values = rm.value();
        if (values.length == 1) {
            return values[0];
        } else {
            final HttpServletRequest request;
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            final String servletPath = request.getServletPath();

            for (String webcontext : values) {
                if (servletPath.startsWith(webcontext)) {
                    return webcontext;
                }
            }

            log.warn(" No puc trobar el contextweb associat a la cridada.");
            log.warn(" ==== RequestMapping::value=" + Arrays.toString(values));
            log.warn(" ++++ getContextWeb::Scheme: " + request.getScheme());
            log.warn(" ++++ getContextWeb::PathInfo: " + request.getPathInfo());
            log.warn(" ++++ getContextWeb::PathTrans: " + request.getPathTranslated());
            log.warn(" ++++ getContextWeb::ContextPath: " + request.getContextPath());
            log.warn(" ++++ getContextWeb::ServletPath: " + request.getServletPath());
            log.warn(" ++++ getContextWeb::getRequestURI: " + request.getRequestURI());
            log.warn(" ++++ getContextWeb::getRequestURL: " + request.getRequestURL().toString());
            log.warn(" ++++ getContextWeb::getQueryString: " + request.getQueryString());

            return values[0];
        }  }

  public void preValidate(HttpServletRequest request,CompilacioForm compilacioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,CompilacioForm compilacioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, CompilacioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, CompilacioFilterForm filterForm,  List<Compilacio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, CompilacioForm compilacioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, CompilacioForm compilacioForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long compilacioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long compilacioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
        try {
            Set<Tile> rm;
            rm=AnnotationUtils.getDeclaredRepeatableAnnotations(this.getClass(), Tile.class);
            if (rm != null && !rm.isEmpty()) {
                String trobada = null;
                for (Tile tile : rm) {
                    if (tile.type() == TileType.WEBDB_FORM) {
                        trobada = tile.name();
                    }
                }
                if (trobada != null) {
                    return trobada;
                }
            }
        } catch (Exception e) {
            log.error("Error en el getTileForm: " + e.getMessage(), e);
        }
    return "compilacioFormWebDB";
  }

    public String getTileList() {
        try {
            Set<Tile> rm;
            rm=AnnotationUtils.getDeclaredRepeatableAnnotations(this.getClass(), Tile.class);
            if (rm != null && !rm.isEmpty()) {
                String trobada = null;
                for (Tile tile : rm) {
                    if (tile.type() == TileType.WEBDB_LIST) {
                        trobada = tile.name();
                    }
                }
                if (trobada != null) {
                    return trobada;
                }
            }
        } catch (Exception e) {
            log.error("Error en el getTileList: " + e.getMessage(), e);
        }
        return "compilacioListWebDB";
    }

  public String getSessionAttributeFilterForm() {
    return "Compilacio_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public CompilacioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long compilacioID) throws I18NException {
    return (CompilacioJPA) compilacioEjb.findByPrimaryKey(compilacioID);
  }


  public CompilacioJPA create(HttpServletRequest request, CompilacioJPA compilacio)
    throws I18NException, I18NValidationException {
    return (CompilacioJPA) compilacioEjb.create(compilacio);
  }


  public CompilacioJPA update(HttpServletRequest request, CompilacioJPA compilacio)
    throws I18NException, I18NValidationException {
    return (CompilacioJPA) compilacioEjb.update(compilacio);
  }


  public void delete(HttpServletRequest request, Compilacio compilacio) throws I18NException {
    compilacioEjb.delete(compilacio);
  }

} // Final de Classe

