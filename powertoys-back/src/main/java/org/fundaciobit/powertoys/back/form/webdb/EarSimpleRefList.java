
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.powertoys.ejb.EarSimpleService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.model.fields.EarSimpleFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EarSimpleRefList extends RefListBase
    implements EarSimpleFields {

  @EJB(mappedName = EarSimpleService.JNDI_NAME)
  private EarSimpleService earSimpleEjb;

  public EarSimpleRefList(EarSimpleRefList __clone) {
    super(__clone);
    this.earSimpleEjb = __clone.earSimpleEjb;
  }
  public EarSimpleRefList() {
    setSelects(new Select<?>[] { NOM.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = earSimpleEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
