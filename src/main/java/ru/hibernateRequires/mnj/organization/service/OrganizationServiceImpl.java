package ru.hibernateRequires.mnj.organization.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hibernateRequires.mnj.organization.dao.OrganizationDao;
import ru.hibernateRequires.mnj.organization.entity.Organization;
import ru.hibernateRequires.mnj.organization.view.OrganizationView;
import ru.hibernateRequires.mnj.organization.view.OrganizationViewList;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrganizationDao organizationDao;


    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao){
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationViewList> organizations() throws SQLException {
        List<Organization> offices = organizationDao.all();
        return offices.stream()
                .map(mapOrganization())
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrganization(OrganizationView view) throws SQLException {
        organizationDao.save(viewToOrganization(view));
    }

    @Override
    public void updateOrganization(OrganizationView view) throws SQLException {
        organizationDao.update(viewToOrganization(view));
    }

    @Override
    public OrganizationView loadById(int id) throws SQLException {
        return organizationToView(organizationDao.loadById(id));
    }

    private Function<Organization,OrganizationViewList> mapOrganization(){
        return o -> {
            return organizationToViewList(o);
        };
    }

    private OrganizationViewList organizationToViewList(Organization office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationViewList.class,Organization.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,OrganizationViewList.class);
    }

    private Organization viewToOrganization(OrganizationView view){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationView.class,Organization.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(view,Organization.class);
    }

    private OrganizationView organizationToView(Organization office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationView.class,Organization.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office, OrganizationView.class);
    }
}
