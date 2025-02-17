<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarInfoFields" className="org.fundaciobit.powertoys.model.fields.EarInfoFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EarInfoFields.EARID)}">
        <tr id="earInfo_earID_rowid">
          <td id="earInfo_earID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EarInfoFields.EARID])?'earInfo.earID':__theForm.labels[EarInfoFields.EARID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EarInfoFields.EARID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EarInfoFields.EARID]}" ></i>
              </c:if>
            </td>
          <td id="earInfo_earID_columnvalueid">
          <form:errors path="earInfo.earID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EarInfoFields.EARID)}" >
          <form:hidden path="earInfo.earID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.earInfo.earID,__theForm.listOfEarForEarID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EarInfoFields.EARID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="earInfo_earID"  onchange="if(typeof onChangeEarID == 'function') {  onChangeEarID(this); };"  cssClass="form-control col-md-9-optional" path="earInfo.earID">
            <c:forEach items="${__theForm.listOfEarForEarID}" var="tmp">
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
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EarInfoFields.FILENAME)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,EarInfoFields.FILENAME)? ' uneditable-input' : ''}"  style="" maxlength="2147483647" path="earInfo.fileName"   />

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
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,EarInfoFields.ERRORS)? 'mceEditorReadOnly':'mceEditor'}"  path="earInfo.errors"  />
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
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,EarInfoFields.REDHATJARSTOMODULES)? 'mceEditorReadOnly':'mceEditor'}"  path="earInfo.redhatJarsToModules"  />
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
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)? 'mceEditorReadOnly':'mceEditor'}"  path="earInfo.jbossDeploymentStructure"  />
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
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,EarInfoFields.POTENCIALCANVIDEJARAMODUL)? 'mceEditorReadOnly':'mceEditor'}"  path="earInfo.potencialCanviDeJarAModul"  />
           </td>
        </tr>
        </c:if>
        
