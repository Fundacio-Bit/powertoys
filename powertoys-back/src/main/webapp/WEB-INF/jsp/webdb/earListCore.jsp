  <c:if test="${empty earItems}">
     <%@include file="earListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty earItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="earListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="earListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="earListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="ear" items="${earItems}">

        <tr id="ear_rowid_${ear.earID}">
          <%@include file="earListCoreMultipleSelect.jsp" %>

          <%@include file="earListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="earListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
