package com.example.erp.DAO.DAOImplementation;

import com.example.erp.Bean.Organisation;
import com.example.erp.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrganisationDAOImpl implements com.example.erp.DAO.OrganisationDAO {

    @Override
    public boolean addOrganisation(Organisation orgObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(orgObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Organisation> viewDetailsorg(Organisation s) {
        List<Organisation> orgList = new ArrayList<>();
        Session session = HibernateSessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Organisation").list()) {
                orgList.add((Organisation) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return orgList;

    }

    /*@Override
    public boolean updateDetailsorg(Organisation org) {
        try (Session session = HibernateSessionUtil.getSession()) {

            Transaction transaction = session.beginTransaction();

            List<Organisation> list = new ArrayList<>(
                    session.createQuery("from Organisation  where organisationID =:org")
                            .setParameter("org",org.getOrganisationID()).list()
            );
            list.get(0).setOrganisationAddress(org.getOrganisationAddress());
            session.update(list.get(0));
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }*/

    // This method also updates organisation name and id.
    @Override
    public boolean updateDetailsorg(Organisation org) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
//            //session.saveOrUpdate(org);
            System.out.println(org.getOrganisationID());
                        List<Organisation> list = new ArrayList<>(
                    session.createQuery("from Organisation  where organisationID =:org")
                            .setParameter("org",org.getOrganisationID()).list()
            );

           Organisation  orgg = session.get(Organisation.class,org.getOrganisationID());
            System.out.println(orgg.getOrganisationName());
            System.out.println(orgg.getOrganisationAddress());
          //  orgg.setOrganisationAddress(org.getOrganisationAddress());
            orgg.setOrganisationName(org.getOrganisationName());
            session.persist(orgg);


//
//          list.get(0).setOrganisationName(org.getOrganisationName());
//           session.update(list.get(0));
//           transaction.commit();
//           list.get(0).setOrganisationAddress(org.getOrganisationAddress());
//
//
//           session.update(list.get(0));
           transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }

    @Override
    public boolean deleteOrganisation(int org_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            Organisation obj = (Organisation) session.createQuery("from Organisation where organisationID= :org_id")
                    .setParameter("org_id",org_id).list().get(0);

            session.delete(obj);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }


    @Override
    public List<Organisation> getOrganisationList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Organisation> organisationList = new ArrayList<>();
            for (final Object o : session.createQuery("from Organisation").list()) {
                organisationList.add((Organisation) o);
            }
            return organisationList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}