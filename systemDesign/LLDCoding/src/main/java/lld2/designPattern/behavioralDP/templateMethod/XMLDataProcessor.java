package lld2.designPattern.behavioralDP.templateMethod;

/**
 * Concrete implementation 3: XML Data Processor
 * Transforms data by wrapping in XML tags
 */
public class XMLDataProcessor extends DataProcessor {

    @Override
    protected String transformData(String data) {
        System.out.println("[XML] Wrapping in XML tags...");
        return "<root>" + data + "</root>";
    }
}
