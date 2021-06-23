//1. Цепочка ответственности

interface Payment {
    void setNext(Payment payment);
    void pay();
}
class VisaPayment implements Payment {
    private Payment payment;
    public void setNext(Payment payment) {
        this.payment = payment;
    }
    public void pay() {
        System.out.println("Visa Payment");
    }
}
class PayPalPayment implements Payment {
    private Payment payment;
    public void setNext(Payment payment) {
        this.payment = payment;
    }
    public void pay() {
        System.out.println("PayPal Payment");
    }
}

public class ChainofResponsibilityTest {//тест
    public static void main(String[] args) {
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext(payPalPayment);
        visaPayment.pay();
    }
}

//2. Command // Команда


interface Command {
    void execute();
}
class Car {
    public void startEngine() {
        System.out.println("запустить двигатель");
    }
    public void stopEngine() {
        System.out.println("остановить двигатель");
    }
}
class StartCar implements Command {
    Car car;
    public StartCar(Car car) {
        this.car = car;
    }
    public void execute() {
        car.startEngine();
    }
}
class StopCar implements Command {
    Car car;
    public StopCar(Car car) {
        this.car = car;
    }
    public void execute() {
        car.stopEngine();
    }
}
class CarInvoker {
    public Command command;
    public CarInvoker(Command command){
        this.command = command;
    }
    public void execute(){
        this.command.execute();
    }
}

public class CommandTest {
    public static void main(String[] args) {
        Car car = new Car();
        StartCar startCar = new StartCar(car);
        StopCar stopCar = new StopCar(car);
        CarInvoker carInvoker = new CarInvoker(startCar);
        carInvoker.execute();
    }
}

//3. Mediator // Посредник
class Mediator {
    public static void sendMessage(User user, String msg){
        System.out.println(user.getName() + ": " + msg);
    }
}
class User {
    private String name;
    public User(String name){
        this.name  = name;
    }
    public String getName() {
        return name;
    }
    public void sendMessage(String msg){
        Mediator.sendMessage(this, msg);
    }
}

public class MediatorTest {//тест
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        user1.sendMessage("message1");
        user2.sendMessage("message2");
    }
}
