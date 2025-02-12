  <c:if test="${empty earInfoItems}">
     <%@include file="earInfoListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty earInfoItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="earInfoListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="earInfoListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="earInfoListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="earInfo" items="${earInfoItems}">

        <tr id="earInfo_rowid_${earInfo.earinfoID}">
          <%@include file="earInfoListCoreMultipleSelect.jsp" %>

          <%@include file="earInfoListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="earInfoListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
