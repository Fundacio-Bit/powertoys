<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(earInfoForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(earInfoForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty earInfoForm.titleCode}">
    <fmt:message key="${earInfoForm.titleCode}" >
      <fmt:param value="${earInfoForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty earInfoForm.entityNameCode}">
      <fmt:message var="entityname" key="earInfo.earInfo"/>
    </c:if>
    <c:if test="${not empty earInfoForm.entityNameCode}">
      <fmt:message var="entityname" key="${earInfoForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${earInfoForm.nou?'genapp.createtitle':(earInfoForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty earInfoForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(earInfoForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(earInfoForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${earInfoForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>