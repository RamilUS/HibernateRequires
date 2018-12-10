package ru.hibernateRequires.mnj.user.dao;

import ru.hibernateRequires.mnj.user.entity.User;

import java.util.List;

public interface UserDao {
    List<User> all();
    User loadByID(Long id);
    List<User> GetFilter(Long officeid, String firstname,String second_name, String middle_name,String position, Integer doc_code , String citizenship_code  );

    void save (User user);
    void update(User user);
}
