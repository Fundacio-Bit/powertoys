<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="RepoCompilacioFields" className="org.fundaciobit.powertoys.model.fields.RepoCompilacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,RepoCompilacioFields.NOM)}">
        <tr id="repoCompilacio_nom_rowid">
          <td id="repoCompilacio_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[RepoCompilacioFields.NOM])?'repoCompilacio.nom':__theForm.labels[RepoCompilacioFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[RepoCompilacioFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[RepoCompilacioFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="repoCompilacio_nom_columnvalueid">
              <form:errors path="repoCompilacio.nom" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.NOM)? 'true' : 'false'}" path="repoCompilacio.nom"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_nom" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_nom" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('repoCompilacio.nom'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('repoCompilacio.nom'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('repoCompilacio.nom'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_nom').on('click', function(){
					var valor = ($('#dropdownMenuContainer_nom').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_nom').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,RepoCompilacioFields.ORGANITZACIOGITHUB)}">
        <tr id="repoCompilacio_organitzacioGitHub_rowid">
          <td id="repoCompilacio_organitzacioGitHub_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[RepoCompilacioFields.ORGANITZACIOGITHUB])?'repoCompilacio.organitzacioGitHub':__theForm.labels[RepoCompilacioFields.ORGANITZACIOGITHUB]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[RepoCompilacioFields.ORGANITZACIOGITHUB]}">
              <i class="fas fa-info-circle" title="${__theForm.help[RepoCompilacioFields.ORGANITZACIOGITHUB]}" ></i>
              </c:if>
            </td>
          <td id="repoCompilacio_organitzacioGitHub_columnvalueid">
          <form:errors path="repoCompilacio.organitzacioGitHub" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ORGANITZACIOGITHUB)}" >
          <form:hidden path="repoCompilacio.organitzacioGitHub"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.repoCompilacio.organitzacioGitHub,__theForm.listOfValuesForOrganitzacioGitHub)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ORGANITZACIOGITHUB)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="repoCompilacio_organitzacioGitHub"  onchange="if(typeof onChangeOrganitzacioGitHub == 'function') {  onChangeOrganitzacioGitHub(this); };"  cssClass="form-control col-md-9-optional" path="repoCompilacio.organitzacioGitHub">
            <c:forEach items="${__theForm.listOfValuesForOrganitzacioGitHub}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,RepoCompilacioFields.REPOSITORIGITHUB)}">
        <tr id="repoCompilacio_repositoriGitHub_rowid">
          <td id="repoCompilacio_repositoriGitHub_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[RepoCompilacioFields.REPOSITORIGITHUB])?'repoCompilacio.repositoriGitHub':__theForm.labels[RepoCompilacioFields.REPOSITORIGITHUB]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[RepoCompilacioFields.REPOSITORIGITHUB]}">
              <i class="fas fa-info-circle" title="${__theForm.help[RepoCompilacioFields.REPOSITORIGITHUB]}" ></i>
              </c:if>
            </td>
          <td id="repoCompilacio_repositoriGitHub_columnvalueid">
          <form:errors path="repoCompilacio.repositoriGitHub" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.REPOSITORIGITHUB)}" >
          <form:hidden path="repoCompilacio.repositoriGitHub"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.repoCompilacio.repositoriGitHub,__theForm.listOfValuesForRepositoriGitHub)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.REPOSITORIGITHUB)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="repoCompilacio_repositoriGitHub"  onchange="if(typeof onChangeRepositoriGitHub == 'function') {  onChangeRepositoriGitHub(this); };"  cssClass="form-control col-md-9-optional" path="repoCompilacio.repositoriGitHub">
            <c:forEach items="${__theForm.listOfValuesForRepositoriGitHub}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,RepoCompilacioFields.ORDRE)}">
        <tr id="repoCompilacio_ordre_rowid">
          <td id="repoCompilacio_ordre_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[RepoCompilacioFields.ORDRE])?'repoCompilacio.ordre':__theForm.labels[RepoCompilacioFields.ORDRE]}" />
             </label>
              <c:if test="${not empty __theForm.help[RepoCompilacioFields.ORDRE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[RepoCompilacioFields.ORDRE]}" ></i>
              </c:if>
            </td>
          <td id="repoCompilacio_ordre_columnvalueid">
            <form:errors path="repoCompilacio.ordre" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ORDRE)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ORDRE)? ' uneditable-input' : ''}"  style=""  path="repoCompilacio.ordre"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,RepoCompilacioFields.ACTIU)}">
        <tr id="repoCompilacio_actiu_rowid">
          <td id="repoCompilacio_actiu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[RepoCompilacioFields.ACTIU])?'repoCompilacio.actiu':__theForm.labels[RepoCompilacioFields.ACTIU]}" />
             </label>
              <c:if test="${not empty __theForm.help[RepoCompilacioFields.ACTIU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[RepoCompilacioFields.ACTIU]}" ></i>
              </c:if>
            </td>
          <td id="repoCompilacio_actiu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ACTIU)}" >
              <form:errors path="repoCompilacio.actiu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ACTIU)? 'false' : 'true'}" path="repoCompilacio.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,RepoCompilacioFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.repoCompilacio.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
