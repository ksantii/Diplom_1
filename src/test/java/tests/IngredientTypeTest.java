package tests;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTest {

    @Test
    public void testIngredientTypeEnum() {
        // Проверка строкового представления для типа ингредиента SAUCE
        Assert.assertEquals(IngredientType.SAUCE.toString(), "SAUCE");

        // Проверка строкового представления для типа ингредиента FILLING
        Assert.assertEquals(IngredientType.FILLING.toString(), "FILLING");
    }
}