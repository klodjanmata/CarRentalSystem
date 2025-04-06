package Repository;

import Entities.Client;
import Entities.Rental;
import Entities.Vehicle;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



    public class RentalRepository {


        public void save(Rental rental) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.merge(rental);  // Persisting the vehicle to the database
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void delete(Rental rental) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.remove(rental);  // Using remove to delete the vehicle
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public Vehicle getRentalById(String registrationNumber) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.find(Vehicle.class, registrationNumber);  // Finds the vehicle by registration number
            }
        }


        public List<Rental> findAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                //return session.createQuery("from Actors").list();
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Rental> cq = cb.createQuery(Rental.class);
                Root<Rental> root = cq.from(Rental.class);
                cq.select(root); // <- correct way

                return session.createQuery(cq).getResultList();
            }
        }
    }




