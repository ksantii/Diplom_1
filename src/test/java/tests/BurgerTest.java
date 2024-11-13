package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;


public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientFirst;

    @Mock
    private Ingredient ingredientSecond;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NullPointerException.class)
    public void testSetBunsWithoutBun() {
        // Тестируем, что метод getReceipt выбрасывает NullPointerException, если не задана булочка
        Burger burger = new Burger();
        burger.getReceipt(); // Должен вызвать NullPointerException
    }

    @Test
    public void testAddIngredient() {
        // Проверяем добавление ингредиента в бургер
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);

        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredient() {
        // Проверяем удаление ингредиента из бургера
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        // Проверяем перемещение ингредиента внутри списка
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);

        Assert.assertTrue(burger.ingredients.get(0).equals(ingredientSecond));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(1F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);

        Assert.assertEquals(5F, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("Black Bun");
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFirst.getName()).thenReturn("Cutlet");
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);

        String expected = "(==== Black Bun ====)\r\n" +
                "= filling Cutlet =\r\n" +
                "(==== Black Bun ====)\r\n" +
                "\r\nPrice: 0,000000\r\n";

        Assert.assertEquals(expected, burger.getReceipt());
    }
}