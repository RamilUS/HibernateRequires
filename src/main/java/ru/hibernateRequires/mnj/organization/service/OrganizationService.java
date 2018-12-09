package ru.hibernateRequires.mnj.organization.service;


import ru.hibernateRequires.mnj.organization.view.OrganizationView;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationService {

    List<OrganizationView> organization() throws SQLException;

}