<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${earInfoFilterForm.contexte}"/>
  <c:set var="formName" value="earInfo" />
  <c:set var="__theFilterForm" value="${earInfoFilterForm}" />
  <c:if test="${empty earInfoFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="earInfo.earInfo"/>
  </c:if>
  <c:if test="${not empty earInfoFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${earInfoFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty earInfoFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="earInfo.earInfo"/>
  </c:if>
  <c:if test="${not empty earInfoFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${earInfoFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.earInfo.submit();  
  }
</script>
