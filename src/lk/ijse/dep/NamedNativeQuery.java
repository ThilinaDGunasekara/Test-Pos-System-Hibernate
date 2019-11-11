package lk.ijse.dep;

import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;


public class NamedNativeQuery {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            //Native Hibernate
            NativeQuery<Items> query3 = session.getNamedNativeQuery("query3").addEntity(Items.class);
            List<Items> list = query3.list();
            list.forEach(System.out::println);

            //JPA
            Query<Items> query4 = session.createNamedQuery("query4");
            List<Items> list1 = query4.list();
            list1.forEach(System.out::println);


            session.getTransaction().commit();
        }
    }
}
