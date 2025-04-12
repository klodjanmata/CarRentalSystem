package Repository;

import Entities.Client;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientRepository {

        public void save(Client client){
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.persist(client);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public void delete(Client client) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.merge(client);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public Client getClientById(int id) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                return session.find(Client.class, id);
            }
        }

        public List<Client> findAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Client> cq = cb.createQuery(Client.class);
                Root<Client> root = cq.from(Client.class);
                cq.select(root); // <- correct way

                return session.createQuery(cq).getResultList();
            }
        }

    }

