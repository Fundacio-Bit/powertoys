
package org.fundaciobit.powertoys.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.powertoys.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EarInfoJPAManager
         extends AbstractJPAManager<EarInfo, Long>
         implements EarInfoIJPAManager, IEarInfoManager, EarInfoFields {



    public static final TableName<EarInfo> _TABLENAME =  new TableName<EarInfo>("EarInfoJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EarInfoJPAManager() {
    }

    protected EarInfoJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EarInfoJPA. class;
    }



    public TableName<EarInfo> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public EarInfo[] listToArray(List<EarInfo> list)  {
        if(list == null) { return null; };
        return list.toArray(new EarInfo[list.size()]);
    };

    public EarInfo create( long _earid_, java.lang.String _fileName_, java.lang.String _errors_, java.lang.String _redhatJarsToModules_, java.lang.String _jbossDeploymentStructure_, java.lang.String _potencialCanviDeJarAModul_) throws I18NException {
        EarInfoJPA __bean =  new EarInfoJPA(_earid_,_fileName_,_errors_,_redhatJarsToModules_,_jbossDeploymentStructure_,_potencialCanviDeJarAModul_);
        return create(__bean);
    }



 public void delete(long _earinfoID_) {
   delete(findByPrimaryKey(_earinfoID_));
 }




    public EarInfo findByPrimaryKey(long _earinfoID_) {
        return __em.find(EarInfoJPA.class, _earinfoID_);  
    }
    @Override
    protected EarInfo getJPAInstance(EarInfo __bean) {
        return convertToJPA(__bean);
    }


    public static EarInfoJPA convertToJPA(EarInfo __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EarInfoJPA) {
        return (EarInfoJPA)__bean;
      }
      
      return EarInfoJPA.toJPA(__bean);
    }


}