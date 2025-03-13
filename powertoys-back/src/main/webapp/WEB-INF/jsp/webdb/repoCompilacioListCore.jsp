  <c:if test="${empty repoCompilacioItems}">
     <%@include file="repoCompilacioListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty repoCompilacioItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="repoCompilacioListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="repoCompilacioListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="repoCompilacioListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="repoCompilacio" items="${repoCompilacioItems}">

        <tr id="repoCompilacio_rowid_${repoCompilacio.repocompilacioID}">
          <%@include file="repoCompilacioListCoreMultipleSelect.jsp" %>

          <%@include file="repoCompilacioListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="repoCompilacioListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
