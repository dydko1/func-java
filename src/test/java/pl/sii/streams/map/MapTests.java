package pl.sii.streams.map;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapTests extends Setup {
    @Test
    public void shopsShouldHaveNames() {
        // Consider
        List<String> shopNames1 = new ArrayList<>();
        for (Shop s : shops) {
            shopNames1.add(s.getName());
        }
        Assert.assertFalse(shopNames1.isEmpty());

        // vs
        List<String> shopNames2 = shops.stream().map(s -> s.getName()).collect(Collectors.toList());
        Assert.assertFalse(shopNames2.isEmpty());
    }


}
