package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;


public class BunTest {

    @Mock
    private Bun bun;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBunPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);

        Assert.assertEquals(100F, bun.getPrice(), 0);
    }
}