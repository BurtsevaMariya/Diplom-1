package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkingGetTypeSauce(){
        IngredientType sauce = IngredientType.SAUCE;
        String expectedTypeIngredient = "SAUCE";
        String actualTypeIngredient = sauce.name();

        assertEquals("Ожидаемый результат, тип ингредиента: " + expectedTypeIngredient + ". Фактический результат, тип ингредиента: " + actualTypeIngredient, expectedTypeIngredient, actualTypeIngredient);
    }

    @Test
    public void checkingGetTypeFilling(){
        IngredientType filling = IngredientType.FILLING;
        String expectedTypeIngredient = "FILLING";
        String actualTypeIngredient = filling.name();

        assertEquals("Ожидаемый результат, тип ингредиента: " + expectedTypeIngredient + ". Фактический результат, тип ингредиента: " + actualTypeIngredient, expectedTypeIngredient, actualTypeIngredient);
    }
}
