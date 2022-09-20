package pl.sii.streams;

import org.testng.annotations.BeforeClass;
import pl.sii.utils.DataGenerator;
import pl.sii.utils.Shop;

import java.util.List;

public abstract class Setup {
    protected List<Shop> shops;

    @BeforeClass
    public void setup() {
        shops = DataGenerator.generateNewListOfShops();
    }
}
