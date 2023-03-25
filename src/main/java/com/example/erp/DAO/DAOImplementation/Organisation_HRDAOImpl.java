package com.example.erp.DAO.DAOImplementation;

import com.example.erp.Bean.Organisation;
import com.example.erp.Bean.Organisation_HR;
import com.example.erp.DAO.Organisation_HRDAO;
import com.example.erp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Organisation_HRDAOImpl implements Organisation_HRDAO {

    @Override
    public boolean addOrganisation_hr(Organisation_HR orghrObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(orghrObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }


    @Override
    public boolean deletehr(int orghr_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            List<Organisation_HR> list = new ArrayList<>(
                    session.createQuery("from Organisation_HR where organisationHRID= :orghr_id")
                            .setParameter("orghr_id",orghr_id).list()
            );

            session.delete(list.get(0));
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
//    @Override
//    public boolean deletehr(int orghr_id) {
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//            //first fetch object and then delete it
//            Organisation_HR orghrObj= session.get(Organisation_HR.class, orghr_id);
//            session.delete(orghrObj);
//            t.commit();
//            System.out.println( "HR Deleted having ID - "+ orghr_id);
//            return true;
//        }
//        catch (HibernateException exception){
//            System.out.print(exception.getLocalizedMessage());
//            return false;
//        }
//    }

    @Override
    public List<Organisation_HR> viewDetails(Organisation_HR s) {
        List<Organisation_HR> hrList = new ArrayList<>();
        Session session = HibernateSessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Organisation_HR ").list()) {
                hrList.add((Organisation_HR) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return hrList;

    }




    @Override
    public boolean updateDetails(int hr_id,Organisation_HR orghr) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Query query = session.createQuery("update Organisation_HR set organisationhr_contact_no=:organisationhr_contact_no,organisationhr_email=:organisationhr_email ,organisationHRID=:organisationID where organisationHRID=:hr_id");
            query.setParameter("hr_id", orghr.getOrganisationHRID());
            query.setParameter("organisationhr_email", orghr.getOrganisationhr_email());
            query.setParameter("organisationhr_contact_no", orghr.getOrganisationhr_contact_no());
            query.setParameter("organisationID", orghr.getOrganisationHRID());

            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
           return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }

//    @Override
//    public List<Organisation_HR> getHR(){
//    try (Session session = HibernateSessionUtil.getSession()){
//            List<Organisation_HR> orghrList = new ArrayList<>();
//            for (final Object d : session.createQuery("from Organisation_HR ").list()) {
//                orghrList.add((Organisation_HR) d);
//            }
//            return orghrList;
//
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//            return null;
//        }
//    }

    @Override
    public Organisation_HR getHRByID(int orghrID) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Organisation_HR.class, orghrID);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Organisation_HR> getOrganisation_HRList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Organisation_HR> HRList = new ArrayList<>();
            for (final Object o : session.createQuery("from Organisation_HR").list()) {
                HRList.add((Organisation_HR) o);
            }
            return HRList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

}
