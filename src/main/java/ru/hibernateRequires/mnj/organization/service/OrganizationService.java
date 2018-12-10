package ru.hibernateRequires.mnj.organization.service;


import ru.hibernateRequires.mnj.organization.view.OrganizationView;
import ru.hibernateRequires.mnj.organization.view.OrganizationViewList;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationService {

    List<OrganizationViewList> organizations() throws SQLException;
    void saveOrganization(OrganizationView organization) throws SQLException ;

    void updateOrganization(OrganizationView organization) throws SQLException ;

    OrganizationView loadById(int id) throws SQLException ;

}