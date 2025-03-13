
package org.fundaciobit.powertoys.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.powertoys.model.fields.*;
import org.fundaciobit.powertoys.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class RepoCompilacioJPAManager
         extends AbstractJPAManager<RepoCompilacio, Long>
         implements RepoCompilacioIJPAManager, IRepoCompilacioManager, RepoCompilacioFields {



    public static final TableName<RepoCompilacio> _TABLENAME =  new TableName<RepoCompilacio>("RepoCompilacioJPA");


    @PersistenceContext
    protected EntityManager __em;

    public RepoCompilacioJPAManager() {
    }

    protected RepoCompilacioJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return RepoCompilacioJPA. class;
    }



    public TableName<RepoCompilacio> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public RepoCompilacio[] listToArray(List<RepoCompilacio> list)  {
        if(list == null) { return null; };
        return list.toArray(new RepoCompilacio[list.size()]);
    };

    public RepoCompilacio create( java.lang.String _nom_, java.lang.String _organitzacioGitHub_, java.lang.String _repositoriGitHub_, java.lang.Long _ordre_, boolean _actiu_) throws I18NException {
        RepoCompilacioJPA __bean =  new RepoCompilacioJPA(_nom_,_organitzacioGitHub_,_repositoriGitHub_,_ordre_,_actiu_);
        return create(__bean);
    }



 public void delete(long _repocompilacioID_) {
   delete(findByPrimaryKey(_repocompilacioID_));
 }




    public RepoCompilacio findByPrimaryKey(long _repocompilacioID_) {
        return __em.find(RepoCompilacioJPA.class, _repocompilacioID_);  
    }
    @Override
    protected RepoCompilacio getJPAInstance(RepoCompilacio __bean) {
        return convertToJPA(__bean);
    }


    public static RepoCompilacioJPA convertToJPA(RepoCompilacio __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof RepoCompilacioJPA) {
        return (RepoCompilacioJPA)__bean;
      }
      
      return RepoCompilacioJPA.toJPA(__bean);
    }


}