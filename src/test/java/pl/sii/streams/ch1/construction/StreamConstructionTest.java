package pl.sii.streams.ch1.construction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConstructionTest {
    @Test
    public void shouldCreateStream() {
        List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        Assert.assertEquals(collect, List.of(1, 2, 3, 4));
    }

    @Test
    public void shouldCreateFromCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();
        Assert.assertNotNull(stream);
    }

    @Test
    public void shouldCreateStreamFromArray() {
        int[] arrOfNumbers = new int[] {4, 5, 6};
        List<Integer> listOfInts = Arrays.stream(arrOfNumbers, 0, arrOfNumbers.length)
                .boxed()
                .collect(Collectors.toList());
        Assert.assertEquals(listOfInts, List.of(4, 5, 6));
    }

    @Test
    public void shouldCreateInfiniteStream() {
        Stream<String> infinite = Stream.generate(() -> "echo");
        // Stream.generate(() -> "echo").forEach(System.out::println);
        // or
        // Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).forEach(System.out::println);
        Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).limit(200).forEach(System.out::println);
    }

    @Test
    public void shouldPeekStream() {
        List<BigDecimal> decimals = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).limit(50).peek(bd -> {
            if (bd.equals(BigDecimal.TEN)) {
                System.out.println("==PEEKING==");
                System.out.println(bd);
            }
        }).collect(Collectors.toList());
        Assert.assertEquals(decimals.size(), 50);
    }
}
