package lld2.designPattern.behavioralDP.weatherApp;

/**
 * WeatherObserver Interface
 * Defines the contract that all display devices must implement
 * to be notified of weather changes
 */
public interface WeatherObserver {
    /**
     * Called when weather data is updated
     * 
     * @param weatherData - The updated weather information
     */
    void update(WeatherData weatherData);
}
