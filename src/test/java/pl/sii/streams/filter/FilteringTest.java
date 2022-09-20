package pl.sii.streams.filter;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
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
}
