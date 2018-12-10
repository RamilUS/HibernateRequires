package ru.hibernateRequires.mnj.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.hibernateRequires.mnj.organization.entity.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class OrganizationDaoImpl implements OrganizationDao {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Organization> all() throws SQLException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(Organization.class);
        cQuery.from(Organization.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }


    @Override
    public Organization loadById(int id) throws SQLException {
        return em.find(Organization.class, id);
    }


    @Override
    public void save(Organization organization) throws SQLException {
        em.persist(organization);
    }



    @Override
    public void update(Organization organization) throws SQLException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Organization> cUpdate = builder.createCriteriaUpdate(Organization.class);
        Root organizations = cUpdate.from(Organization.class);
        cUpdate.where(builder.equal(organizations.get("id"),organization.getId()));
        cUpdate.set("isactive",organization.getIsactive());
        cUpdate.set("phone",organization.getPhone());
        cUpdate.set("address",organization.getAddress());
        cUpdate.set("name",organization.getName());
        cUpdate.set("fullname",organization.getFullname());
        cUpdate.set("inn",organization.getInn());
        cUpdate.set("kpp",organization.getKpp());

        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }


}
