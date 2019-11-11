package lk.ijse.dep;

import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import sun.security.util.Cache;

import java.util.List;


public class JoinQuery {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();




            /*NativeQuery nativeQuery = session.createNativeQuery("SELECT o.id as order_id,o.date as order_date,SUM(od.unitPrice*od.quantity) AS total , c2.id AS customer_id, c2.name as customer_name " +
                    "FROM `order` o INNER JOIN order_detail od on o.id = od.orderId " +
                    "INNER JOIN customer_order co on o.id = co.order_id " +
                    "INNER JOIN customer c2 on co.customer_id = c2.id WHERE o.id='OD001' GROUP BY o.id");*/
            //using sql -----------
            /*NativeQuery query = session.createNativeQuery("SELECT o.id AS order_id,o.date AS order_date," +
                    "co.customer_id AS customer_id,c.name AS customer_name,SUM(od.quantity*od.unitPrice) AS total " +
                    "FROM order_detail od " +
                    "INNER JOIN `order` o ON  od.orderId = o.id " +
                    "INNER JOIN customer_order co ON o.id = co.order_id " +
                    "INNER JOIN customer c ON co.customer_id = c.id " +
                    "WHERE o.id=\"OD002\" GROUP BY o.id");

            ist<Object[]> list = query.list();

            list.forEach(objects -> {
                System.out.println("-----------------------------");
                System.out.println("OrderId      : "+ objects[0]);
                System.out.println("date         : "+ objects[1]);
                System.out.println("customer id  : "+ objects[2]);
                System.out.println("customer name: "+ objects[3]);
                System.out.println("total        : "+ objects[4]);
                System.out.println("-----------------------------");
            });*/

            /*Query query = session.createQuery("select O.id AS order_id,O.date AS order_date,C.id AS customer_id, C.name AS customer_name,SUM(OD.unitPrice*OD.quantity) AS toatl FROM Order O inner join OrderDetail OD WITH O.id=OD.orderDetailPK.orderId inner join Customer C WITH O.customer.id = C.id group by O.id");
            Object uniqueResult = query.uniqueResult(); */

            /*List<Object[]> list = query.list();
            list.forEach(objects -> {
                System.out.println("-----------------------------");
                System.out.println("OrderId      : "+ objects[0]);
                System.out.println("date         : "+ objects[1]);
                System.out.println("customer id  : "+ objects[2]);
                System.out.println("customer name: "+ objects[3]);
                System.out.println("total        : "+ objects[4]);
                System.out.println("-----------------------------");
            });*/


            //Using native Hibernate(HQL)-------> not necessary to write that SELECT key word
            Query<Customer> query = session.createQuery("from Customer C", Customer.class);
            List<Customer> list = query.list();
            list.forEach(System.out::println);

            System.out.println("///////////////////////////////////////////////////////////////////\n");
            //Using JPA(JPQL)
            Query<Customer> query1 = session.createQuery("SELECT C from Customer C", Customer.class);
            List<Customer> list1 = query1.getResultList();
            list1.forEach(System.out::println);




            session.getTransaction().commit();

        }
    }
}
