<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="RepoCompilacioFields" className="org.fundaciobit.powertoys.model.fields.RepoCompilacioFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.REPOCOMPILACIOID)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.REPOCOMPILACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.NOM)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.ORGANITZACIOGITHUB)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.ORGANITZACIOGITHUB)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.REPOSITORIGITHUB)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.REPOSITORIGITHUB)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.ORDRE)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.ORDRE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,RepoCompilacioFields.ACTIU)}">
        <th>${pwt:getSortIcons(__theFilterForm,RepoCompilacioFields.ACTIU)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pwt:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

