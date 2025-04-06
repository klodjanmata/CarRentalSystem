package Repository;

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


        public static void save(Rental rental) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.merge(rental);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void delete(Rental rental) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.remove(rental);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public Vehicle getRentalById(String registrationNumber) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.find(Vehicle.class, registrationNumber);
            }
        }


        public List<Rental> findAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {

                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Rental> cq = cb.createQuery(Rental.class);
                Root<Rental> root = cq.from(Rental.class);
                cq.select(root);

                return session.createQuery(cq).getResultList();
            }
        }
    }




