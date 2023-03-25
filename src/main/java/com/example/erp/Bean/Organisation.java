package com.example.erp.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "organisation")
public class Organisation {

    @Id
    @Column(name ="org_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organisationIndex;

    @Column(name ="org_id",nullable = false,unique = true)
    private int organisationID;

    @Column(name="name",nullable = false)
    private String organisationName;

    @Column(name="org_address")
    private String organisationAddress;

    public Organisation() {
    }

    public Organisation(int organisationIndex, int organisationID, String organisationName, String organisationAddress) {
        this.organisationIndex = organisationIndex;
        this.organisationID = organisationID;
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
    }

    public int getOrganisationIndex() {
        return organisationIndex;
    }

    public void setOrganisationIndex(int organisationIndex) {
        this.organisationIndex = organisationIndex;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationAddress() {
        return organisationAddress;
    }

    public void setOrganisationAddress(String organisationAddress) {
        this.organisationAddress = organisationAddress;
    }
}
