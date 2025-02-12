<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarFields" className="org.fundaciobit.powertoys.model.fields.EarFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarFields.FITXERID)}">
        <tr id="ear_fitxerID_rowid">
          <td id="ear_fitxerID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarFields.FITXERID])?'ear.fitxerID':__theForm.labels[EarFields.FITXERID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarFields.FITXERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarFields.FITXERID]}" ></i>
              </c:if>
            </td>
          <td id="ear_fitxerID_columnvalueid">
              <form:errors path="ear.fitxerID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EarFields.FITXERID)}" >
              <a target="_blank" href="<c:url value="${pwt:fileUrl(__theForm.ear.fitxer)}"/>">${__theForm.ear.fitxer.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarFields.FITXERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EarFields.FITXERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EarFields.FITXERID)? ' uneditable-input' : ''}"   path="fitxerID" type="file" />
                  <label class="custom-file-label" for="fitxerID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.ear.fitxer}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${pwt:fileUrl(__theForm.ear.fitxer)}"/>">${__theForm.ear.fitxer.nom}</a>
</small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerID').on('change', function(){
						var ruta = $('#fitxerID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerID-custom-file-label').css('display','block');
						$('#fitxerID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
