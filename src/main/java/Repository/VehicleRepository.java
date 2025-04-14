package Repository;



import Entities.Vehicle;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

    public class VehicleRepository {


        public void save(Vehicle vehicle) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.merge(vehicle);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void delete(Vehicle vehicle) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.remove(vehicle);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.find(Vehicle.class, registrationNumber);  // Finds the vehicle by registration number
            }
        }


        public List<Vehicle> findAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {

                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Vehicle> cq = cb.createQuery(Vehicle.class);
                Root<Vehicle> root = cq.from(Vehicle.class);
                cq.select(root); // <- correct way

                return session.createQuery(cq).getResultList();
            }
        }



    }


