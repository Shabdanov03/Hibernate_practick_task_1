package java8.config;

import jakarta.persistence.EntityManagerFactory;
import java8.models.Laptop;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * Shabdanov Ilim
 **/
public class HibernateConfig {
    public static EntityManagerFactory getSession() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "postgres");

            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Laptop.class);
            System.out.println("Successfully connected.....!");
            return configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
