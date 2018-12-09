package ru.hibernateRequires.mnj.organization.dao;

import ru.hibernateRequires.mnj.organization.entity.Organization;

import java.sql.SQLException;
import java.util.List;

public interface OrganizatioDao {
    List<Organization> all() throws SQLException;

    Organization loadById(int id) throws SQLException;

    void save(Organization organization) throws SQLException;

    void update (Organization organization) throws SQLException;
}
