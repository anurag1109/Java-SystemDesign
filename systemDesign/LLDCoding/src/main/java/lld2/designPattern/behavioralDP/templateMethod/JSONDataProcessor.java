package lld2.designPattern.behavioralDP.templateMethod;

/**
 * Concrete implementation 2: JSON Data Processor
 * Transforms data by adding JSON structure
 */
public class JSONDataProcessor extends DataProcessor {

    @Override
    protected String transformData(String data) {
        System.out.println("[JSON] Adding JSON structure...");
        return "{\"data\": \"" + data + "\"}";
    }
}
