package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {


    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        carDao.addUser(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getListCars() {
        return carDao.getListCars();
    }

    @Override
    public Car getCar(String model, int series) {
        return carDao.getCar(model, series);
    }

    @Override
    public Car getCar(long id) {
        return carDao.getCar(id);
    }
}
