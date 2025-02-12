<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EarInfoFields" className="org.fundaciobit.powertoys.model.fields.EarInfoFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.EARINFOID)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.EARINFOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.EARID)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.EARID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.FILENAME)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.FILENAME)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.ERRORS)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.ERRORS)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.REDHATJARSTOMODULES)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.REDHATJARSTOMODULES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EarInfoFields.POTENCIALCANVIDEJARAMODUL)}">
        <th>${pwt:getSortIcons(__theFilterForm,EarInfoFields.POTENCIALCANVIDEJARAMODUL)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

