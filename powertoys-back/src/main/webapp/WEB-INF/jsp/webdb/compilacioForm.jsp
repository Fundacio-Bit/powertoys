
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="compilacioForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="compilacioFormTitle.jsp" %>
 
  <c:set var="contexte" value="${compilacioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="compilacioFormCorePre.jsp" %>

  <%@include file="compilacioFormCore.jsp" %>

  <%@include file="compilacioFormCorePost.jsp" %>

  <%@include file="compilacioFormButtons.jsp" %>

  <c:if test="${not empty compilacioForm.sections}">
     <c:set var="__basename" value="compilacio" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${compilacioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/compilacioFormModificable.jsp" %>
  </c:if>

</form:form>


