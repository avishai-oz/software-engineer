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
        configuration.addAnnotatedClass(Image.class);
        configuration.addAnnotatedClass(Garage.class);
        configuration.addAnnotatedClass(JunctionTable_Car_Garage.class);
        configuration.addAnnotatedClass(JunctionTable_Garage_Owner.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void generateOwners() throws Exception {
        Owner owner1 = new Owner("Avish", "Oz", "Avishayoz04!", "avishay.king@ukraine.org");
        Owner owner2 = new Owner("Omer", "Escobar", "OmerIsGool!", "gamma.getter@ukraine.org");
        Owner owner3 = new Owner("Leon", "Gurin", "ilcyber", "longhire@probems.solved");
        Owner owner4 = new Owner("Yonatan", "Astrachen", "lilmenash", "motorolaGP@walla.il");
        Owner owner5 = new Owner("Ido", "Bluespan", "123321", "sameship@different.day");
        Owner owner6 = new Owner("Noam", "Levin", "freeamongus", "climbs@love.il");
        Owner owner7 = new Owner("Alona", "Songs", "spoty", "spotyiphone@noakila");
        Owner owner8 = new Owner("Nir", "Nor", "what?", "just@saying");
        session.save(owner1);
        session.save(owner2);
        session.save(owner3);
        session.save(owner4);
        session.save(owner5);
        session.save(owner6);
        session.save(owner7);
        session.save(owner8);
        session.flush();
    }

    private static void generateCars() throws Exception {
        Random random = new Random();
        List<Owner> owners = getAllOwners();
        for (int i = 0; i < 8; i++) {
            Car car = new Car("MOO-" + random.nextInt(), 100000, 2000 + random.nextInt(19) , owners.get(i).getId(), -1);
            session.save(car);
            session.flush();
        }
    }

    private static void generateImages() throws Exception {
        List<Car> cars = getAllCars();
        for (int i = 0; i < 8; i++) {
            Image image = new Image("file://C:/Users/User/pics/image" + i + ".png" ,(cars.get(i)).getId());
            cars.get(i).setImage(image.getId());
            session.save(image);
            session.flush();
        }
    }

    private static void generateGarages() throws Exception {
        Garage garage1 = new Garage("the kia brothers", 539291512 , "Avishayoz04!");
        Garage garage2 = new Garage("the mazda brothers", 796783244 , "Leon");
        session.save(garage1);
        session.save(garage2);
        session.flush();
    }

    private static void generateJunctionTable_Car_Garage() throws Exception {
        List<Car> cars = getAllCars();
        List<Garage> garages = getAllGarages();
        int len = garages.size();

        for (int i = 0; i < 8; i++) {
            JunctionTable_Car_Garage junctionTable_car_garage = new JunctionTable_Car_Garage(garages.get(i % len).getId(),cars.get(i).getId());
            session.save(junctionTable_car_garage);
            session.flush();
        }
    }
    private static void generateJunctionTable_Garage_Owner() throws Exception {
        List<Owner> owners = getAllOwners();
        List<Garage> garages = getAllGarages();
        int len = garages.size();
        for (int i = 0; i < 8; i++) {
            JunctionTable_Garage_Owner junctionTable_garage_owner = new JunctionTable_Garage_Owner(garages.get(i % len).getId(), owners.get(i).getId());
            session.save(junctionTable_garage_owner);
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

    private static List<Image> getAllImages() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Image> query = builder.createQuery(Image.class);
        query.from(Image.class);
        List<Image> data = session.createQuery(query).getResultList();
        return data;
    }

    private static List<Garage> getAllGarages() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Garage> query = builder.createQuery(Garage.class);
        query.from(Garage.class);
        List<Garage> data = session.createQuery(query).getResultList();
        return data;
    }

    private static List<JunctionTable_Car_Garage> getAllCarOwner() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<JunctionTable_Car_Garage> query = builder.createQuery(JunctionTable_Car_Garage.class);
        query.from(JunctionTable_Car_Garage.class);
        List<JunctionTable_Car_Garage> data = session.createQuery(query).getResultList();
        return data;
    }

    private static List<JunctionTable_Garage_Owner> getAllGarageOwner() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<JunctionTable_Garage_Owner> query = builder.createQuery(JunctionTable_Garage_Owner.class);
        query.from(JunctionTable_Garage_Owner.class);
        List<JunctionTable_Garage_Owner> data = session.createQuery(query).getResultList();
        return data;
    }

    private static void printAllData() throws Exception {
        List<Garage> garages = getAllGarages();
        List<Car> cars = getAllCars();
        List<Owner> owners = getAllOwners();
        List<JunctionTable_Garage_Owner> junctionTableGarageOwners = getAllGarageOwner();
        List<JunctionTable_Car_Garage> junctionTableCarGarages = getAllCarOwner();

        for (Garage garage : garages) {
            System.out.print("Garage data - Id: ");
            System.out.print(garage.getId());
            System.out.print(", Manager: ");
            System.out.print(garage.getManager());
            System.out.print(", Phone Number: ");
            System.out.print(garage.getPhone_number());
            System.out.print(", Address: ");
            System.out.println(garage.getAddress());
            System.out.print("Car Licences in garage: ");
            for ( JunctionTable_Car_Garage junctionTable_car_garage : junctionTableCarGarages) {
                if (junctionTable_car_garage.getGarageId() == garage.getId()){
                    Car car = cars.get(junctionTable_car_garage.getCarId()-1);
                    System.out.print(car.getLicensePlate() + ", ");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        for (Car car : cars) {
            System.out.print("Car data - Id: ");
            System.out.print(car.getId());
            System.out.print(", License plate: ");
            System.out.print(car.getLicensePlate());
            System.out.print(", Price: ");
            System.out.print(car.getPrice());
            System.out.print(", Year: ");
            System.out.print(car.getYear());
            System.out.print(", Owner ID: ");
            System.out.print(car.getOwner());
            Owner owner = owners.get(car.getOwner() - 1);
            System.out.print(", First Name: ");
            System.out.print(owner.getOwnerFirstName());
            System.out.print(", Last Name: ");
            System.out.print(owner.getOwnerLastName());
            System.out.print(", Password: ");
            System.out.print(owner.getPassword());
            System.out.print(", Email: ");
            System.out.println(owner.getEmail());
            System.out.print("Licenced in the following garages: ");
            for ( JunctionTable_Car_Garage junctionTable_car_garage : junctionTableCarGarages) {
                if (junctionTable_car_garage.getCarId() == car.getId()){
                    Garage garage = garages.get(junctionTable_car_garage.getGarageId() - 1);
                    System.out.print(garage.getAddress() + ", ");
                }
            }
            System.out.print("\n");
        }
    }

    private static void genData() throws Exception{
        generateGarages();
        generateOwners();
        generateCars();
        generateImages();
        generateJunctionTable_Car_Garage();
        generateJunctionTable_Garage_Owner();
    }

    public static void main( String[] args ) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            genData();
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