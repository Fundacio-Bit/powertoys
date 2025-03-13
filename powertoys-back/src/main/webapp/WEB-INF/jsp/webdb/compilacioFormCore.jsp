<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="CompilacioFields" className="org.fundaciobit.powertoys.model.fields.CompilacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.REPOCOMPILACIOID)}">
        <tr id="compilacio_repocompilacioID_rowid">
          <td id="compilacio_repocompilacioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.REPOCOMPILACIOID])?'compilacio.repocompilacioID':__theForm.labels[CompilacioFields.REPOCOMPILACIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.REPOCOMPILACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.REPOCOMPILACIOID]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_repocompilacioID_columnvalueid">
          <form:errors path="compilacio.repocompilacioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,CompilacioFields.REPOCOMPILACIOID)}" >
          <form:hidden path="compilacio.repocompilacioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.compilacio.repocompilacioID,__theForm.listOfRepoCompilacioForRepocompilacioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,CompilacioFields.REPOCOMPILACIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="compilacio_repocompilacioID"  onchange="if(typeof onChangeRepocompilacioID == 'function') {  onChangeRepocompilacioID(this); };"  cssClass="form-control col-md-9-optional" path="compilacio.repocompilacioID">
            <c:forEach items="${__theForm.listOfRepoCompilacioForRepocompilacioID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.TAGURL)}">
        <tr id="compilacio_tagUrl_rowid">
          <td id="compilacio_tagUrl_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.TAGURL])?'compilacio.tagUrl':__theForm.labels[CompilacioFields.TAGURL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.TAGURL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.TAGURL]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_tagUrl_columnvalueid">
              <form:errors path="compilacio.tagUrl" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,CompilacioFields.TAGURL)? 'true' : 'false'}" path="compilacio.tagUrl"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_tagUrl" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_tagUrl" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('compilacio.tagUrl'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('compilacio.tagUrl'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('compilacio.tagUrl'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_tagUrl').on('click', function(){
					var valor = ($('#dropdownMenuContainer_tagUrl').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_tagUrl').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.DATAINICI)}">
        <tr id="compilacio_dataInici_rowid">
          <td id="compilacio_dataInici_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.DATAINICI])?'compilacio.dataInici':__theForm.labels[CompilacioFields.DATAINICI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.DATAINICI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.DATAINICI]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_dataInici_columnvalueid">
    <form:errors path="compilacio.dataInici" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="compilacio_dataInici" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,CompilacioFields.DATAINICI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#compilacio_dataInici" path="compilacio.dataInici" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,CompilacioFields.DATAINICI)}" >
                    <div class="input-group-append"  data-target="#compilacio_dataInici"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#compilacio_dataInici').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.DATAFI)}">
        <tr id="compilacio_dataFi_rowid">
          <td id="compilacio_dataFi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.DATAFI])?'compilacio.dataFi':__theForm.labels[CompilacioFields.DATAFI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.DATAFI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.DATAFI]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_dataFi_columnvalueid">
    <form:errors path="compilacio.dataFi" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="compilacio_dataFi" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,CompilacioFields.DATAFI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#compilacio_dataFi" path="compilacio.dataFi" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,CompilacioFields.DATAFI)}" >
                    <div class="input-group-append"  data-target="#compilacio_dataFi"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#compilacio_dataFi').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.EXITCODE)}">
        <tr id="compilacio_exitCode_rowid">
          <td id="compilacio_exitCode_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.EXITCODE])?'compilacio.exitCode':__theForm.labels[CompilacioFields.EXITCODE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.EXITCODE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.EXITCODE]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_exitCode_columnvalueid">
            <form:errors path="compilacio.exitCode" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,CompilacioFields.EXITCODE)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,CompilacioFields.EXITCODE)? ' uneditable-input' : ''}"  style=""  path="compilacio.exitCode"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,CompilacioFields.OUTPUT)}">
        <tr id="compilacio_output_rowid">
          <td id="compilacio_output_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[CompilacioFields.OUTPUT])?'compilacio.output':__theForm.labels[CompilacioFields.OUTPUT]}" />
             </label>
              <c:if test="${not empty __theForm.help[CompilacioFields.OUTPUT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[CompilacioFields.OUTPUT]}" ></i>
              </c:if>
            </td>
          <td id="compilacio_output_columnvalueid">
              <form:errors path="compilacio.output" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,CompilacioFields.OUTPUT)? 'true' : 'false'}" path="compilacio.output"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_output" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_output" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('compilacio.output'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('compilacio.output'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('compilacio.output'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_output').on('click', function(){
					var valor = ($('#dropdownMenuContainer_output').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_output').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
