<%@page import="org.springframework.security.core.Authentication" %><%@page
import="org.springframework.context.i18n.LocaleContextHolder" %><%@page
language="java" %><%@include file="/WEB-INF/jsp/moduls/includes.jsp" %>
<div class="clear"></div>
<div class="spacer"></div>

<div>
  <br />
  <center>
    <img src="<c:url value="/img/app-logo-fons.png" />" style="width: 10vw"
    alt="powertoys" title="powertoys" onerror="this.src =
    '/powertoysback/img/icn_alert_error.png';" />

    <!-- <picture style="width: 61px" alt="powertoys" title="powertoys">
      <source srcset="<c:url value="/img/app-logo-fons.webp" />" type="image/webp">
      <source srcset="<c:url value="/img/app-logo-fons.png" />" type="image/png">
      <img src="<c:url value="/img/app-logo-fons.png" />" onerror="this.src =
      '/powertoysback/img/icn_alert_error.png';" />
    </picture> -->

    <br />
    <br />

    <c:if test="${empty loginInfo.userInfo}">
      <fmt:message key="public.paginapublica" />
      <br />
    </c:if>

    <fmt:message key="principal.descripcio1" />
    <br />
    <fmt:message key="principal.descripcio2" />

    <br />
    <br />
    <table border="0">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top">
          <a
            href="http://blog.fundaciobit.org/category/admindigital/"
            target="_blank"
          >
            <img src="<c:url value="/img/fundaciobit.png" />" alt="Fundació Bit"
            title="Fundació Bit"/>
          </a>
        </td>
      </tr>
    </table>
    <br />
  </center>
</div>

<br />

<c:if test="${pwt:isDesenvolupament()}">
  <div class="user-info">
    <c:if test="${empty loginInfo.userInfo}">
      <h3><fmt:message key="public.login.anonim" /></h3>
    </c:if>
    <c:if test="${not empty loginInfo.userInfo}">
      <h3>User Information:</h3>
    </c:if>
    <div class="user-details">
      <c:if test="${not empty loginInfo.userInfo}">
        <div>
          <c:if test="${not empty loginInfo.userInfo}">
            <p>
              <strong><fmt:message key="principal.nom" /></strong>
              ${loginInfo.userInfo.name}
            </p>
            <p>
              <strong><fmt:message key="principal.llinatges" /></strong>
              ${loginInfo.userInfo.surname1} ${loginInfo.userInfo.surname2}
            </p>
            <p>
              <strong><fmt:message key="principal.correu" /></strong>
              ${loginInfo.userInfo.email}
            </p>
            <p><strong>NIF:</strong> ${loginInfo.userInfo.attributes["nif"]}</p>
          </c:if>
        </div>
      </c:if>
      <div>
        <c:if test="${not empty loginInfo.userInfo}">
          <p>
            <fmt:message key="principal.usuari">
              <fmt:param value="${loginInfo.username}" />
            </fmt:message>
          </p>
          <p>
            ROLE_ADMIN:
            <c:if test="${pwt:hasRole('ROLE_ADMIN')}"
              ><img src="<c:url value="/img/icn_alert_success.png" />"
              alt="true" title="true"/></c:if
            ><c:if test="${!pwt:hasRole('ROLE_ADMIN')}"
              ><img src="<c:url value="/img/icn_alert_error.png" />" alt="false"
              title="false"/></c:if
            >
          </p>
          <p>
            ROLE_USER:
            <c:if test="${pwt:hasRole('ROLE_USER')}"
              ><img src="<c:url value="/img/icn_alert_success.png" />"
              alt="true" title="true"/></c:if
            ><c:if test="${!pwt:hasRole('ROLE_USER')}"
              ><img src="<c:url value="/img/icn_alert_error.png" />" alt="false"
              title="false"/></c:if
            >
          </p>
        </c:if>
        <p>
          <fmt:message key="principal.locale">
            <fmt:param value="<%=LocaleContextHolder.getLocale() %>" />
          </fmt:message>
        </p>
        <p>
          <fmt:message key="principal.llengua">
            <fmt:param value="${lang}" />
          </fmt:message>
        </p>
      </div>
    </div>
    <c:if test="${empty loginInfo.userInfo}">
      <p class="error-message">
        <fmt:message key="public.errorpluginuserinfo" />
      </p>
    </c:if>
  </div>

  Only in Development Mode
</c:if>
