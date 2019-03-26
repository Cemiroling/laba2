package sample;

public class Model {
    private Client client = new Client();

    public void PhysicalOrder(View view){
        client.setMaxAmount(10);
        view.AmountLimitError(10);
    }

    public void UridicalOrder(View view){
        client.setMaxAmount(1000);
        view.AmountLimitError(1000);

    }

    public void CreateOrder(View view){
        if(isEnter(view.getOrderName()) && isNumeric(view.getOrderAmount())) {
            if(Integer.parseInt(view.getOrderAmount()) <= client.getMaxAmount())
                view.setPayGrid(client.make_order(view.getOrderName(), Integer.parseInt(view.getOrderAmount())));
            else
                view.AmountLimitError(client.getMaxAmount());
        }
        else {
            if (!isEnter(view.getOrderName()))
                view.subjectErr();
            if (!isNumeric(view.getOrderAmount()))
                view.amountErr();
        }
    }

    public void MakeOrder(View view){
        if(isEnter(view.getName()) && isNumeric(view.getMoney())) {
            client.setName(view.getName());
            client.setMoney(Integer.parseInt(view.getMoney()));
            view.setCreateGrid();
        }
        else {
            if (!isEnter(view.getName()))
                view.nameErr();
            if (!isNumeric(view.getMoney()))
                view.moneyErr();
        }
    }

    public void PayOrder(View view){
        client.PayOrder();
        view.setOrderGrid(client);
        client.getComp().cancel_order();
    }

    public void CancelOrder(View view){
        view.setOrderGrid(client);
        client.getComp().cancel_order();
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isEnter(String str) {
        if (str.trim().length() > 0)
            return true;
        else
            return false;
    }
}