package sample;

public class Order {
    private int number;
    private String subject;
    private int amount;
    private boolean state;

    Order(int _number, String _subject, int _amount) {
        number = _number;
        subject = _subject;
        amount = _amount;
        state = false;
    }

    public void set_state(boolean s)
    {
        state = s;
    }

    public int get_number(){
        return number;
    }

    public String get_subject(){
        return subject ;
    }

    public int get_amount(){
        return amount;
    }

    public boolean get_state(){
        return state;
    }
}