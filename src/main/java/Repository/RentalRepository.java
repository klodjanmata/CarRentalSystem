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


        public void save(Rental rental) {
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


        public Rental getRentalById(int id) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.find(Rental.class, id);
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




