
package org.fundaciobit.powertoys.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.powertoys.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EarJPAManager
         extends AbstractJPAManager<Ear, Long>
         implements EarIJPAManager, IEarManager, EarFields {



    public static final TableName<Ear> _TABLENAME =  new TableName<Ear>("EarJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EarJPAManager() {
    }

    protected EarJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EarJPA. class;
    }



    public TableName<Ear> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Ear[] listToArray(List<Ear> list)  {
        if(list == null) { return null; };
        return list.toArray(new Ear[list.size()]);
    };

    public Ear create( long _fitxerID_, java.sql.Timestamp _data_, java.lang.String _nom_) throws I18NException {
        EarJPA __bean =  new EarJPA(_fitxerID_,_data_,_nom_);
        return create(__bean);
    }



 public void delete(long _earID_) {
   delete(findByPrimaryKey(_earID_));
 }




    public Ear findByPrimaryKey(long _earID_) {
        return __em.find(EarJPA.class, _earID_);  
    }
    @Override
    protected Ear getJPAInstance(Ear __bean) {
        return convertToJPA(__bean);
    }


    public static EarJPA convertToJPA(Ear __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EarJPA) {
        return (EarJPA)__bean;
      }
      
      return EarJPA.toJPA(__bean);
    }


}