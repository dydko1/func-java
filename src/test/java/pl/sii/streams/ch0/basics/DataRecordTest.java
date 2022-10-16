package pl.sii.streams.ch0.basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.sii.streams.DataRecord;
import pl.sii.streams.Setup2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataRecordTest extends Setup2 {
    @Test
    public void shouldFilterDataset() {
        HashMap<String, List<DataRecord>> resultMap = new HashMap<>();
        for (DataRecord testDatum : testData) {
            if (resultMap.containsKey(testDatum.getGroup())) {
                resultMap.get(testDatum.getGroup()).add(testDatum);
            } else {
                ArrayList<DataRecord> dataRecords = new ArrayList<>();
                dataRecords.add(testDatum);
                resultMap.put(testDatum.getGroup(), dataRecords);
            }
        }

        Map<String, List<DataRecord>> groupedByGroup = testData.stream()
                .collect(Collectors.groupingBy(DataRecord::getGroup));
        System.out.println();


        Map<String, List<DataRecord>> groupedBySubGroup = testData.stream()
                .collect(Collectors.groupingBy(DataRecord::getSubgroup));
        Map<String, List<DataRecord>> groupedByIndicator = testData.stream()
                .collect(Collectors.groupingBy(DataRecord::getIndicator));
        Map<Boolean, List<DataRecord>> female = testData.stream()
                .collect(Collectors.partitioningBy(dr -> dr.getSubgroup().equals("Female")));
        System.out.println();

        List<DataRecord> percent = testData.stream().filter(dr -> dr.getPercent() > 0.5).collect(Collectors.toList());
        percent.forEach(System.out::println);

        List<String> nonUnique = testData.stream().map(DataRecord::getRound).collect(Collectors.toList());
        System.out.println(nonUnique);
        Set<String> onlyUnique = testData.stream().map(DataRecord::getRound).collect(Collectors.toSet());
        System.out.println(onlyUnique);

        String joined = testData.stream().map(DataRecord::getGroup).collect(Collectors.joining("-"));
        System.out.println(joined);
    }

    @DataProvider
    public static Object[][] provideFunctions() {
        return new Object[][]{
                new Object[]{(Function<DataRecord, String>) DataRecord::getSubgroup},
                new Object[]{(Function<DataRecord, String>) DataRecord::getGroup}
        };
    }

    @Test(dataProvider = "provideFunctions")
    public void shouldExecuteParametrizedFunctions(Function<DataRecord, String> func) {

    }
}
