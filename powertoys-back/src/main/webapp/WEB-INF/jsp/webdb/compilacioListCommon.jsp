<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${compilacioFilterForm.contexte}"/>
  <c:set var="formName" value="compilacio" />
  <c:set var="__theFilterForm" value="${compilacioFilterForm}" />
  <c:if test="${empty compilacioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="compilacio.compilacio"/>
  </c:if>
  <c:if test="${not empty compilacioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${compilacioFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty compilacioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="compilacio.compilacio"/>
  </c:if>
  <c:if test="${not empty compilacioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${compilacioFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.compilacio.submit();  
  }
</script>
