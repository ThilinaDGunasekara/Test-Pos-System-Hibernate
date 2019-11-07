package lk.ijse.dep;

import lk.ijse.dep.entity.*;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.sql.Date;


public class OneToMany {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            /*Customer Alisa = new Customer("C001", "Alisa", "Homagama");
            Customer Waduma = new Customer("C002", "Waduma", "Horana");
            Customer Leon = new Customer("C003", "Leon", "Mathara");
            Customer Ascot = new Customer("C004", "Ascot", "Gampaha");

            Order oi001 = new Order("OI001", Date.valueOf("2019-11-07"));
            Order oi002 = new Order("OI002", Date.valueOf("2019-11-08"));
            Order oi003 = new Order("OI003", Date.valueOf("2019-11-09"));
            Order oi004 = new Order("OI004", Date.valueOf("2019-11-10"));

            oi001.setCustomer(Alisa);
            oi002.setCustomer(Waduma);
            oi003.setCustomer(Leon);

            session.persist(Alisa);
            session.persist(Waduma);
            session.persist(Leon);
            session.persist(Ascot);

            session.persist(oi001);
            session.persist(oi002);
            session.persist(oi003);
            session.persist(oi004);*/

            /*Customer alisa = new Customer("C001", "Alisa", "Pinwatte");
            Order od001 = new Order("OD001", Date.valueOf("2019-11-07"));

            alisa.addOrder(od001);
            session.persist(alisa);*/

            /*Customer alisa = session.get(Customer.class, "C001");
            Order od001 = session.get(Order.class, "OD001");

            alisa.removeOrder(od001);*/


            /*Items item1 = new Items("I001", "Pen", 100, 50);
            Order oi001 = new Order("OD002", Date.valueOf("2019-11-07"));
            session.persist(item1);
            session.persist(oi001);*/

            /*Order oi001 = session.get(Order.class, "OD001");
            Items i001 = session.get(Items.class, "I001");
            System.out.println(oi001);
            System.out.println(i001);

            OrderDetail orderDetail = new OrderDetail(i001.getItemId(), oi001.getId(), 10, 250);*/

            //test3

            /*Order od002 = new Order("OD002", Date.valueOf("2019-11-09"));
            Items sop = new Items("I002", "Sop", 50, 30);
            Items mouse = new Items("I003", "Mouse", 50, 300);

            OrderDetail orderDetail = new OrderDetail(od002.getId(), sop.getItemId(), 10, 30);

            orderDetail.setItems(sop);

            od002.addOrderDetail(orderDetail);

            OrderDetail orderDetail1 = new OrderDetail(new OrderDetailPK(od002.getId(), mouse.getItemId()), 10, 300);

            orderDetail1.setItems(mouse);

            od002.addOrderDetail(orderDetail1);

            session.persist(od002);*/

            //test 4

            /*Order od002 = new Order("OD002", Date.valueOf("2019-11-09"));
            Items sop = new Items("I002", "Sop", 50, 30);
            Items mouse = new Items("I003", "Mouse", 50, 300);

            OrderDetail orderDetail = new OrderDetail(od002.getId(), sop.getItemId(), 10, 30);

            orderDetail.setItems(sop);
            od002.getOrderDetails().add(orderDetail);

            od002.addOrderDetail(orderDetail);

            OrderDetail orderDetail1 = new OrderDetail(new OrderDetailPK(od002.getId(), mouse.getItemId()), 10, 300);

            orderDetail1.setItems(mouse);
            od002.getOrderDetails().add(orderDetail1);

            od002.addOrderDetail(orderDetail1);

            session.persist(od002);*/

            /*Order od001 = new Order("OD001", Date.valueOf("2019-11-10"));
            session.persist(od001);*/

            /*OrderDetail od0021 = session.get(OrderDetail.class,new OrderDetailPK("OD002","I002"));
            session.remove(od0021);*/
            Items items = new Items("I001", "Sop", 10, 20);
            Order od001 = new Order("OD001", Date.valueOf("2019-11-10"));
            session.persist(items);
            session.persist(od001);

            OrderDetail orderDetail = new OrderDetail(od001.getId(),items.getItemId(), 10, 30);
            session.persist(orderDetail);

            session.getTransaction().commit();
        }
    }
}
