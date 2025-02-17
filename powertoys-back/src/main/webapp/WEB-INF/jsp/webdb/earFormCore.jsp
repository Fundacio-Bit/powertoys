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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarFields.DATA)}">
        <tr id="ear_data_rowid">
          <td id="ear_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarFields.DATA])?'ear.data':__theForm.labels[EarFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="ear_data_columnvalueid">
    <form:errors path="ear.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="ear_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EarFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#ear_data" path="ear.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarFields.DATA)}" >
                    <div class="input-group-append"  data-target="#ear_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#ear_data').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarFields.NOM)}">
        <tr id="ear_nom_rowid">
          <td id="ear_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarFields.NOM])?'ear.nom':__theForm.labels[EarFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="ear_nom_columnvalueid">
            <form:errors path="ear.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EarFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EarFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="ear.nom"   />

           </td>
        </tr>
        </c:if>
        
