package pl.sii.streams.ch10.parallel;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.LinkedList;

public class ParallelStreamTest extends Setup {
    // parallel()
    @Test
    public void shouldProcessInParallel1() {
        shops.parallelStream().forEach(shop -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Performing a parallel operation on " + shop);
        });
    }

    @Test
    public void shouldProcessInParallel2() {
        LinkedList<Shop> aLongList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            aLongList.addAll(shops);
        }
        long startTime = System.currentTimeMillis();
        aLongList.parallelStream().forEach(shop -> {
            System.out.println(Thread.currentThread().getName());
//            System.out.println("Performing a computation on a " + shop);

        });
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Executed in " + elapsedTime);
    }
}
