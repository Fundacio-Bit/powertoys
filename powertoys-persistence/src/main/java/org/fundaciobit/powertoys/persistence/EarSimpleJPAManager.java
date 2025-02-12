
package org.fundaciobit.powertoys.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.powertoys.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EarSimpleJPAManager
         extends AbstractJPAManager<EarSimple, Long>
         implements EarSimpleIJPAManager, IEarSimpleManager, EarSimpleFields {



    public static final TableName<EarSimple> _TABLENAME =  new TableName<EarSimple>("EarSimpleJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EarSimpleJPAManager() {
    }

    protected EarSimpleJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EarSimpleJPA. class;
    }



    public TableName<EarSimple> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public EarSimple[] listToArray(List<EarSimple> list)  {
        if(list == null) { return null; };
        return list.toArray(new EarSimple[list.size()]);
    };

    public EarSimple create( long _fitxerID_, java.lang.String _nom_, java.lang.String _detall_, java.sql.Timestamp _data_) throws I18NException {
        EarSimpleJPA __bean =  new EarSimpleJPA(_fitxerID_,_nom_,_detall_,_data_);
        return create(__bean);
    }



 public void delete(long _earSimpleID_) {
   delete(findByPrimaryKey(_earSimpleID_));
 }




    public EarSimple findByPrimaryKey(long _earSimpleID_) {
        return __em.find(EarSimpleJPA.class, _earSimpleID_);  
    }
    @Override
    protected EarSimple getJPAInstance(EarSimple __bean) {
        return convertToJPA(__bean);
    }


    public static EarSimpleJPA convertToJPA(EarSimple __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EarSimpleJPA) {
        return (EarSimpleJPA)__bean;
      }
      
      return EarSimpleJPA.toJPA(__bean);
    }


}