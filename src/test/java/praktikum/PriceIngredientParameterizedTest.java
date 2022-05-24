package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class PriceIngredientParameterizedTest {
    private final Object type;
    private final String name;
    private final float price;
    private final float expectedPriceIngredient;

    public PriceIngredientParameterizedTest(Object type, String name, float price, float expectedPriceIngredient) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedPriceIngredient = expectedPriceIngredient;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){
        return new Object[][]{
                {SAUCE, "hot sauce", 100, 100},
                {SAUCE, "sour cream", 200, 200},
                {SAUCE, "chili sauce", 300, 300},

                {FILLING, "cutlet", 100, 100},
                {FILLING, "dinosaur", 200, 200},
                {FILLING, "sausage", 300, 300},
        };
    }

    @Test
    public void checkingGetIngredientPrice(){
        Ingredient ingredient = new Ingredient((IngredientType) type, name,price);
        float actualIngredientPrice = ingredient.getPrice();

        assertEquals("Ожидаемый результат, цена: " + expectedPriceIngredient + ". Фактический результат, цена: " + actualIngredientPrice, expectedPriceIngredient, actualIngredientPrice, 0);
    }
}
