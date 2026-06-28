package lld2.designPattern.behavioralDP.templateMethod;

/**
 * Concrete implementation 1: CSV Data Processor
 * Transforms data by converting to uppercase
 */
public class CSVDataProcessor extends DataProcessor {

    @Override
    protected String transformData(String data) {
        System.out.println("[CSV] Converting to uppercase...");
        return data.toUpperCase();
    }
}
