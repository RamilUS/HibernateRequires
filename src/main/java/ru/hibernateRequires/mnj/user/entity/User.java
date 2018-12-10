package ru.hibernateRequires.mnj.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @javax.persistence.Version
    private Integer Version;
    @Column(name = "officeId")
    private Long officeId;
    @Column (name = "firstName", length = 50,nullable = false)
    private String firstName;
    @Column (name = "secondName", length = 50,nullable = false)
    private String secondName;
    @Column (name = "middleName", length = 50,nullable = false)
    private String middleName;
    @Column (name = "position", length = 30,nullable = false)
    private String position;
    @Column (name = "phone", length = 15,nullable = false)
    private String phone;
    @Column(name = "docCode" , nullable = false)
    private Integer docCode;
    @Column (name = "docName", length = 50,nullable = false)
    private String docName;
    @Column (name = "docNumber", length = 15,nullable = false)
    private String docNumber;
    @Column(name = "docNate" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date docDate;
    @Column (name = "citizenshipCode", length = 10,nullable = false)
    private String citizenshipCode;
    @Column(name = "isIdentified" , nullable = false)
    private Boolean isIdentified;
    /*
        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "DOC_CODE", referencedColumnName = "code")
        private Docs Doc;
    */
    public User(){

    }

    public User (Long id , Long officeId, String firstName, String secondName, String middleName, String position, String phone, Integer docCode, String docName, String docNumber, Date docDate, String citizenshipCode, Boolean isIdentified){
        this.id = id;
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public User(Long officeId, String firstName,String secondName, String middleName,String position, String phone, Integer docCode, String docName, String docNumber, Date docDate, String citizenshipCode, Boolean isIdentified){
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public Long getOffice_id(){
        return officeId;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDoc_date() {
        return docDate;
    }

    public Integer getDoc_Code() {
        return docCode;
    }

    public Boolean isIs_identified() {
        return isIdentified;
    }

    public String getCitizenship_code() {
        return citizenshipCode;
    }

    public String getDoc_name() {
        return docName;
    }

    public String getDoc_number() {
        return docNumber;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getMiddle_name() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getSecond_name() {
        return secondName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}