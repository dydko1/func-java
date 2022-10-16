package pl.sii.streams.ch0.basics.sch2;

import org.testng.Assert;
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
    public void shouldGroupDataset() {
        // Group dataset based on some condition
        HashMap<String, List<DataRecord>> groupedMap1 = new HashMap<>();
        for (DataRecord testDatum : testData) {
            if (groupedMap1.containsKey(testDatum.getGroup())) {
                groupedMap1.get(testDatum.getGroup()).add(testDatum);
            } else {
                ArrayList<DataRecord> dataRecords = new ArrayList<>();
                dataRecords.add(testDatum);
                groupedMap1.put(testDatum.getGroup(), dataRecords);
            }
        }

        // Group data set using streams
        Map<String, List<DataRecord>> groupedMap2 = testData.stream()
                .collect(Collectors.groupingBy(DataRecord::getGroup));

        groupedMap1.keySet().forEach(key -> Assert.assertEquals(groupedMap1.get(key), groupedMap2.get(key)));

        System.out.println(groupedMap1.keySet());
        System.out.println(groupedMap2.keySet());
    }

    @Test
    public void shouldPartitionDataset() {
        String SUBGROUP_NAME = "Education";

        Map<Boolean, List<DataRecord>> partitionedBySubgroup1 = new HashMap<>();
        partitionedBySubgroup1.put(true, new ArrayList<>());
        partitionedBySubgroup1.put(false, new ArrayList<>());
        for (DataRecord testDatum : testData) {
            if (testDatum.getSubgroup().equals(SUBGROUP_NAME)) {
                partitionedBySubgroup1.get(true).add(testDatum);
            } else {
                partitionedBySubgroup1.get(false).add(testDatum);
            }
        }

        Map<Boolean, List<DataRecord>> partitionedBySubgroup2 = testData.stream()
                .collect(Collectors.partitioningBy(dr -> dr.getSubgroup().equals(SUBGROUP_NAME)));

        Assert.assertEquals(partitionedBySubgroup1.get(true), partitionedBySubgroup2.get(true));
    }

    @Test
    public void shouldFilterDataset() {
        List<DataRecord> filteredList1 = new ArrayList<>();
        for (DataRecord testDatum : testData) {
            if (testDatum.getPercent() > 0.5) {
                filteredList1.add(testDatum);
            }
        }

        List<DataRecord> filteredList2 = testData.stream()
                .filter(dr -> dr.getPercent() > 0.5).collect(Collectors.toList());

        Assert.assertEquals(filteredList1, filteredList2);
    }

    @DataProvider
    public static Object[][] provideFunctions() {
        return new Object[][]{
                new Object[]{(Function<DataRecord, String>) DataRecord::getGroup},
                new Object[]{(Function<DataRecord, String>) DataRecord::getSubgroup}
        };
    }

    @Test(dataProvider = "provideFunctions")
    public void shouldExecuteParametrizedFunctions(Function<DataRecord, String> func) {
        Set<String> collect = testData.stream().map(func).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
