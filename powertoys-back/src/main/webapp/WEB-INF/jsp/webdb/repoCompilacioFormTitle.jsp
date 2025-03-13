<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(repoCompilacioForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(repoCompilacioForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty repoCompilacioForm.titleCode}">
    <fmt:message key="${repoCompilacioForm.titleCode}" >
      <fmt:param value="${repoCompilacioForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty repoCompilacioForm.entityNameCode}">
      <fmt:message var="entityname" key="repoCompilacio.repoCompilacio"/>
    </c:if>
    <c:if test="${not empty repoCompilacioForm.entityNameCode}">
      <fmt:message var="entityname" key="${repoCompilacioForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${repoCompilacioForm.nou?'genapp.createtitle':(repoCompilacioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty repoCompilacioForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(repoCompilacioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(repoCompilacioForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${repoCompilacioForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>