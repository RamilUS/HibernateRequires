package ru.hibernateRequires.mnj.county.dao;

import ru.hibernateRequires.mnj.county.entity.Countries;

import java.util.List;

public interface CountriesDao {
    List<Countries> all();
    Countries loadById (Long id);
    void save(Countries countries);
}
