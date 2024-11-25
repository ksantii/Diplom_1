package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    @Mock
    private Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIngredientType() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void testIngredientPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        Assert.assertEquals(50F, ingredient.getPrice(), 0);
    }

    @Test
    public void testIngredientName() {
        Mockito.when(ingredient.getName()).thenReturn("Cutlet");
        Assert.assertEquals("Cutlet", ingredient.getName());
    }
}