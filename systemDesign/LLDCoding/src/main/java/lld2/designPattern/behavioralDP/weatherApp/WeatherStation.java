package lld2.designPattern.behavioralDP.weatherApp;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherStation - The Observable/Subject
 * Maintains a list of observer (display devices)
 * Notifies all observers when weather data changes
 * 
 * This is the central entity that manages all display devices
 * and pushes weather updates to them
 */
public class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private WeatherData currentWeather;

    /**
     * Register a display device to receive weather updates
     */
    public void registerObserver(WeatherObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("✓ " + observer.getClass().getSimpleName() + " registered for weather updates");
        }
    }

    /**
     * Unregister a display device from weather updates
     */
    public void removeObserver(WeatherObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("✓ " + observer.getClass().getSimpleName() + " unregistered from weather updates");
        }
    }

    /**
     * Notify all registered observers about weather changes
     */
    private void notifyObservers() {
        System.out.println("\n📢 Notifying all observers about weather change...");
        for (WeatherObserver observer : observers) {
            observer.update(currentWeather);
        }
    }

    /**
     * Update weather data and notify all observers
     */
    public void updateWeather(double temperature, double humidity, double pressure) {
        System.out.println("\n🌡️ Weather Station: Weather data updated!");
        this.currentWeather = new WeatherData(temperature, humidity, pressure);
        notifyObservers();
    }

    /**
     * Get current weather data
     */
    public WeatherData getCurrentWeather() {
        return currentWeather;
    }

    /**
     * Get number of observers currently registered
     */
    public int getObserverCount() {
        return observers.size();
    }
}
