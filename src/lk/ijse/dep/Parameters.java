package lk.ijse.dep;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class Parameters {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            Query<Items> query = session.createQuery("select i from Items i WHERE i.id LIKE ?1 AND i.description LIKE ?2", Items.class);

            query.setParameter(1,"I%");
            query.setParameter(2,"S%");

            List<Items> list = query.list();
            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
