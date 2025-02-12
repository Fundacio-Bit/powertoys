
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="earSimpleForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="earSimpleFormTitle.jsp" %>
 
  <c:set var="contexte" value="${earSimpleForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="earSimpleFormCorePre.jsp" %>

  <%@include file="earSimpleFormCore.jsp" %>

  <%@include file="earSimpleFormCorePost.jsp" %>

  <%@include file="earSimpleFormButtons.jsp" %>

  <c:if test="${not empty earSimpleForm.sections}">
     <c:set var="__basename" value="earSimple" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${earSimpleForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/earSimpleFormModificable.jsp" %>
  </c:if>

</form:form>


