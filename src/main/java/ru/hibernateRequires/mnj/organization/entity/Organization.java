package ru.hibernateRequires.mnj.organization.entity;

import ru.hibernateRequires.mnj.office.entity.Office;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organization")

public class Organization {

   /* public Organization() {

    }

    public Organization(String Name, String fullName ,  String address , String phone , String inn, String kpp, Boolean isActive) {
        this.name = Name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
    public Organization(Integer id, String Name, String fullName ,  String address , String phone , String inn, String kpp, Boolean isActive) {
        this.id = id;
        this.name = Name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }*/

    @Id
    @GeneratedValue
    @Column(name="Id", nullable = false)
    private Integer id;

    @Version
    private Integer version;

    private String name;

    @Column(name = "fullName")
    private String fullName;

    private String address;

    private String phone;

    private String inn;

    private String kpp;

    @Column (name="isActive")
    private Boolean isActive;

    @OneToMany (mappedBy = "organization")
    public Set<Office> office;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsactive() {
        return isActive;
    }

    public void setIsactive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Office> getOffices() {
        return office;
    }

    public void setOffices(Set<Office> office) {
        this.office = office;
    }

}
