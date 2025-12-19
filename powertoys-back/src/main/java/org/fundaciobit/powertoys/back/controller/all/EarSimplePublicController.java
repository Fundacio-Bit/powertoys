package org.fundaciobit.powertoys.back.controller.all;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.logic.EarSimplePublicLogicaService;
import org.fundaciobit.powertoys.logic.FitxerPublicLogicaService;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar;
import org.fundaciobit.powertoys.logic.earmoduls.EarWarInfo;
import org.fundaciobit.powertoys.logic.earmoduls.JBoss;
import org.fundaciobit.powertoys.logic.earmoduls.JBoss7_2_0;
import org.fundaciobit.powertoys.logic.earmoduls.JBoss7_4_0;
import org.fundaciobit.powertoys.logic.earmoduls.JbossDeploymentStructure;
import org.fundaciobit.powertoys.logic.earmoduls.RedhatJarsToModules;
import org.fundaciobit.powertoys.back.controller.PowerToysFilesFormManager;
import org.fundaciobit.powertoys.back.controller.webdb.EarSimpleController;
import org.fundaciobit.powertoys.back.form.webdb.EarSimpleFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.EarSimpleForm;
import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.powertoys.model.fields.EarSimpleFields;
import org.fundaciobit.powertoys.persistence.EarSimpleJPA;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@MenuOption(labelCode = "ear.menu", order = 1, group = "PUBLIC", addSeparatorBefore = true)
@Controller
@RequestMapping(value = "/public/earSimple")
@SessionAttributes(types = { EarSimpleForm.class, EarSimpleFilterForm.class })
public class EarSimplePublicController extends EarSimpleController {
    /*
    private static final String EARS_PUJATS_COOKIE_NAME = "__Secure_ears_pujats";
    private static final String EARS_PUJATS_COOKIE_ITEM_PREFIX = "#";
    */
    @EJB(mappedName = EarSimplePublicLogicaService.JNDI_NAME)
    protected EarSimplePublicLogicaService earSimpleLogicaEjb;

    @EJB(mappedName = FitxerPublicLogicaService.JNDI_NAME)
    protected FitxerPublicLogicaService fitxerLogicaEjb;

    @Override
    public FilesFormManager<Fitxer> getFilesFormManager() {
        return new PowerToysFilesFormManager(fitxerLogicaEjb);
    }

    @Override
    public String getTileForm() {
        return "earSimpleFormPublic";

    }

    @Override
    public String getTileList() {
        return "earSimpleListPublic";
    }

    @Override
    public EarSimpleFilterForm getEarSimpleFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EarSimpleFilterForm earSimpleFilterForm;
        earSimpleFilterForm = super.getEarSimpleFilterForm(pagina, mav, request);

        if (earSimpleFilterForm.isNou()) {

            earSimpleFilterForm.setSubTitleCode("ear.subtitle");

            earSimpleFilterForm.addHiddenField(EarSimpleFields.EARSIMPLEID);
            earSimpleFilterForm.addHiddenField(EarSimpleFields.NOM);
            earSimpleFilterForm.addHiddenField(EarSimpleFields.DETALL);

            earSimpleFilterForm.setEditButtonVisible(false);
            earSimpleFilterForm.setAddButtonVisible(false);
            earSimpleFilterForm.setViewButtonVisible(true);
            AdditionalButton processEarButton = new AdditionalButton("fas fa-upload", "ear.processarear",
                    getContextWeb() + "/new", AdditionalButtonStyle.PRIMARY);
            earSimpleFilterForm.addAdditionalButton(processEarButton);

            earSimpleFilterForm.setOrderBy(EarSimpleFields.DATA.getJavaName());
            earSimpleFilterForm.setOrderAsc(false);
        }

        return earSimpleFilterForm;
    }

    @Override
    public EarSimpleForm getEarSimpleForm(EarSimpleJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EarSimpleForm earSimpleForm = super.getEarSimpleForm(_jpa, __isView, request, mav);

        if (earSimpleForm.isNou()) {
            earSimpleForm.addHiddenField(EarSimpleFields.NOM);
            earSimpleForm.addHiddenField(EarSimpleFields.DETALL);
            earSimpleForm.addHiddenField(EarSimpleFields.DATA);

            earSimpleForm.setSaveButtonVisible(false);
            AdditionalButton processEarButton = new AdditionalButton("fas fa-file-import", "ear.processar",
                    "javascript:$('form#earSimpleForm').submit();", AdditionalButtonStyle.PRIMARY);
            earSimpleForm.addAdditionalButton(processEarButton);

            earSimpleForm.setTitleCode("ear.processarearsimple");
        }

        if (__isView) {
            earSimpleForm.getReadOnlyFields().remove(DETALL);
        }

        earSimpleForm.setSubTitleCode("ear.subtitle");

        earSimpleForm.setCancelButtonVisible(false);
        AdditionalButton returnButton = new AdditionalButton("fas fa-caret-left", "ear.tornar",
                getContextWeb() + "/list/1", AdditionalButtonStyle.DANGER);
        earSimpleForm.addAdditionalButton(returnButton);

        earSimpleForm.setAttachedAdditionalJspCode(true);

        return earSimpleForm;
    }

    @Override
    public void preValidate(HttpServletRequest request, EarSimpleForm earSimpleForm, BindingResult result)
            throws I18NException {
        log.info("Processant EAR al preValidate");

        EarSimpleJPA earSimple = earSimpleForm.getEarSimple();
        File earWarFile = null;
        List<EarWarInfo> trobats = new ArrayList<EarWarInfo>();

        Fitxer fitxer = fitxerEjb.findByPrimaryKey(earSimple.getFitxerID());
        String nom = fitxer.getNom();
        StringBuilder detall = new StringBuilder();

        earWarFile = FileSystemManager.getFile(earSimple.getFitxerID());
        try {

            String ver = earSimple.getJbossVersion();
            
            log.info(" \n\n  JBoss Version  STRING COMBOBOX: " + ver + "\n\n ");
            
            JBoss jboss;
            if (ver == null || ver.trim().length() == 0) {
                jboss = new JBoss7_2_0();
            } else if (ver.equals(JBoss7_4_0.VERSION)) {
                HtmlUtils.saveMessageInfo(request, "S'ha seleccionat la versió de JBoss " + JBoss7_4_0.VERSION);
                jboss = new JBoss7_4_0();
            } else if (ver.equals(JBoss7_2_0.VERSION)) {
                HtmlUtils.saveMessageInfo(request, "S'ha seleccionat la versió de JBoss " + JBoss7_2_0.VERSION);
                jboss = new JBoss7_2_0();
            } else {
                HtmlUtils.saveMessageWarning(request,
                        "Versió de JBoss desconeguda: " + ver + ", s'utilitzarà la " + JBoss7_2_0.VERSION);
                jboss = new JBoss7_2_0();
            }

            SearchJBossModulesInEar.processFileEarWar(earWarFile, nom, trobats, jboss);
        } catch (Exception e) {
            String missatgeError = "Error a l'actualitzar el nom i detall de l'EAR: " + e.getMessage();
            HtmlUtils.saveMessageError(request, missatgeError);
            log.error(missatgeError, e);
            throw new I18NException("genapp.comodi", missatgeError);
        }

        log.info("fitxer EAR llegit al preValidate, actualitzam nom i detall");

        detall.append("<html>\n");
        detall.append("<body>\n");

        for (EarWarInfo earWarInfo : trobats) {

            //           try {
            String info = earWarInfoToString(earWarInfo);
            if (info == null || info.isEmpty()) {
                continue;
            }

            //detall.append("<div style=\"border: 2px solid #ccc; border-radius: 15px; padding:10px;margin:10px;\">\n");
            detall.append(info);
            //detall.append("</div>\n");
            //detall.append("\n<br/>\n");
            //            } catch (Throwable e) {
            //                // TODO: handle exception
            //                String msg = "Error processant l'EAR: " + e.getMessage();
            //                HtmlUtils.saveMessageError(request, msg);
            //                log.error(msg, e);
            //            }

        }
        if (log.isDebugEnabled()) {
            log.debug("Trobats: " + detall.toString());
        }

        //detall = "<p style=\"font-family: Courier;\">" + detall.replaceAll("\n", "<br\\>\n") + "</p>";
        earSimple.setNom(nom);
        earSimple.setDetall(detall.toString()); // .replaceAll("\n", "<br\\>\n"));
        earSimple.setData(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, EarSimpleForm earSimpleForm) {
        EarSimpleJPA earSimple = earSimpleForm.getEarSimple();
        long newId = earSimple.getEarSimpleID();
        HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("ear.processat", earSimple.getFitxer().getNom()));

        return "redirect:" + getContextWeb() + "/view/" + newId;
    }

    /**
     * Eliminar un EarSimple existent
     */
    /*
    @Override
    @RequestMapping(value = "/{earSimpleID}/delete")
    public String eliminarEarSimple(@PathVariable("earSimpleID")
    java.lang.Long earSimpleID, HttpServletRequest request, HttpServletResponse response) {
        String responseStr = super.eliminarEarSimple(earSimpleID, request, response);
    
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(EARS_PUJATS_COOKIE_NAME)) {
                String newCookieValue = cookie.getValue()
                        .replace(EARS_PUJATS_COOKIE_ITEM_PREFIX + earSimpleID.toString(), "");
                cookie.setValue(newCookieValue);
    
                cookie.setPath(request.getContextPath());
                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(60 * 60 * 24 * 365);
    
                if (newCookieValue.isEmpty()) {
                    cookie.setMaxAge(0);
                    cookie.setValue(null);
                }
    
                response.addCookie(cookie);
                break;
            }
        }
    
        return responseStr;
    }
    */

    /**
     * Guardar un nou EarSimple
     */
    /*
    @Override
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String crearEarSimplePost(@ModelAttribute
    EarSimpleForm earSimpleForm, BindingResult result, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String responseStr = super.crearEarSimplePost(earSimpleForm, result, request, response);
    
        EarSimpleJPA earSimple = earSimpleForm.getEarSimple();
        long newId = earSimple.getEarSimpleID();
    
        Cookie newCookie = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(EARS_PUJATS_COOKIE_NAME)) {
                newCookie = cookie;
    
                String newCookieValue = cookie.getValue() + EARS_PUJATS_COOKIE_ITEM_PREFIX + newId;
                newCookie.setValue(newCookieValue);
                break;
            }
        }
    
        if (newCookie == null) {
            newCookie = new Cookie(EARS_PUJATS_COOKIE_NAME, EARS_PUJATS_COOKIE_ITEM_PREFIX + newId);
        }
        newCookie.setPath(request.getContextPath());
        newCookie.setSecure(true);
        newCookie.setHttpOnly(true);
        newCookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(newCookie);
    
        return responseStr;
    }
    */

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {

        /*
        List<Long> earIds = new ArrayList<Long>();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(EARS_PUJATS_COOKIE_NAME)) {
                String[] earIdsStr = cookie.getValue().split(EARS_PUJATS_COOKIE_ITEM_PREFIX);
                for (String earIdStr : earIdsStr) {
                    if (!earIdStr.isEmpty()) {
                        earIds.add(Long.parseLong(earIdStr));
                    }
                }
                break;
            }
        }
        */
        return EarSimpleFields.EARSIMPLEID.in(llegirEarsProcessatsDeCookies(request));
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public void delete(HttpServletRequest request, EarSimple earSimple) throws I18NException {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();

        earSimpleLogicaEjb.deleteIncludingFiles(earSimple, fitxerEjb);

        esborrarIdEnCookies(request, response, earSimple.getEarSimpleID());

    }

    @Override
    public EarSimpleJPA create(HttpServletRequest request, EarSimpleJPA earSimple)
            throws I18NException, I18NValidationException {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();

        EarSimpleJPA jpa = (EarSimpleJPA) earSimpleLogicaEjb.create(earSimple);

        afegirIdEnCookies(request, response, jpa.getEarSimpleID());

        return jpa;
    }

    @Override
    public EarSimpleJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long earSimpleID) throws I18NException {
        return (EarSimpleJPA) earSimpleLogicaEjb.findByPrimaryKey(earSimpleID);
    }

    @Override
    public EarSimpleJPA update(HttpServletRequest request, EarSimpleJPA earSimple)
            throws I18NException, I18NValidationException {
        return (EarSimpleJPA) earSimpleLogicaEjb.update(earSimple);
    }

    public String earWarInfoToString(EarWarInfo earWarInfo) {
        StringBuilder result = new StringBuilder();

        result.append("<h3>Fitxer " + earWarInfo.getFileName() + "</h3>\n");

        result.append("<form>");

        boolean isOK = true;

        RedhatJarsToModules redhatJarsToModules = earWarInfo.getRedhatJarsToModules();
        if (redhatJarsToModules != null) {

            result.append("<fieldset style=\"margin:10px;padding:10px;border: 3px;border-style: dashed;\" >")
                    .append("\n");
            result.append("<legend>Eliminar JARs de dins del contenidor</legend>").append("\n");

            result.append("Hem trobat els següents jars que les podem substituir per mòduls JBoss. "
                    + "El primer que hem de fer és eliminar-los del contenidor, per això afegirem dins el pom.xml del projecte "
                    + redhatJarsToModules.getFileName() + (redhatJarsToModules.isEar() ? "-ear" : "")
                    + " en el <configuration> del plugin " + redhatJarsToModules.getPlugin()
                    + " les següents entrades:<br/>\n");

            result.append("<div style=\"border: 1px; border-style: solid;padding: 10px;margin: 10px;\">\n");
            result.append("<code>\n");
            result.append(StringEscapeUtils.escapeHtml4("<packagingExcludes>")).append("<br/>\n");

            for (String jar : redhatJarsToModules.getRedhatJarsToModules()) {
                result.append(StringEscapeUtils.escapeHtml4(jar).replace("\n", "<br/>\n")).append("\n");
            }
            result.append(StringEscapeUtils.escapeHtml4("</packagingExcludes>")).append("<br/>\n");
            result.append("</code>\n");
            result.append("</div>\n");

            result.append("</fieldset>").append("\n");
            isOK = false;

        }

        //result += "RedhatJarsToModules: " + earWarInfo.getRedhatJarsToModules() + "\n";

        JbossDeploymentStructure jds = earWarInfo.getJbossDeploymentStructure();
        if (jds != null) {
            result.append("<fieldset style=\"margin:10px;padding:10px;border: 3px;border-style: dashed;\" >")
                    .append("\n");
            result.append("<legend>Afegir mòduls JBoss (JBoss Deployment Structure)</legend>").append("\n");

            result.append(jds.getTitol()).append("<br/>\n");

            result.append("<div style=\"border: 1px; border-style: solid;padding: 10px;margin: 10px;\">\n");
            result.append("<code>").append("\n");

            // + (isEar?"   <deployment>":"   <sub-deployment name=\"" + name + "\">")
            result.append(StringEscapeUtils.escapeHtml4(jds.getDeploymentStart())).append("<br/>\n");

            result.append(StringEscapeUtils.escapeHtml4("<dependencies>")).append("<br/>\n");

            for (String module : jds.getModules()) {
                result.append(StringEscapeUtils.escapeHtml4(module).replace("\n", "<br/>\n")).append("\n");
            }
            result.append(StringEscapeUtils.escapeHtml4("</dependencies>")).append("<br>\n");

            // + (isEar?"   </deployment>":"   </sub-deployment>")
            result.append(StringEscapeUtils.escapeHtml4(jds.getDeploymentEnd())).append("<br/>\n");

            result.append("</code>").append("\n");
            result.append("</div>\n");

            result.append("</fieldset>").append("\n");
            isOK = false;
        }
        //result.append("JbossDeploymentStructure: " + earWarInfo.getJbossDeploymentStructure() + "\n");

        List<String> potentialChange = earWarInfo.getPotencialCanviDeJarAModul();
        if (potentialChange != null && potentialChange.size() != 0) {
            result.append("<fieldset style=\"margin:10px;padding:10px;border: 3px;border-style: dashed;\" >")
                    .append("\n");
            result.append("<legend>Potencials canvis de JAR a Mòdul</legend>").append("\n");

            result.append("Revisar si els següents JARs(dependències) es poden substituir per Mòduls JBoss "
                    + "(requereix un estudi per part del desenvolupador per veure si els canvis proposats són "
                    + "compatibles amb el funcionament de l'aplicació):").append("<br/>\n");

            result.append("<ol>\n");
            for (String change : potentialChange) {
                result.append("<li>").append(StringEscapeUtils.escapeHtml4(change).replace("\n", "<br/>\n"))
                        .append("</li>\n");
                //result.append(StringEscapeUtils.escapeHtml4(potentialChange).replaceAll("\n", "<br/>\n")).append("\n");
            }
            result.append("<ol>\n");

            result.append("</fieldset>").append("\n");

            isOK = false;
        }

        List<String> errors = earWarInfo.getErrors();
        if (errors != null && errors.size() != 0) {
            result.append("<fieldset style=\"margin:10px;padding:10px;border: 3px;border-style: dashed;\" >")
                    .append("\n");
            result.append("<legend>Errors</legend>").append("\n");

            result.append("S'han trobat els següents errors en el contenidor o configuració:").append("<br/>\n");

            result.append("<ol>\n");
            for (String error : errors) {
                result.append("<li>").append(StringEscapeUtils.escapeHtml4(error).replace("\n", "<br/>\n"))
                        .append("</li>\n");
                //result.append(StringEscapeUtils.escapeHtml4(potentialChange).replaceAll("\n", "<br/>\n")).append("\n");
            }
            result.append("<ol>\n");

            result.append("</fieldset>").append("\n");

            isOK = false;
        }

        if (isOK) {
            result.append("<div class=\"alert alert-success\" role=\"alert\">\r\n"
                    + "  Aquest contenidor està perfecte !!!!\r\n" + "</div>").append("\n");
        }

        //result.append("Errors: " + earWarInfo.getErrors() + "\n");

        result.append("</form>");
        result.append("</body>\n");
        result.append("</html>");

        return result.toString();
    }

    public static final String COOKIE_EARS_PROCESSATS = "COOKIE_EARS_PROCESSATS";

    protected void afegirIdEnCookies(HttpServletRequest request, HttpServletResponse response, long id) {
        
        log.info("Afegint id " + id + " en cookies de ears processats");
        
        

        List<Long> ids = llegirEarsProcessatsDeCookies(request);
        
        log.info("Class List: " + ids.getClass().getName() + "  amb " + ids.size() + " elements ja processats.");

        ids.add(Long.valueOf(id));

        String valor = ids.stream().map(String::valueOf).collect(Collectors.joining(","));

        Cookie cookie = new Cookie(COOKIE_EARS_PROCESSATS, valor);
        cookie.setPath("/");
        cookie.setMaxAge(365 * 60 * 60 * 24); // 1 any en segons 
        response.addCookie(cookie);
    }

    protected void esborrarIdEnCookies(HttpServletRequest request, HttpServletResponse response, long id) {

        List<Long> ids = llegirEarsProcessatsDeCookies(request);

        ids.remove((Object) id);

        String valor = ids.stream().map(String::valueOf).collect(Collectors.joining(","));

        Cookie cookie = new Cookie(COOKIE_EARS_PROCESSATS, valor);
        cookie.setPath("/");
        cookie.setMaxAge(365 * 60 * 60 * 24); // 1 any en segons 
        response.addCookie(cookie);
    }

    protected List<Long> llegirEarsProcessatsDeCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return new ArrayList<>();
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_EARS_PROCESSATS)) {
                String valor = cookie.getValue();
                if (valor == null || valor.isEmpty())
                    return new ArrayList<>();

                return Arrays.stream(valor.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(Long::parseLong)
                        .collect(Collectors.toList());
            }
        }

        return new ArrayList<>(); // Cookie no encontrada
    }

    @Override
    public List<StringKeyValue> getReferenceListForJbossVersion(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue(String.valueOf(JBoss7_2_0.VERSION), "JBoss " + JBoss7_2_0.VERSION));
        __tmp.add(new StringKeyValue(String.valueOf(JBoss7_4_0.VERSION), "JBoss " + JBoss7_4_0.VERSION));
        return __tmp;
    }

}
