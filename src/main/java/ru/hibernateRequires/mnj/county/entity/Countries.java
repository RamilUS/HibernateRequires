package ru.hibernateRequires.mnj.county.entity;

import ru.hibernateRequires.mnj.user.entity.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Citizenship")
public class Countries {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Код страны
     */
    private Integer code;

    /**
     * Название страны
     */
    @Column(nullable = false)
    private String name;

    /**
     * Список пользователей
     */
    @OneToMany(mappedBy = "country")
    private Set<User> users;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        if (users == null){
            users = new HashSet<User>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString(){
        return getCode()+" "+getName();
    }
}
