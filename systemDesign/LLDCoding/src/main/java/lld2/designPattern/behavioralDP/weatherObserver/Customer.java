package lld2.designPattern.behavioralDP.weatherObserver;

public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Weather weather) {
        updateWeather(weather);
    }

    public void updateWeather(Weather weather) {
        System.out.println("Customer " + name + " received weather update: " + weather.getTemperature());
    }

}
