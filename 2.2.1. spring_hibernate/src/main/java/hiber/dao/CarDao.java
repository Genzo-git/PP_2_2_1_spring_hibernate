package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void addUser(Car car);

    List<Car> getListCars();

    //
    Car getCar(String model, int series);

    Car getCar(long id);
}