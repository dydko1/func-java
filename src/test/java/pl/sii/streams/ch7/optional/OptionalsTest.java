package pl.sii.streams.ch7.optional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Item;
import pl.sii.utils.Shop;

import java.util.Optional;

public class OptionalsTest extends Setup {
    // Optional.of
    @Test
    public void shouldHaveOptionalValue() {
        Optional<Shop> someOptional = Optional.of(shops.get(0));

        if (someOptional.isPresent()) {
            Shop properValue = someOptional.get();
            System.out.println(properValue.getName());
        }

        Optional<Object> empty = Optional.empty();

        if (empty.isEmpty()) {
            System.out.println("Performing action on empty");
        }
    }
    // findFirst()
    @Test
    public void shouldFindFirst() {
        Optional<Shop> waldo = shops.stream().filter(s -> s.getName().contains("Waldo")).findFirst();
        Assert.assertTrue(waldo.isPresent());
    }
    // findAny()
    @Test
    public void shouldFindAny() {
        Optional<Shop> anyShop = shops.stream().filter(s -> s.getName().contains("l")).findAny();
        Assert.assertTrue(anyShop.isPresent());
    }
    // orElse()
    @Test
    public void shouldFindAny2() {
        Shop nullShop = shops.stream().filter(s -> s.getName().contains("Waldo null shop"))
                .findAny().orElse(Shop.nullShop());
        Assert.assertEquals(nullShop.getName(), "Empty");
    }
    // orElseGet()
    @Test
    public void shouldFindAnyOrElseGetAnother() {
        Shop waldoSuperShop = shops.stream()
                .filter(s -> s.getName().contains("Waldo"))
                .findFirst()
                .orElseGet(Shop::nullShop);
        Assert.assertNotNull(waldoSuperShop);
    }
    // orElseThrow()
    @Test(expectedExceptions = IllegalStateException.class)
    public void shouldThrowAnException() {
        shops.stream()
                .filter(s -> s.getName().contains("bad name"))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    // ifPresent()
    @Test
    public void shouldBePresent() {
        shops.stream()
                .map(Shop::getName)
                .filter(name -> name.startsWith("W"))
                .findFirst()
                .ifPresent(shopName -> {
                    Assert.assertEquals(shopName, "Waldo's Magical Stuff");
                });
    }
    // ifPresentOrElse()
    @Test
    public void shouldBePresentOrElse() {
        shops.stream()
                .filter(shops -> shops.getName().startsWith("x"))
                .findFirst()
                .ifPresentOrElse(shop -> {
                    System.out.println(shop.getName());
                }, () -> {
                    System.out.println("Running else");
                });

    }
    // map()
    @Test
    public void shouldMapToAnotherOptional() {
        Optional<Shop> waldo = shops.stream()
                .filter(shops -> shops.getName().startsWith("Wal"))
                .findFirst();

        Optional<Item> item = waldo.flatMap(waldoShop -> waldoShop.getInventory().getItemList().stream().findFirst());
        item.ifPresent(i -> System.out.println(i.getItemName()));
    }
    // or
    @Test
    public void shouldSupplyAnotherValue() {
        Optional<Shop> yShop = shops.stream()
                .filter(shop -> shop.getName().startsWith("y"))
                .findAny()
                .or(() -> shops.stream().filter(shop -> shop.getName().startsWith("Waldo")).findFirst());

        Assert.assertEquals(yShop.get().getName(), "Waldo's Magical Stuff");
    }
}
