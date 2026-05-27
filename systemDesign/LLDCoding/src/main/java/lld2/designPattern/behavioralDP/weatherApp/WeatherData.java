package lld2.designPattern.behavioralDP.weatherApp;

/**
 * WeatherData - Holds current weather information
 * Contains temperature, humidity and pressure readings
 */
public class WeatherData {
    private double temperature;  // in Celsius
    private double humidity;     // percentage
    private double pressure;     // in mb

    public WeatherData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    // Getters
    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature + "°C" +
                ", humidity=" + humidity + "%" +
                ", pressure=" + pressure + "mb" +
                '}';
    }
}
