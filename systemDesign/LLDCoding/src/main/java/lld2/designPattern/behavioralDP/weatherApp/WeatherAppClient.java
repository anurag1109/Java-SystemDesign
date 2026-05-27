package lld2.designPattern.behavioralDP.weatherApp;

/**
 * WeatherAppClient - Demonstrates Observer Pattern
 * Shows how WeatherStation (Observable) notifies all display devices
 * (Observers)
 * when weather changes
 */
public class WeatherAppClient {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("    WEATHER APP - Observer Pattern Demo");
        System.out.println("═══════════════════════════════════════════════\n");

        // Step 1: Create the Weather Station (Observable)
        WeatherStation weatherStation = new WeatherStation();
        System.out.println("✓ Weather Station created\n");

        // Step 2: Create display devices (Observers)
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();
        EmailDisplay emailDisplay = new EmailDisplay();
        System.out.println("✓ Display devices created\n");

        // Step 3: Register observers with the weather station
        System.out.println("--- REGISTERING OBSERVERS ---");
        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(tvDisplay);
        weatherStation.registerObserver(emailDisplay);

        // Step 4: Update weather and watch all observers get notified
        System.out.println("\n--- WEATHER UPDATE #1 ---");
        weatherStation.updateWeather(25.5, 65, 1013);

        // Step 5: Update weather again
        System.out.println("\n--- WEATHER UPDATE #2 ---");
        weatherStation.updateWeather(18.3, 72, 1010);

        // Step 6: Remove an observer
        System.out.println("\n--- REMOVING EMAIL DISPLAY ---");
        weatherStation.removeObserver(emailDisplay);

        // Step 7: Update weather - email will NOT be notified
        System.out.println("\n--- WEATHER UPDATE #3 ---");
        weatherStation.updateWeather(22.0, 58, 1015);

        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("✓ Demo completed successfully!");
        System.out.println("═══════════════════════════════════════════════");
    }
}
