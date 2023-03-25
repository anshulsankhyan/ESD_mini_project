package com.example.erp.DAO;

import com.example.erp.Bean.Organisation;

import java.util.List;

public interface OrganisationDAO {
    boolean addOrganisation(Organisation orgObj);

    List<Organisation> viewDetailsorg(Organisation s);

    boolean updateDetailsorg(Organisation org);

    boolean deleteOrganisation(int org_id);

    List<Organisation> getOrganisationList();
}