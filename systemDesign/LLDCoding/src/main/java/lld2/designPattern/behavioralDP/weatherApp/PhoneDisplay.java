package lld2.designPattern.behavioralDP.weatherApp;

/**
 * PhoneDisplay - Concrete Observer
 * Displays weather information on mobile phone
 * Gets notified whenever weather changes
 */
public class PhoneDisplay implements WeatherObserver {

    @Override
    public void update(WeatherData weatherData) {
        System.out.println("📱 PHONE DISPLAY: ");
        System.out.println("   Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("   Humidity: " + weatherData.getHumidity() + "%");
    }
}
