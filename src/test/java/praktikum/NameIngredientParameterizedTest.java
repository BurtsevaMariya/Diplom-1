package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class NameIngredientParameterizedTest {
    private final Object type;
    private final String name;
    private final float price;
    private final String expectedNameIngredient;

    public NameIngredientParameterizedTest(Object type, String name, float price, String expectedNameIngredient) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedNameIngredient = expectedNameIngredient;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){
        return new Object[][]{
                {SAUCE, "hot sauce", 100, "hot sauce"},
                {SAUCE, "sour cream", 200, "sour cream"},
                {SAUCE, "chili sauce", 300, "chili sauce"},

                {FILLING, "cutlet", 100, "cutlet"},
                {FILLING, "dinosaur", 200, "dinosaur"},
                {FILLING, "sausage", 300, "sausage"},
        };
    }

    @Test
    public void checkingGetIngredientType(){
        Ingredient ingredient = new Ingredient((IngredientType) type, name,price);
        String actualIngredientName = ingredient.getName();

        assertEquals("Ожидаемый результат, название: " + expectedNameIngredient + ". Фактический результат, название: " + actualIngredientName, expectedNameIngredient, actualIngredientName);
    }
}
