package pl.sii.streams.ch9.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.DataRecord;
import pl.sii.streams.Setup;
import pl.sii.streams.Setup2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByTest extends Setup2 {
    // groupingBy()
    @Test
    public void shouldGroupParticipantsByGroup() {
        Map<String, List<DataRecord>> groupedByGroup = testData.stream()
                .collect(Collectors.groupingBy(DataRecord::getGroup));
        groupedByGroup.keySet().forEach(System.out::println);
    }
    // partitioningBy()
    @Test
    public void shouldPartitionBySex() {
        Map<Boolean, List<DataRecord>> partitionedDataSet = testData.stream()
                .collect(Collectors.partitioningBy(dr -> dr.getSubgroup().equals("Female")));
        String group1 = partitionedDataSet.get(true).stream().map(DataRecord::getSubgroup).findAny().get();
        Assert.assertEquals(group1, "Female");
        Set<String> otherGroups = partitionedDataSet.get(false).stream().map(DataRecord::getSubgroup).collect(Collectors.toSet());
        Assert.assertTrue(otherGroups.contains("Male"));
    }
    // counting()
    // summing()
    // maxBy() minBy()

}
