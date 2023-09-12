package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> getListCars();

    Car getCar(String model, int series);

    Car getCar(long id);
}
