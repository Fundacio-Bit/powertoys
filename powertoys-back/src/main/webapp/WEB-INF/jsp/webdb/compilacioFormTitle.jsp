<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(compilacioForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(compilacioForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty compilacioForm.titleCode}">
    <fmt:message key="${compilacioForm.titleCode}" >
      <fmt:param value="${compilacioForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty compilacioForm.entityNameCode}">
      <fmt:message var="entityname" key="compilacio.compilacio"/>
    </c:if>
    <c:if test="${not empty compilacioForm.entityNameCode}">
      <fmt:message var="entityname" key="${compilacioForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${compilacioForm.nou?'genapp.createtitle':(compilacioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty compilacioForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(compilacioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(compilacioForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${compilacioForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>