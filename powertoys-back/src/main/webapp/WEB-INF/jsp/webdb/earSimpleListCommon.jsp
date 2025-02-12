<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${earSimpleFilterForm.contexte}"/>
  <c:set var="formName" value="earSimple" />
  <c:set var="__theFilterForm" value="${earSimpleFilterForm}" />
  <c:if test="${empty earSimpleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="earSimple.earSimple"/>
  </c:if>
  <c:if test="${not empty earSimpleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${earSimpleFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty earSimpleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="earSimple.earSimple"/>
  </c:if>
  <c:if test="${not empty earSimpleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${earSimpleFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.earSimple.submit();  
  }
</script>
