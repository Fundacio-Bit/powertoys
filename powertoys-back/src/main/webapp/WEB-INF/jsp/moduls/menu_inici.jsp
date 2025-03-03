<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuOptionManager"
%><%@page import="org.fundaciobit.genapp.common.web.menuoptions.MenuItem"
%><%@page import="org.fundaciobit.powertoys.commons.utils.Constants"
%><%@page import="java.util.List"
%><%@page import="java.util.ArrayList"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5><fmt:message key="menuinici" /></h5>
      
    <%
    List<List<MenuItem>> menus = new ArrayList<List<MenuItem>>();
    MenuItem[] menusAddicionals;
    Object loginInfo = request.getAttribute("loginInfo");
    
    if (loginInfo == null) {
        menusAddicionals = new MenuItem[] {
                new MenuItem("principal.presentacio","/public/index.html", 0),
                //new MenuItem("=Presentació","/public/index.html", 0),
        };
    } else {
        menusAddicionals = new MenuItem[] {
                new MenuItem("principal.presentacio","/public/index.html", 0),
        };
    }
    List<MenuItem> discoveredMenus = MenuOptionManager.getMenuItems("PUBLIC", menusAddicionals);
    menus.add(discoveredMenus);
    %>

   <%@ include file="/WEB-INF/jsp/moduls/menu_role_generator.jsp"%>
  </ul>
</div>

