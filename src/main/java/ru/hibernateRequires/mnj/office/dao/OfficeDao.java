package ru.hibernateRequires.mnj.office.dao;

import ru.hibernateRequires.mnj.office.entity.Office;

import java.util.List;

public interface OfficeDao {
    List<Office> all();

    Office loadByID (long id);

    List<Office> getFilter(Long orgId, String name , Boolean is_active);

    void save(Office organization);

    void update (Office organization);

}
