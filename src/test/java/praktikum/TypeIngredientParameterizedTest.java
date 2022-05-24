package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TypeIngredientParameterizedTest {
    private final Object type;
    private final String name;
    private final float price;
    private final Object expectedTypeIngredient;

    public TypeIngredientParameterizedTest(Object type, String name, float price, Object expectedTypeIngredient) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedTypeIngredient = expectedTypeIngredient;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){
        return new Object[][]{
                {SAUCE, "hot sauce", 100, SAUCE},
                {SAUCE, "sour cream", 200, SAUCE},
                {SAUCE, "chili sauce", 300, SAUCE},

                {FILLING, "cutlet", 100, FILLING},
                {FILLING, "dinosaur", 200, FILLING},
                {FILLING, "sausage", 300, FILLING},
        };
    }

    @Test
    public void checkingGetIngredientType(){
        Ingredient ingredient = new Ingredient((IngredientType) type, name,price);
        IngredientType actualIngredientType = ingredient.getType();

        assertEquals("Ожидаемый результат, тип: " + expectedTypeIngredient + ". Фактический результат, тип: " + actualIngredientType,expectedTypeIngredient, actualIngredientType);
    }
}
