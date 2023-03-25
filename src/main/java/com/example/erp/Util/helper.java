package com.example.erp.Util;

import com.example.erp.Bean.Organisation;
import com.example.erp.DAO.DAOImplementation.OrganisationDAOImpl;

public class helper {
    public static  void main(String[] args) {
        OrganisationDAOImpl organisationDAO = new OrganisationDAOImpl();
        Organisation org = new Organisation(5,103,"axxabs","loxxo");
        organisationDAO.updateDetailsorg(org);
    }
}
