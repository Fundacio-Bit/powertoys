
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="earForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="earFormTitle.jsp" %>
 
  <c:set var="contexte" value="${earForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="earFormCorePre.jsp" %>

  <%@include file="earFormCore.jsp" %>

  <%@include file="earFormCorePost.jsp" %>

  <%@include file="earFormButtons.jsp" %>

  <c:if test="${not empty earForm.sections}">
     <c:set var="__basename" value="ear" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${earForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/earFormModificable.jsp" %>
  </c:if>

</form:form>


