package pl.sii.streams.ch7.optional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.Optional;

public class OptionalsTest extends Setup {
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
    // ifPresentOrElse()
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
}
