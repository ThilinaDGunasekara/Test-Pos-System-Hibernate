package lk.ijse.dep;

import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class SelectQuery {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            //Native Hibernate
            Query<Customer> query1 = session.getNamedQuery("query1");
            System.out.println(query1.list().get(0).getName());

            //JPA
            Query<Customer> query2 = session.createNamedQuery("query2");
            query2.setParameter(1,"A%");
            List<Customer> list = query2.list();

            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
