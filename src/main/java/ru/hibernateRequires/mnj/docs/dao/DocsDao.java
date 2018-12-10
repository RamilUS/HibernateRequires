package ru.hibernateRequires.mnj.docs.dao;

import ru.hibernateRequires.mnj.docs.entity.Docs;

import java.util.List;

public interface DocsDao {
    List<Docs> all();
    Docs loadById (Long id);
    void save (Docs docs);
}
