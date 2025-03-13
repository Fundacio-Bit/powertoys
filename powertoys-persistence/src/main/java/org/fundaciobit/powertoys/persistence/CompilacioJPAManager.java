
package org.fundaciobit.powertoys.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.powertoys.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class CompilacioJPAManager
         extends AbstractJPAManager<Compilacio, Long>
         implements CompilacioIJPAManager, ICompilacioManager, CompilacioFields {



    public static final TableName<Compilacio> _TABLENAME =  new TableName<Compilacio>("CompilacioJPA");


    @PersistenceContext
    protected EntityManager __em;

    public CompilacioJPAManager() {
    }

    protected CompilacioJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return CompilacioJPA. class;
    }



    public TableName<Compilacio> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Compilacio[] listToArray(List<Compilacio> list)  {
        if(list == null) { return null; };
        return list.toArray(new Compilacio[list.size()]);
    };

    public Compilacio create( long _repocompilacioID_, java.lang.String _tagUrl_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, short _exitCode_, java.lang.String _output_) throws I18NException {
        CompilacioJPA __bean =  new CompilacioJPA(_repocompilacioID_,_tagUrl_,_dataInici_,_dataFi_,_exitCode_,_output_);
        return create(__bean);
    }



 public void delete(long _compilacioID_) {
   delete(findByPrimaryKey(_compilacioID_));
 }




    public Compilacio findByPrimaryKey(long _compilacioID_) {
        return __em.find(CompilacioJPA.class, _compilacioID_);  
    }
    @Override
    protected Compilacio getJPAInstance(Compilacio __bean) {
        return convertToJPA(__bean);
    }


    public static CompilacioJPA convertToJPA(Compilacio __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof CompilacioJPA) {
        return (CompilacioJPA)__bean;
      }
      
      return CompilacioJPA.toJPA(__bean);
    }


}