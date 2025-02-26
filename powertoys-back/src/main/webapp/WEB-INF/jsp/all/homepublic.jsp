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

    <fmt:message key="public.paginapublica" />
    <br />

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

<!-- LOGIN ANONIM <br />
Locale = <%=LocaleContextHolder.getLocale() %> <br />
lang = ${lang} <br />
<br /> -->

<div class="user-info">
  <h3><fmt:message key="public.login.anonim" /></h3>
  <div class="user-details">
    <div>
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
        <fmt:message key="public.errorpluginuserinfo"/>
    </p>
  </c:if>
</div>

<c:if test="${pwt:isDesenvolupament()}"> Only in Development Mode </c:if>
