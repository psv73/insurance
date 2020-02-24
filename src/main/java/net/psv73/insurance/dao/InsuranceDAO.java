package net.psv73.insurance.dao;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.util.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InsuranceDAO {

    public static List getAllInsurance() {
        List insurances = null;

        Transaction tx = null;

        try (Session session = HibernateUtils.getSession()) {
            tx = session.beginTransaction();

            insurances = session.createQuery("from Insurance order by dateStamp desc").list();

            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
//            error = he.getMessage();
        }

        return insurances;
    }

    public static Insurance getInsuranceByID(String idStr) {
        String error = null;
        Insurance insurance = null;

        long id = 0;

        try {
            id = Long.parseLong(idStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Transaction tx = null;

        try (Session session = HibernateUtils.getSession()) {
            tx = session.beginTransaction();

            insurance = session.get(Insurance.class, id);

            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            error = he.getMessage();
            he.printStackTrace();
        }

        return insurance;
    }

    public static String addInsurance(Insurance insurance) {
        String error = null;

        Transaction tx = null;

        try (Session session = HibernateUtils.getSession()) {
            tx = session.beginTransaction();

            session.save(insurance);

            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            error = he.getMessage();
            he.printStackTrace();
        }

        return error;
    }

    public static String deleteInsurance(String insurance) {
        String error = null;

        Insurance art = InsuranceDAO.getInsuranceByID(insurance);
        if (art == null) {
            error = "Insurance not found";
            return error;
        }

        Transaction tx = null;

        try (Session session = HibernateUtils.getSession()) {
            tx = session.beginTransaction();
            session.delete(art);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            error = he.getMessage();
            he.printStackTrace();
        }

        return error;
    }

    public static String updateInsurance(Insurance insurance) {
        String error = null;

        Transaction tx = null;

        try (Session session = HibernateUtils.getSession()) {
            tx = session.beginTransaction();
            session.update(insurance);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            error = he.getMessage();
            he.printStackTrace();
        }

        return error;
    }

}
