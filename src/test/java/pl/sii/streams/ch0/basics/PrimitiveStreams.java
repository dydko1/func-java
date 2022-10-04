package pl.sii.streams.ch0.basics;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams extends Setup {
    @Test
    public void shouldIterateOverPrimitives() {
        IntStream.range(0, 10).forEach(System.out::println);
        DoubleStream.of(1.0, 2.0, 3.0).boxed().forEach(System.out::println);
        LongStream.of(1L, 2L, 1000L).boxed().forEach(System.out::println);
    }
}
