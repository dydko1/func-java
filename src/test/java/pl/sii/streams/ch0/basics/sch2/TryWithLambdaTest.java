package pl.sii.streams.ch0.basics.sch2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TryWithLambdaTest {

    static class Person {
        final String name;

        public Person(String name) {
            this.name = name;
        }

        public String someRegularMethod() {
            return name;
        }

        public String someExceptionalMethod() {
            throw new RuntimeException("An exception throw within person class");
        }
    }

    @Test
    public void shouldTry() {
        Person james = new Person("James");
        Try.with(james, person -> person.someRegularMethod() + " suffix")
                .onSuccess(result -> {
                    System.out.println("Completed successfully");
                    System.out.println();
                    Assert.assertEquals(String.join("????", result.split(" ")),
                            "James????suffix");
                })
                .onException(exception -> {
                    System.out.println("Completed exceptionally");
                    Assert.assertEquals(exception.getMessage(),
                            "An exception throw within person class");
                });
    }
}
