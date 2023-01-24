package java8.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java8.config.HibernateConfig;
import java8.enums.OperationSystem;
import java8.exception.LaptopException;
import java8.models.Laptop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Shabdanov Ilim
 **/
public class LaptopDaoImpl implements LaptopDao, AutoCloseable {
    private final EntityManagerFactory managerFactory = HibernateConfig.getSession();


    @Override
    public Laptop saveProgrammer(Laptop laptop) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(laptop);
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptop;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Laptop laptop : laptops) {
                entityManager.persist(laptop);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Laptop deleteById(Long id) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptop result = entityManager.createQuery("select l from Laptop l  where l.id = :id", Laptop.class)
                    .setParameter("id", id).getSingleResult();
            entityManager.remove(result);
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAll() {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Laptop").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully deleted... ");
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Laptop> findAll() {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> laptops = entityManager.createQuery("from Laptop ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptop oldLaptop = entityManager.getReference(Laptop.class, id);
            oldLaptop.setBrand(laptop.getBrand());
            oldLaptop.setPrice(laptop.getPrice());
            oldLaptop.setMemory(laptop.getMemory());
            oldLaptop.setOperationSystem(laptop.getOperationSystem());
            oldLaptop.setDateOfIssue(laptop.getDateOfIssue());
            entityManager.getTransaction().commit();
            entityManager.close();
            return oldLaptop;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Map<OperationSystem,List<Laptop>> map =
                     entityManager.createQuery("select l from  Laptop l ",Laptop.class).
                    getResultStream().collect(Collectors.groupingBy(Laptop::getOperationSystem));
            entityManager.getTransaction().commit();
            entityManager.close();
            return map;
        } catch (LaptopException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("Select column : (id / brand / operationSystem / memory / price / year");
            switch (column) {
                case "id" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by id ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by id desc ").getResultList();
                        }
                    }
                }
                case "brand" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by brand ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by brand desc ").getResultList();
                        }
                    }
                }
                case "operationSystem" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by operationSystem ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by operationSystem desc ").getResultList();
                        }
                    }
                }
                case "memory" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by memory ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by memory desc ").getResultList();
                        }
                    }
                }
                case "price" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by price ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by price desc ").getResultList();
                        }
                    }
                }
                case "year" -> {
                    System.out.println("Enter by command :");
                    switch (ascOrDesc) {
                        case "asc" -> {
                            return entityManager.createQuery("select l from Laptop l order by dateOfIssue ").getResultList();
                        }
                        case "desc" -> {
                            return entityManager.createQuery("select l from Laptop l order by dateOfIssue desc ").getResultList();
                        }
                    }
                }

            }
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (LaptopException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        managerFactory.close();
    }
}
