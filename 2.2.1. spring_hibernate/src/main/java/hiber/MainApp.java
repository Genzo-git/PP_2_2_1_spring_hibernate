package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("Model1", 1);
        Car car2 = new Car("Model2", 2);
        Car car3 = new Car("Model3", 3);
        Car car4 = new Car("Model4", 4);

        // сохранить всё в БД
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);
        System.out.println("tyt0 создали и сохранили в БД юзеров и машины");

        // получить или достать из бд
        List<User> users = userService.getListUsers();
        List<Car> cars = carService.getListCars();
        System.out.println(users.toString());
        System.out.println(cars.toString());

        System.out.println("tyt1 достали из БД юзеров и машины");
        // раздать или связать польз и авто

//        Car carFromBbId1 = carService.getCar(1);
//
//        user1.setCar(carFromBbId1);
//        userService.addUser(user1);
//        System.out.println("user 1 added car");
//        System.out.println(user1.toString());
//        user1.setCar(carService.getCar(1));
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        //???? почему тут после добавления машин пользователям у пользователя машины нулл
        System.out.println(users.toString());
        System.out.println("tyt2 юзерам должны были добавиться машины");
        // Нужно отдельно создать юзеров и машины, сохранить их в бд, затем получить из бд и раздать машины пользователям
        // надо создать отдельно и потом достать и связать

        // List<User> users = userService.getListUsers();


        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println("tyt3");
            // До сюда выполняется код
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("tyt4");
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.getUserCar("Model4", 4));

        context.close();
    }
}
