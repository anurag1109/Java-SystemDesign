package lld2.designPattern.behavioralDP.weatherObserver;

public class Client {

    public static void main(String[] args) {
        Observer customer1 = new Customer("Alice");
        Observer customer2 = new Customer("Bob");

        Weather weatherStation = new Weather(20.0, 65.0, 1013.0);
        weatherStation.registerObserver(customer1);
        weatherStation.registerObserver(customer2);

        weatherStation.updateWeather(45, 65, 1002);

    }

}
