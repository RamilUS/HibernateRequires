package ru.hibernateRequires.mnj.organization.view;

public class OrganizationView extends OrganizationViewList{
    public Integer version;

    public String fullName;

    public String address;

    public String inn;

    public String kpp;

    public String phone;

    @Override
    public String toString(){
        return fullName+" "+address+" "+phone;
    }
}
