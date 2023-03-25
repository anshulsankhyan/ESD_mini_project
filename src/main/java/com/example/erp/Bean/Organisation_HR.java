package com.example.erp.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "organisation_HR")
public class Organisation_HR {

    public int getOrganisationHRIndex() {
        return organisationHRIndex;
    }

    public void setOrganisationHRIndex(int organisationHRIndex) {
        this.organisationHRIndex = organisationHRIndex;
    }

    @Id
    @Column(name ="org_hr_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organisationHRIndex;

    @Column(name ="orghr_id",nullable = false,unique = true)
    private int organisationHRID;

    @Column(name="orghr_first_name",nullable = false,unique = true)
    private String organisationhr_first_name;

    @Column(name="orghr_last_name",unique = true)
    private String organisationhr_last_name;

    @Column(name="orghr_email")
    private String organisationhr_email;

    @Column(name="orghr_contact_number")
    private String organisationhr_contact_no;

    @OneToOne
    @JoinColumn(name="org_index")
    private Organisation organisationIndex;

    public int getOrganisationHRID() {
        return organisationHRID;
    }

    public void setOrganisationHRID(int organisationHRID) {
        this.organisationHRID = organisationHRID;
    }

    public String getOrganisationhr_first_name() {
        return organisationhr_first_name;
    }

    public void setOrganisationhr_first_name(String organisationhr_first_name) {
        this.organisationhr_first_name = organisationhr_first_name;
    }

    public String getOrganisationhr_last_name() {
        return organisationhr_last_name;
    }

    public void setOrganisationhr_last_name(String organisationhr_last_name) {
        this.organisationhr_last_name = organisationhr_last_name;
    }

    public String getOrganisationhr_contact_no() {
        return organisationhr_contact_no;
    }

    public void setOrganisationhr_contact_no(String organisationhr_contact_no) {
        this.organisationhr_contact_no = organisationhr_contact_no;
    }

    public String getOrganisationhr_email() {
        return organisationhr_email;
    }


    public void setOrganisationhr_email(String organisationhr_email) {
        this.organisationhr_email = organisationhr_email;
    }

    public Organisation getOrganisationIndex() {
        return organisationIndex;
    }

    public void setOrganisationIndex(Organisation organisationIndex) {
        this.organisationIndex = organisationIndex;
    }

    @Override
    public String toString() {
        return "Organisation_HR{" +
                "organisationHRIndex=" + organisationHRIndex +
                ", organisationHRID=" + organisationHRID +
                ", organisationhr_first_name='" + organisationhr_first_name + '\'' +
                ", organisationhr_last_name='" + organisationhr_last_name + '\'' +
                ", organisationhr_email='" + organisationhr_email + '\'' +
                ", organisationhr_contact_no='" + organisationhr_contact_no + '\'' +
                ", organisationID=" + organisationIndex +
                '}';
    }

}
