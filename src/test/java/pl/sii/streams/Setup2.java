package pl.sii.streams;

import org.apache.commons.csv.CSVFormat;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Setup2 {
    /**
    Context:
     src: https://data.gov/
     Data set contains info from a survey about the percentage of adults who delayed medical care in the last 4 weeks
     or who needed medical care at any time in the last 4 weeks for something other than coronavirus but did not
     get it because of the pandemic.
     */
    protected static List<DataRecord> testData;
    private static final String[] fileHeaders = {
            "Round",
            "Indicator",
            "Group",
            "Subgroup",
            "Sample Size",
            "Response",
            "Percent",
            "Standard Error",
            "Suppression",
            "Significant 1",
            "Significant 2"
    };


    @BeforeSuite
    public void setupDataRecords() throws IOException {
        Reader in = new FileReader(Paths.get("src", "test", "resources", "Reduced_Access_to_Care_During_COVID-19.csv")
                .toAbsolutePath().toString());
        CSVFormat format = CSVFormat.Builder.create().setSkipHeaderRecord(true).setHeader(fileHeaders).setDelimiter(',').build();
        testData = format.parse(in).stream().map(csvRecord -> new DataRecord(
                csvRecord.get("Round"),
                csvRecord.get("Indicator"),
                csvRecord.get("Group"),
                csvRecord.get("Subgroup"),
                parseLong(csvRecord.get("Sample Size")),
                csvRecord.get("Response"),
                parseDouble(csvRecord.get("Percent")),
                parseDouble(csvRecord.get("Standard Error")),
                parseDouble(csvRecord.get("Suppression")),
                parseDouble(csvRecord.get("Significant 1")),
                parseDouble(csvRecord.get("Significant 2"))
        )).collect(Collectors.toList());
    }

    private long parseLong(String s) {
        return s.isEmpty() ? 0L : Long.parseLong(s);
    }

    private double parseDouble(String s) {
        return s.isEmpty() || s.equals("*") ? 0.0 : Double.parseDouble(s);
    }
}
