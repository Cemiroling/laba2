package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
    private Model testModel;

    @Before
    public void setUp(){
        testModel = new Model();
    }

    @Test
    public void IsNumeric(){
        boolean actual = testModel.isNumeric("100");
        Assert.assertTrue(actual);

        actual = testModel.isNumeric("test");
        Assert.assertFalse(actual);
    }

    @Test
    public void IsEnter(){
        boolean actual = testModel.isEnter("");
        Assert.assertFalse(actual);

        actual = testModel.isEnter("test");
        Assert.assertTrue(actual);
    }
}
