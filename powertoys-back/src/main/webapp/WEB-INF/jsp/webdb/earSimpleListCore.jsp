  <c:if test="${empty earSimpleItems}">
     <%@include file="earSimpleListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty earSimpleItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="earSimpleListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="earSimpleListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="earSimpleListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="earSimple" items="${earSimpleItems}">

        <tr id="earSimple_rowid_${earSimple.earSimpleID}">
          <%@include file="earSimpleListCoreMultipleSelect.jsp" %>

          <%@include file="earSimpleListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="earSimpleListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
