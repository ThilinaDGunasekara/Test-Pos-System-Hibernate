package lk.ijse.dep;

import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;


public class CreateQueryDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            Query<Items> query = session.createQuery("select i From Items i", Items.class);
            List<Items> list = query.list();
            Items items = list.get(0);

            list.forEach(System.out::println);

            items.setUnitPrice(1000);
            System.out.println(items.getUnitPrice());

            session.getTransaction().commit();
        }
    }
}
