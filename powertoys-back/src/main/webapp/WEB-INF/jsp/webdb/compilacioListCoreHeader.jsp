<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="CompilacioFields" className="org.fundaciobit.powertoys.model.fields.CompilacioFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.COMPILACIOID)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.COMPILACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.REPOCOMPILACIOID)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.REPOCOMPILACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.TAGURL)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.TAGURL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.DATAINICI)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.DATAINICI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.DATAFI)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.DATAFI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.EXITCODE)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.EXITCODE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,CompilacioFields.OUTPUT)}">
        <th>${pwt:getSortIcons(__theFilterForm,CompilacioFields.OUTPUT)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

