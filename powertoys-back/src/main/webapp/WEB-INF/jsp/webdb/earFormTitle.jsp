<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(earForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(earForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty earForm.titleCode}">
    <fmt:message key="${earForm.titleCode}" >
      <fmt:param value="${earForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty earForm.entityNameCode}">
      <fmt:message var="entityname" key="ear.ear"/>
    </c:if>
    <c:if test="${not empty earForm.entityNameCode}">
      <fmt:message var="entityname" key="${earForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${earForm.nou?'genapp.createtitle':(earForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty earForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(earForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(earForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${earForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>