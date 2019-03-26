package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
    private Order testOrder;

    @Before
    public void setUp(){
        testOrder = new Order(10, "test", 20);
        testOrder.set_state(true);
    }

    @Test
    public void setState(){
        testOrder.set_state(false);
        boolean test = testOrder.get_state();
        Assert.assertEquals(false, test);
    }

    @Test
    public void getState(){
        boolean test = testOrder.get_state();
        Assert.assertEquals(true, test);
    }

    @Test
    public void getNumber(){
        int test = testOrder.get_number();
        Assert.assertEquals(10, test);
    }

    @Test
    public void getSubject(){
        String test = testOrder.get_subject();
        Assert.assertEquals("test", test);
    }

    @Test
    public void getAmount(){
        int test = testOrder.get_amount();
        Assert.assertEquals(20, test);
    }
}