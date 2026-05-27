package lld2.designPattern.behavioralDP.weatherApp;

/**
 * TVDisplay - Concrete Observer
 * Displays weather information on TV screen
 * Gets notified whenever weather changes
 */
public class TVDisplay implements WeatherObserver {

    @Override
    public void update(WeatherData weatherData) {
        System.out.println("📺 TV DISPLAY: ");
        System.out.println("   🌡️ Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("   💨 Humidity: " + weatherData.getHumidity() + "%");
        System.out.println("   🔽 Pressure: " + weatherData.getPressure() + "mb");
    }
}
