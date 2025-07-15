
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.powertoys.ejb.CompilacioService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.model.fields.CompilacioFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class CompilacioRefList extends RefListBase implements CompilacioFields {

    @EJB(mappedName = CompilacioService.JNDI_NAME)
    private CompilacioService compilacioEjb;

    public CompilacioRefList(CompilacioRefList __clone) {
        super(__clone);
        this.compilacioEjb = __clone.compilacioEjb;
    }

    public CompilacioRefList() {
        setSelects(new Select<?>[] { DATAINICI.select });
    }

    public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
        Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
        List<StringKeyValue> list = compilacioEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
    }
}
