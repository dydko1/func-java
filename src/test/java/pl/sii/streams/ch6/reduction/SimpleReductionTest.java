package pl.sii.streams.ch6.reduction;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleReductionTest extends Setup {
    // max()
    // min()
    @Test
    public void shouldReturnMaxValue() {
        List<Integer> intList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
        Integer max = intList.stream().max(Comparator.naturalOrder()).get();
        Integer min = intList.stream().min(Comparator.naturalOrder()).get();
        Assert.assertEquals(max, 9);
        Assert.assertEquals(min, 1);
    }
    // anyMatch()
    @Test
    public void anyElementShouldMatch() {
        List<Integer> someNumbers = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        boolean result = someNumbers.stream().anyMatch(n -> n < 5);
        Assert.assertTrue(result);
    }
    // allMatch()
    @Test
    public void allElementsShouldMatch() {
        List<Integer> evenNumbers = Stream.of(2, 4, 6).collect(Collectors.toList());
        boolean result = evenNumbers.stream().allMatch(n -> n % 2 == 0);
        Assert.assertTrue(result);
    }
    // noneMatch()
    @Test
    public void noneShouldMatch() {
        List<Integer> someNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());
        boolean result = someNumbers.stream().noneMatch(n -> n > 7);
        Assert.assertTrue(result);
    }
}
