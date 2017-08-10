package fr.leansys.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


/**
 * Created by srenno on 21/07/2017.
 */
//@Transactional(propagation = Propagation.SUPPORTS)
@Slf4j
@EnableTransactionManagement
public class GenericDao<E, PK extends Serializable> {

    protected Class<E> persistanceClass;
    /**
     * Entity manager *
     */
    @PersistenceContext
    private EntityManager entityManager;

    public GenericDao(Class<E> persistanceClass) {
        this.persistanceClass = persistanceClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**********GENERIC CRUD**********/

    //CREATE
    @Transactional
    void Create(E e) {
        log.debug("GenericDao/Create" + e);
        entityManager.persist(e);
    }

    //UPDATE
    @Transactional
    void Update(E e) {
        log.debug("GenericDao/update " + e);
        entityManager.merge(e);
    }

    //DELETE
    @Transactional
    void Delete(Long id) {
        log.debug("GenericDao/Delete" + id);
        //entityManager.remove(entityManager.merge(id));
        Query query = entityManager.createQuery(" DELETE FROM " + persistanceClass.getName() + " WHERE ID = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    //FINDALL
    @Transactional
    public List<E> Find() {
        log.info("GenericDAO/Find persClassName : " + persistanceClass.getName());
        List list = entityManager.createQuery("Select f from " + persistanceClass.getName() + " f").getResultList();
        return list;

    }

    //FINDBYID
    @Transactional
    public E FindbyId(Long id) {
        return entityManager.find(persistanceClass, id);
    }
}

