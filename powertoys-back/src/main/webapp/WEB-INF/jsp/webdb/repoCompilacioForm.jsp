
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="repoCompilacioForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="repoCompilacioFormTitle.jsp" %>
 
  <c:set var="contexte" value="${repoCompilacioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="repoCompilacioFormCorePre.jsp" %>

  <%@include file="repoCompilacioFormCore.jsp" %>

  <%@include file="repoCompilacioFormCorePost.jsp" %>

  <%@include file="repoCompilacioFormButtons.jsp" %>

  <c:if test="${not empty repoCompilacioForm.sections}">
     <c:set var="__basename" value="repoCompilacio" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${repoCompilacioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/repoCompilacioFormModificable.jsp" %>
  </c:if>

</form:form>


