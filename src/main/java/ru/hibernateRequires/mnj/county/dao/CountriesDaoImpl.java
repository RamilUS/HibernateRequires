package ru.hibernateRequires.mnj.county.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.hibernateRequires.mnj.county.entity.Countries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class CountriesDaoImpl implements CountriesDao {
    private final EntityManager em;

    @Autowired
    public CountriesDaoImpl (EntityManager em){
        this.em = em;
    }

    @Override
    public List<Countries> all(){
        TypedQuery<Countries> query = em.createQuery("SELECT h FROM Countries h" , Countries.class);
        return query.getResultList();
    }

    @Override
    public Countries loadById (Long id){
        return em.find(Countries.class,id);
    }

    @Override
    public void save (Countries countries){
        em.persist(countries);
    }

}

