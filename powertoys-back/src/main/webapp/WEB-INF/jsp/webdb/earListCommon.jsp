<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${earFilterForm.contexte}"/>
  <c:set var="formName" value="ear" />
  <c:set var="__theFilterForm" value="${earFilterForm}" />
  <c:if test="${empty earFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="ear.ear"/>
  </c:if>
  <c:if test="${not empty earFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${earFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty earFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="ear.ear"/>
  </c:if>
  <c:if test="${not empty earFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${earFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.ear.submit();  
  }
</script>
