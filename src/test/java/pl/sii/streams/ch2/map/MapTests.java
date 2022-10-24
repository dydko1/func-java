package pl.sii.streams.ch2.map;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.Collection;
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
        List<String> shopNames2 = shops.stream().map(s -> s.getName())
                .collect(Collectors.toList());
        Assert.assertFalse(shopNames2.isEmpty());
    }

    @Test
    public void shouldAppendToString() {
        List<String> l = List.of("one", "two", "three");

        // Consider
        ArrayList<String> result = new ArrayList<>();
        for (String s : l) {
            String appended = s + "_suffix";
            result.add(appended);
        }
        for (String s : result) {
            System.out.println(s);
        }

        // vs
        l.stream().map(string -> string + "_suffix").collect(Collectors.toList()).forEach(x -> System.out.println(x));
    }

    @Test
    public void shouldIterateOverAList() {
        List<String> l1 = List.of("one", "two", "three");
        List<List<String>> l2 = List.of(l1);
        List<List<List<String>>> l3 = List.of(l2);

        for (List<List<String>> l : l3) {
            if (l.size() > 0) {
                for (List<String> innerL : l) {
                    if (!innerL.isEmpty()) {
                        for (String s : innerL) {
                            System.out.println(s);
                        }
                    }
                }
            }
        }

        l3.stream()
                .filter(lists -> lists.size() > 0)
                .flatMap(Collection::stream)
                .filter(list -> !list.isEmpty())
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

}
