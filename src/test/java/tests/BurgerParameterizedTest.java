package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Bun bun;
    private Ingredient ingredient;
    private float expectedPrice;

    public BurgerParameterizedTest(Bun bun, Ingredient ingredient, float expectedPrice) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Bun("black bun", 100), new Ingredient(IngredientType.FILLING, "cutlet", 100), 300F },
                { new Bun("white bun", 200), new Ingredient(IngredientType.SAUCE, "hot sauce", 100), 500F },
                { new Bun("red bun", 300), new Ingredient(IngredientType.FILLING, "sausage", 300), 900F }
        });
    }

    @Test
    public void testGetPriceWithParameters() {
        // Проверяем цену для разных булочек и ингредиентов
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceiptWithParameters() {
        // Проверяем правильность получения рецепта
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = String.format("(==== %s ====)\r\n= %s %s =\r\n(==== %s ====)\r\n\r\nPrice: %f\r\n",
                bun.getName(), ingredient.getType().toString().toLowerCase(), ingredient.getName(), bun.getName(), expectedPrice);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}