package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
    Company testCompany;

    @Before
    public void setUp(){
        testCompany = new Company();
    }

    @Test
    public void CreateOrderAndGetOrderList(){
        testCompany.create_order("test", 10);
        Order testOrder = new Order(1, "test", 10);
        testOrder.set_state(false);

        Assert.assertNotNull(testCompany.getOrderList());
        Assert.assertEquals(testOrder.get_number(), testCompany.getOrderList().lastElement().get_number());
        Assert.assertEquals(testOrder.get_subject(), testCompany.getOrderList().lastElement().get_subject());
        Assert.assertEquals(testOrder.get_amount(), testCompany.getOrderList().lastElement().get_amount());
        Assert.assertEquals(testOrder.get_state(), testCompany.getOrderList().lastElement().get_state());
    }

    @Test
    public void CancelOrder() {
        testCompany.create_order("test", 10);
        testCompany.cancel_order();
        Assert.assertTrue(testCompany.getOrderList().isEmpty());
    }

    @Test
    public void PerformOrder(){
        testCompany.create_order("test", 10);
        testCompany.perform_order();
        Assert.assertEquals(true, testCompany.getOrderList().lastElement().get_state());
    }
}
