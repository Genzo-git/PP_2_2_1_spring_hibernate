package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getListCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public Car getCar(String model, int series) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().
                createQuery("FROM Car WHERE series = :series AND model = :model");
        query.setParameter("series", series);
        query.setParameter("model", model);
        return query.getSingleResult();
    }

    @Override
    public Car getCar(long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }
}
