package lld2.designPattern.behavioralDP.weatherApp;

/**
 * EmailDisplay - Concrete Observer
 * Sends weather information via email notification
 * Gets notified whenever weather changes
 */
public class EmailDisplay implements WeatherObserver {

    @Override
    public void update(WeatherData weatherData) {
        System.out.println("📧 EMAIL NOTIFICATION: ");
        System.out.println("   Dear User,");
        System.out.println("   Here is the latest weather update:");
        System.out.println("   - Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("   - Humidity: " + weatherData.getHumidity() + "%");
        System.out.println("   - Pressure: " + weatherData.getPressure() + "mb");
        System.out.println("   Have a great day!");
    }
}
