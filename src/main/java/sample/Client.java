package sample;

public class Client {
    private String name;
    private int money;
    private int maxAmount;

    private Company comp = new Company();

    Client(){
        name = "0";
        money = 0;
        maxAmount = 10;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int _maxAmount) {
        maxAmount = _maxAmount;
    }

    public void setName(String _name){
        name = _name;
    }

    public void setMoney(int _money){
        money = _money;
    }

    public int getMoney(){
        return money;
    }

    public Company getComp(){
        return comp;
    }

    public String getName(){
        return name;
    }

    public Order make_order(String name, int Amount){
        return comp.create_order(name, Amount);
    }

    public void PayOrder(){
        money -= comp.getOrderList().lastElement().get_amount() * 100;
        comp.perform_order();
    }

}