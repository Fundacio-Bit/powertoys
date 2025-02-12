
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="earInfoForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="earInfoFormTitle.jsp" %>
 
  <c:set var="contexte" value="${earInfoForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="earInfoFormCorePre.jsp" %>

  <%@include file="earInfoFormCore.jsp" %>

  <%@include file="earInfoFormCorePost.jsp" %>

  <%@include file="earInfoFormButtons.jsp" %>

  <c:if test="${not empty earInfoForm.sections}">
     <c:set var="__basename" value="earInfo" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${earInfoForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/earInfoFormModificable.jsp" %>
  </c:if>

</form:form>


