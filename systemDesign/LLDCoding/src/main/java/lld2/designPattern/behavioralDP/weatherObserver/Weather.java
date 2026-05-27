package lld2.designPattern.behavioralDP.weatherObserver;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Weather {

    private double temperature;
    private double humidity;
    private double pressure;
    private List<Observer> observers;

    public Weather(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer registered for weather updates");
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer unregistered from weather updates");
    }

    public void notifyObservers() {
        System.out.println("\n Notifying " + observers.size() + " observers about weather update...");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void updateWeather(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

}
