<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarInfoFields" className="org.fundaciobit.powertoys.model.fields.EarInfoFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.EARID)}">
        <tr id="earInfo_earid_rowid">
          <td id="earInfo_earid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.EARID])?'earInfo.earid':__theForm.labels[EarInfoFields.EARID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.EARID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.EARID]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_earid_columnvalueid">
          <form:errors path="earInfo.earid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EarInfoFields.EARID)}" >
          <form:hidden path="earInfo.earid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.earInfo.earid,__theForm.listOfEarForEarid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarInfoFields.EARID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="earInfo_earid"  onchange="if(typeof onChangeEarid == 'function') {  onChangeEarid(this); };"  cssClass="form-control col-md-9-optional" path="earInfo.earid">
            <c:forEach items="${__theForm.listOfEarForEarid}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.FILENAME)}">
        <tr id="earInfo_fileName_rowid">
          <td id="earInfo_fileName_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.FILENAME])?'earInfo.fileName':__theForm.labels[EarInfoFields.FILENAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.FILENAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.FILENAME]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_fileName_columnvalueid">
              <form:errors path="earInfo.fileName" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.FILENAME)? 'true' : 'false'}" path="earInfo.fileName"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_fileName" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_fileName" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.fileName'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('earInfo.fileName'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.fileName'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_fileName').on('click', function(){
					var valor = ($('#dropdownMenuContainer_fileName').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_fileName').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.ERRORS)}">
        <tr id="earInfo_errors_rowid">
          <td id="earInfo_errors_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.ERRORS])?'earInfo.errors':__theForm.labels[EarInfoFields.ERRORS]}" />
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.ERRORS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.ERRORS]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_errors_columnvalueid">
              <form:errors path="earInfo.errors" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.ERRORS)? 'true' : 'false'}" path="earInfo.errors"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_errors" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_errors" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.errors'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('earInfo.errors'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.errors'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_errors').on('click', function(){
					var valor = ($('#dropdownMenuContainer_errors').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_errors').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.REDHATJARSTOMODULES)}">
        <tr id="earInfo_redhatJarsToModules_rowid">
          <td id="earInfo_redhatJarsToModules_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.REDHATJARSTOMODULES])?'earInfo.redhatJarsToModules':__theForm.labels[EarInfoFields.REDHATJARSTOMODULES]}" />
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.REDHATJARSTOMODULES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.REDHATJARSTOMODULES]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_redhatJarsToModules_columnvalueid">
              <form:errors path="earInfo.redhatJarsToModules" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.REDHATJARSTOMODULES)? 'true' : 'false'}" path="earInfo.redhatJarsToModules"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_redhatJarsToModules" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_redhatJarsToModules" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.redhatJarsToModules'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('earInfo.redhatJarsToModules'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.redhatJarsToModules'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_redhatJarsToModules').on('click', function(){
					var valor = ($('#dropdownMenuContainer_redhatJarsToModules').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_redhatJarsToModules').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)}">
        <tr id="earInfo_jbossDeploymentStructure_rowid">
          <td id="earInfo_jbossDeploymentStructure_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE])?'earInfo.jbossDeploymentStructure':__theForm.labels[EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE]}" />
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_jbossDeploymentStructure_columnvalueid">
              <form:errors path="earInfo.jbossDeploymentStructure" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)? 'true' : 'false'}" path="earInfo.jbossDeploymentStructure"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_jbossDeploymentStructure" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_jbossDeploymentStructure" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.jbossDeploymentStructure'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('earInfo.jbossDeploymentStructure'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.jbossDeploymentStructure'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_jbossDeploymentStructure').on('click', function(){
					var valor = ($('#dropdownMenuContainer_jbossDeploymentStructure').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_jbossDeploymentStructure').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.POTENCIALCANVIDEJARAMODUL)}">
        <tr id="earInfo_potencialCanviDeJarAModul_rowid">
          <td id="earInfo_potencialCanviDeJarAModul_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.POTENCIALCANVIDEJARAMODUL])?'earInfo.potencialCanviDeJarAModul':__theForm.labels[EarInfoFields.POTENCIALCANVIDEJARAMODUL]}" />
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.POTENCIALCANVIDEJARAMODUL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.POTENCIALCANVIDEJARAMODUL]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_potencialCanviDeJarAModul_columnvalueid">
              <form:errors path="earInfo.potencialCanviDeJarAModul" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.POTENCIALCANVIDEJARAMODUL)? 'true' : 'false'}" path="earInfo.potencialCanviDeJarAModul"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_potencialCanviDeJarAModul" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_potencialCanviDeJarAModul" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.potencialCanviDeJarAModul'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('earInfo.potencialCanviDeJarAModul'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('earInfo.potencialCanviDeJarAModul'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_potencialCanviDeJarAModul').on('click', function(){
					var valor = ($('#dropdownMenuContainer_potencialCanviDeJarAModul').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_potencialCanviDeJarAModul').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
