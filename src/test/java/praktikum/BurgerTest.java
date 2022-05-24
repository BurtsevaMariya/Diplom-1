package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Ingredient ingredient;

    @Mock
    private Bun bun;

    @Test
    public void checkingSetBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void checkingAddIngredientBurger() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        String expectedNameIngredient = "hot sauce";
        String actualNameIngredient = String.valueOf(burger.ingredients.get(0).getName());

        assertEquals("Элемент не совпадает", expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void checkingRemoveIngredientBurger() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expectedAmountIngredient = 0;
        int actualAmountIngredient = burger.ingredients.size();

        assertEquals("Ожидаемый результат, количество элементов в списке: " + expectedAmountIngredient + ". Фактический результат, количество элементов в списке: " + actualAmountIngredient, expectedAmountIngredient, actualAmountIngredient);
    }

    @Test
    public void checkingMoveIngredientBurger() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 2);
        String expectedNameIngredient = "hot sauce";
        String actualNameIngredient = String.valueOf(burger.ingredients.get(2).getName());

        assertEquals("Ожидаемый результат, ингредиент " + expectedNameIngredient + ". Фактический результат, ингредиент: " + actualNameIngredient, expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void checkingPriceBurger() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedPriceIngredient = 200.0F;
        float actualPriceIngredient = burger.getPrice();

        assertEquals("Ожидаемый результат, цена " + expectedPriceIngredient + ". Фактический результат, цена: " + actualPriceIngredient, expectedPriceIngredient, actualPriceIngredient, 0.1);
    }

    @Test
    public void checkingReceiptBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        String expectedReceipt = String.join("\r\n","(==== black bun ====)","= filling dinosaur =","(==== black bun ====)", "", "Price: 900,000000", "");

        String actualReceipt = burger.getReceipt();

        assertEquals("Ожидаемый результат, чек \r\n" + expectedReceipt + "\r\n Фактический результат, чек \r\n" + actualReceipt, expectedReceipt, actualReceipt);
        System.out.println("ОР: " + expectedReceipt);
        System.out.println("ФР: " + actualReceipt);

    }

    @Test
    public void checkingReceiptBurgerTwo(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        assertFalse(burger.getReceipt().isEmpty());
    }
}

