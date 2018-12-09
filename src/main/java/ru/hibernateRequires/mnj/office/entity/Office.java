package ru.hibernateRequires.mnj.office.entity;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {
    public Office() {
    }
public Office (Long id, Long orgId, String name, String address, String phone, Boolean isActive){
            this.id = id;
            this.orgId = orgId;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.isActive = isActive;
        }
    public Office (Long orgId, String name, String address, String phone, Boolean isActive){
            this.orgId = orgId;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.isActive = isActive;
        }

        @Id
        @GeneratedValue
        @Column
        private Long id;
        @Version
        private Integer version;
        @Column(name = "orgId")
        private Long orgId;
        @Column(name = "name", length = 50, nullable = false)
        private String name;
        @Column(name = "address", length = 100, nullable = false)
        private String address;
        @Column(name = "phone", length = 15, nullable = false)
        private String phone;
        @Column(name= "isActive", nullable = false)
        private Boolean isActive;


        public Long getId() {
            return id;
        }
        public Long getOrg_id(){return orgId;}
        public String getName() {
            return name;
        }
        public String getAddress() {
            return address;
        }
        public String getPhone() {
            return phone;
        }
        public Boolean isActive() {
            return isActive;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

