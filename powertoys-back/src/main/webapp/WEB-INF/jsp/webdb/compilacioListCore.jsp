  <c:if test="${empty compilacioItems}">
     <%@include file="compilacioListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty compilacioItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="compilacioListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="compilacioListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="compilacioListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="compilacio" items="${compilacioItems}">

        <tr id="compilacio_rowid_${compilacio.compilacioID}">
          <%@include file="compilacioListCoreMultipleSelect.jsp" %>

          <%@include file="compilacioListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="compilacioListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
