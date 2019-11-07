package lk.ijse.dep.entity.util;

import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.entity.Items;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){

        // 1
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("application.properties")
                .build();

        //2
        Metadata metadata = new MetadataSources( standardRegistry )

                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Items.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        //3
        return metadata.getSessionFactoryBuilder()
                .build();

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
