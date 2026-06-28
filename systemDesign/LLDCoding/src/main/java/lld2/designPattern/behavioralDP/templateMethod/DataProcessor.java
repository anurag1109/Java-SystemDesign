package lld2.designPattern.behavioralDP.templateMethod;

/**
 * Abstract Template Class
 * Defines the skeleton of an algorithm. Subclasses fill in the details.
 */
public abstract class DataProcessor {

    /**
     * Template method - this is the skeleton that won't change
     * It defines the algorithm structure
     */
    public final void processData(String data) {
        // Step 1: Read data
        String rawData = readData(data);

        // Step 2: Parse data
        String parsedData = parseData(rawData);

        // Step 3: Process data
        String processedData = transformData(parsedData);

        // Step 4: Save data
        saveData(processedData);
    }

    // Concrete steps that all subclasses will perform
    private String readData(String data) {
        System.out.println("[Common] Reading data: " + data);
        return data;
    }

    private String parseData(String data) {
        System.out.println("[Common] Parsing data...");
        return data.trim();
    }

    private void saveData(String data) {
        System.out.println("[Common] Saving processed data: " + data);
    }

    // Abstract methods - to be implemented by subclasses
    /**
     * Each subclass decides how to transform the data
     */
    protected abstract String transformData(String data);
}
