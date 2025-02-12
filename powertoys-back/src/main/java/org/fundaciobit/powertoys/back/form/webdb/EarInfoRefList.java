
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.powertoys.ejb.EarInfoService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.model.fields.EarInfoFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EarInfoRefList extends RefListBase
    implements EarInfoFields {

  @EJB(mappedName = EarInfoService.JNDI_NAME)
  private EarInfoService earInfoEjb;

  public EarInfoRefList(EarInfoRefList __clone) {
    super(__clone);
    this.earInfoEjb = __clone.earInfoEjb;
  }
  public EarInfoRefList() {
    setSelects(new Select<?>[] { FILENAME.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = earInfoEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
