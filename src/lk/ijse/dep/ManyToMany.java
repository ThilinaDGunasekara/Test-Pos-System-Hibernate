package lk.ijse.dep;

import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;


public class ManyToMany {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            Items item1 = new Items("I001", "Pen", 100, 50);

            Order oi001 = new Order("OI005", Date.valueOf("2019-11-07"));
            session.persist(item1);
            session.persist(oi001);


//            Order oi001 = session.get(Order.class, "OI005");
            Items i001 = session.get(Items.class, "I001");
            System.out.println(oi001);
            System.out.println(i001);

            OrderDetail od1 = new OrderDetail(i001.getItemId(),oi001.getId(), 10, 250);
            session.persist(od1);

            session.getTransaction().commit();
        }
    }
}
