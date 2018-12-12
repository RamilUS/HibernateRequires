package ru.hibernateRequires.mnj.docs.entity;

import ru.hibernateRequires.mnj.user.entity.User;

import javax.persistence.*;

@Entity(name = "docs")
public class Docs {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Version
    private Integer version;
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "code",  nullable = false)
    private Integer code;

     private User user;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
        public User user (){
            return user;
        };
    public String getName(){return name;}
    public Long getId (){return id;}
    public Integer getCode() {return code;}

}
