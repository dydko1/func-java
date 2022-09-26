package pl.sii.streams.filter;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Customer;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringTest extends Setup {

    @Test
    public void emporiumShouldBePresent() {
        // Consider
        ArrayList<String> shopNames1 = new ArrayList<>();
        for (Shop s : shops) {
            if (s.getName().contains("Emporium")) {
                shopNames1.add(s.getName());
            }
        }
        Assert.assertEquals(shopNames1.size(), 1);

        // vs
        List<Shop> shopNames2 = shops.stream().filter(shop -> shop.getName().contains("Emporium"))
                .collect(Collectors.toList());
        Assert.assertEquals(shopNames2.size(), 1);
    }

    @DataProvider
    public static Object[][] customerPredicateProvider() {
        return new Object[][] {
                {(Predicate<Customer>) s -> s.getName().startsWith("Adam"), "Adam Blobber"},
                {(Predicate<Customer>) s -> s.getName().startsWith("John"), "John Doe"}
        };
    }

    @Test(dataProvider = "customerPredicateProvider")
    public void clientsShouldExist(Predicate<Customer> customerFilter, String expectedName) {
        shops.stream()
                .flatMap(shop -> shop.getOrderList().stream().map(Order::getCustomer))
                .filter(customerFilter)
                .findAny()
                .ifPresentOrElse(
                        customer -> Assert.assertEquals(customer.getName(), expectedName),
                        () -> Assert.fail("No customer present"));

    }
}
