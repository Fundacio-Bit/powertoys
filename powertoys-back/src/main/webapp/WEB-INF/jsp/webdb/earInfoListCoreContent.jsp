<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarInfoFields" className="org.fundaciobit.powertoys.model.fields.EarInfoFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[earInfo.earinfoID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.EARINFOID)}">
          <td>
          ${earInfo.earinfoID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.EARID)}">
          <td>
          <c:set var="tmp">${earInfo.earID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfEarForEarID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.FILENAME)}">
          <td>
          ${earInfo.fileName}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.ERRORS)}">
          <td>
          ${earInfo.errors}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.REDHATJARSTOMODULES)}">
          <td>
          ${earInfo.redhatJarsToModules}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)}">
          <td>
          ${earInfo.jbossDeploymentStructure}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.POTENCIALCANVIDEJARAMODUL)}">
          <td>
          ${earInfo.potencialCanviDeJarAModul}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[earInfo.earinfoID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


