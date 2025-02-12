<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuOptionManager"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuItem"
%><%@page import="org.fundaciobit.powertoys.commons.utils.Constants"
%><%@page import="java.util.List"
%><%@page import="java.util.ArrayList"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
    <h5>Menú ROLE_USER</h5>

    <%
    List<List<MenuItem>> menus = new ArrayList<List<MenuItem>>();
    /*
    MenuItem menuGoogle = new MenuItem("=MENU Google", "http://www.google.com", 0);
    MenuItem menuFBit = new MenuItem("=MENU Govern Digital",  "https://governdigital.fundaciobit.org", 1000);
    */
   List<MenuItem> discoveredMenus = MenuOptionManager.getMenuItems(Constants.PWT_USER); //, menuGoogle, menuFBit);
    menus.add(discoveredMenus);
    %>
    
    <%@ include file="/WEB-INF/jsp/moduls/menu_role_generator.jsp"%>  

</div>