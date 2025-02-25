<%@page import="org.springframework.security.core.Authentication"
%><%@page import="org.springframework.context.i18n.LocaleContextHolder"
%><%@page import="org.springframework.security.core.context.SecurityContext"
%><%@page import="org.springframework.security.core.context.SecurityContextHolder"
%><%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<div class="clear"></div>
<div class="spacer"></div>

<div>
<br/>
<center>
<img src="<c:url value="/img/app-logo.png"/>" style="width: 61px" alt="powertoys" title="powertoys"/>

<br/>
<br/>
This page is generated automatically. Please edit.

<br/>
<br/>
<table border="0" >
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="top">
<a href="http://blog.fundaciobit.org/category/admindigital/" target="_blank">
<img src="<c:url value="/img/fundaciobit.png"/>"  alt="Fundació Bit" title="Fundació Bit"/>
</a>
</td>
</tr>
</table>
<br/>
</center>
 
</div>

<br/>
<div class="user-info">
    <h3>User Information:</h3>
    <div class="user-details">
        <div>
            <c:if test="${not empty loginInfo.userInfo}">
                <p><strong><fmt:message key="principal.nom"></fmt:message></strong> ${loginInfo.userInfo.name}</p>
                <p><strong><fmt:message key="principal.llinatges"></fmt:message></strong> ${loginInfo.userInfo.surname1} ${loginInfo.userInfo.surname2}</p>
                <p><strong><fmt:message key="principal.correu"></fmt:message></strong> ${loginInfo.userInfo.email}</p>
                <p><strong>NIF:</strong> ${loginInfo.userInfo.attributes["nif"]}</p>
            </c:if>
        </div>
        <div>
            <p><fmt:message key="principal.usuari">
                <fmt:param value="${loginInfo.username}"/>
            </fmt:message></p>
            <p>ROLE_ADMIN: <c:if test="${pwt:hasRole('ROLE_ADMIN')}"><img src="<c:url value="/img/icn_alert_success.png"/>" alt="true" title="true"/></c:if><c:if test="${!pwt:hasRole('ROLE_ADMIN')}"><img src="<c:url value="/img/icn_alert_error.png"/>" alt="false" title="false"/></c:if></p>
            <p>ROLE_USER: <c:if test="${pwt:hasRole('ROLE_USER')}"><img src="<c:url value="/img/icn_alert_success.png"/>" alt="true" title="true"/></c:if><c:if test="${!pwt:hasRole('ROLE_USER')}"><img src="<c:url value="/img/icn_alert_error.png"/>" alt="false" title="false"/></c:if></p>
            <p><fmt:message key="principal.locale">
                <fmt:param value="<%=LocaleContextHolder.getLocale() %>"/>
            </fmt:message></p>
            <p><fmt:message key="principal.llengua">
                <fmt:param value="${lang}"/>
            </fmt:message></p>
        </div>
    </div>
    <c:if test="${empty loginInfo.userInfo}">
        <p class="error-message">Error carregant Plugin UserInfo. Revisar logs per mes informacio.</p>
    </c:if>
</div>

<c:if test="${pwt:isDesenvolupament()}">
Only in Development Mode
</c:if>
