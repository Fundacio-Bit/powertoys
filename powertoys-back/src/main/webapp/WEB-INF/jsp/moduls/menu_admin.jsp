<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuOptionManager"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuItem"
%><%@page import="org.fundaciobit.powertoys.commons.utils.Constants"
%><%@page import="java.util.List"
%><%@page import="java.util.ArrayList"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>Menú ROLE_ADMIN</h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">

    <%--
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/option1"/>">
        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">Menú ADMIN Option 1</span>
      </a>
    </li>
    --%>

   <%-- Example with security: virtual roles  --%>
   <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/admin/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
   --%>

   <%--
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/option2"/>">
        <span style="${(fn:contains(url, 'option2'))? "font-weight: bold;" : ""}">Menú ADMIN Option 2</span>
      </a>
    </li>
    --%>

    <%
    List<List<MenuItem>> menus = new ArrayList<List<MenuItem>>();
    MenuItem[] menusAddicionals;
    Object loginInfo = request.getAttribute("loginInfo");
    
    if (loginInfo == null) {
        menusAddicionals = new MenuItem[] {            
        };
    } else {
        menusAddicionals = new MenuItem[] {
                null,
        };
    }
    List<MenuItem> discoveredMenus = MenuOptionManager.getMenuItems("ADMIN", menusAddicionals);
    menus.add(discoveredMenus);
    %>

   <%@ include file="/WEB-INF/jsp/moduls/menu_role_generator.jsp"%>

  </ul>
</div>

