<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarSimpleFields" className="org.fundaciobit.powertoys.model.fields.EarSimpleFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarSimpleFields.FITXERID)}">
        <tr id="earSimple_fitxerID_rowid">
          <td id="earSimple_fitxerID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarSimpleFields.FITXERID])?'earSimple.fitxerID':__theForm.labels[EarSimpleFields.FITXERID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarSimpleFields.FITXERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarSimpleFields.FITXERID]}" ></i>
              </c:if>
            </td>
          <td id="earSimple_fitxerID_columnvalueid">
              <form:errors path="earSimple.fitxerID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,EarSimpleFields.FITXERID)}" >
              <a target="_blank" href="<c:url value="${pwt:fileUrl(__theForm.earSimple.fitxer)}"/>">${__theForm.earSimple.fitxer.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarSimpleFields.FITXERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,EarSimpleFields.FITXERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,EarSimpleFields.FITXERID)? ' uneditable-input' : ''}"   path="fitxerID" type="file" />
                  <label class="custom-file-label" for="fitxerID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.earSimple.fitxer}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${pwt:fileUrl(__theForm.earSimple.fitxer)}"/>">${__theForm.earSimple.fitxer.nom}</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarSimpleFields.NOM)}">
        <tr id="earSimple_nom_rowid">
          <td id="earSimple_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarSimpleFields.NOM])?'earSimple.nom':__theForm.labels[EarSimpleFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarSimpleFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarSimpleFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="earSimple_nom_columnvalueid">
            <form:errors path="earSimple.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EarSimpleFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EarSimpleFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="earSimple.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarSimpleFields.DETALL)}">
        <tr id="earSimple_detall_rowid">
          <td id="earSimple_detall_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarSimpleFields.DETALL])?'earSimple.detall':__theForm.labels[EarSimpleFields.DETALL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarSimpleFields.DETALL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarSimpleFields.DETALL]}" ></i>
              </c:if>
            </td>
          <td id="earSimple_detall_columnvalueid">
              <form:errors path="earSimple.detall" cssClass="errorField alert alert-danger" />
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,EarSimpleFields.DETALL)? 'mceEditorReadOnly':'mceEditor'}"  path="earSimple.detall"  />
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarSimpleFields.DATA)}">
        <tr id="earSimple_data_rowid">
          <td id="earSimple_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarSimpleFields.DATA])?'earSimple.data':__theForm.labels[EarSimpleFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarSimpleFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarSimpleFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="earSimple_data_columnvalueid">
    <form:errors path="earSimple.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="earSimple_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EarSimpleFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#earSimple_data" path="earSimple.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarSimpleFields.DATA)}" >
                    <div class="input-group-append"  data-target="#earSimple_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#earSimple_data').datetimepicker({
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
        
