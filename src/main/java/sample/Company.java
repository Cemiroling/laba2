package sample;

import java.util.Stack;

public class Company {
    private Stack<Order> order_list;
    private static int order_count;

    Company()
    {
        order_count = 0;
        order_list = new Stack<>();
    }

    public Order create_order(String name, int count){
        order_count++;
        Order newOrder = new Order(order_count, name, count);
        order_list.push(newOrder);
        return newOrder;
    }

    public void cancel_order()
    {
        order_list.pop();
    }

    public Stack<Order> getOrderList(){
        return order_list;
    }

    public void perform_order() { order_list.lastElement().set_state(true); }
}