<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(earSimpleForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(earSimpleForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty earSimpleForm.titleCode}">
    <fmt:message key="${earSimpleForm.titleCode}" >
      <fmt:param value="${earSimpleForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty earSimpleForm.entityNameCode}">
      <fmt:message var="entityname" key="earSimple.earSimple"/>
    </c:if>
    <c:if test="${not empty earSimpleForm.entityNameCode}">
      <fmt:message var="entityname" key="${earSimpleForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${earSimpleForm.nou?'genapp.createtitle':(earSimpleForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty earSimpleForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(earSimpleForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(earSimpleForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${earSimpleForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>