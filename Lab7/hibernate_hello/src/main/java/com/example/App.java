package com.example;

import java.util.List;
import java.util.Random;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class App
{
    private static Session session;

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        // Add ALL of your entities here. You can also try adding a whole package.
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Owner.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void generateOwners() throws Exception {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Owner owner = new Owner();
            session.save(owner);
            session.flush();
        }
    }
    private static void generateCars() throws Exception {
        Random random = new Random();
        List<Owner> owners = getAllOwners();
        for (int i = 0; i < 10; i++) {
            Car car = new Car("MOO-" + random.nextInt(), 100000, 2000 + random.nextInt(19) , (owners.get(i)).getOwnerFirstName() );
            session.save(car);
            session.flush();
        }
    }

    private static List<Car> getAllCars() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        query.from(Car.class);
        List<Car> data = session.createQuery(query).getResultList();
        return data;
    }
    private static List<Owner> getAllOwners() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Owner> query = builder.createQuery(Owner.class);
        query.from(Owner.class);
        List<Owner> data = session.createQuery(query).getResultList();
        return data;
    }

    private static void printAllData() throws Exception {
        List<Car> cars = getAllCars();
        for (Car car : cars) {
            System.out.print("Id: ");
            System.out.print(car.getId());
            System.out.print(", License plate: ");
            System.out.print(car.getLicensePlate());
            System.out.print(", Price: ");
            System.out.print(car.getPrice());
            System.out.print(", Year: ");
            System.out.print(car.getYear());
            System.out.print('\n');
        }

        List<Owner> owners = getAllOwners();
        for (Owner owner : owners ){
            System.out.print("Id: ");
            System.out.print(owner.getId());
            System.out.print(", First Name: ");
            System.out.print(owner.getOwnerFirstName());
            System.out.print(", Last Name: ");
            System.out.print(owner.getOwnerLastName());
            System.out.print(", Email: ");
            System.out.print(owner.getEmail());
            System.out.print(", Password: ");
            System.out.print(owner.getPassword());
            System.out.print(", Number of cars: ");
            System.out.print(owner.getNumberOfCars());
            System.out.print('\n');
        }
    }

    public static void main( String[] args ) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            generateCars();
            generateOwners();

            printAllData();

            session.getTransaction().commit(); // Save everything.

        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occured, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            session.close();
        }
    }
}