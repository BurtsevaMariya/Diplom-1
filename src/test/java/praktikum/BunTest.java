package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    String name = "black bun";
    float price = 100;

    @Test
    public void checkingNameBun(){
        Bun bun = new Bun(name, price);
        String expected = "black bun";
        String actual = bun.getName();
        assertEquals("Ожидаемый результат, название булочки: " + expected + ". Фактический результат, название булочки: " + actual, expected, actual);
    }

    @Test
    public void checkingPriceBun(){
        Bun bun = new Bun(name, price);
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        assertEquals("Ожидаемый результат, цена булочки: " + expectedPrice + ". Фактический результат, цена булочки: " + actualPrice, expectedPrice, actualPrice, 0);
    }
}
