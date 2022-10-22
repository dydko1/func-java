package pl.sii.streams.ch11.coolStuff;

import org.testng.annotations.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CoolStuffTest {
    /**
     * CompletionStage
     * EclipseCollections
     */
    @Test
    public void testCompetionStage() {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Test";
        });
        try {
            stringCompletableFuture.thenRun(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println("running another task");
            });
            String s = stringCompletableFuture.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
