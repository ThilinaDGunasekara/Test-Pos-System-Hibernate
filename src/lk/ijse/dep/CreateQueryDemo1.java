package lk.ijse.dep;

import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class CreateQueryDemo1 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            Query<Items> query = session.createQuery("select i from ItSems i WHERE  i.id = 'I001'", Items.class);

            //Native Hibernate
            Items items = query.uniqueResult();

            //JPA
            Items items1 = query.getSingleResult();

            System.out.println(items);
            System.out.println("\n"+items1);

            session.getTransaction().commit();
        }
    }
}
