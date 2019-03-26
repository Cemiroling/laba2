package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View {
    private Stage stage = new Stage();

    private Button btn1 = new Button("Make order");
    private Button btn2 = new Button("Exit");
    private TextField name = new TextField();
    private TextField money = new TextField();
    private Label name_lbl = new Label("Name");
    private Label money_lbl = new Label("Balance");

    private ToggleGroup group = new ToggleGroup();
    private RadioButton phys_btn = new RadioButton("Physical");
    private RadioButton urid_btn = new RadioButton("Uridistic");
    private TextField order_subject = new TextField();
    private TextField order_amount = new TextField();
    private Label subject_lbl = new Label("subject: ");
    private Label amount_lbl = new Label("amount: ");
    private Button create_btn = new Button("Create order");

    private Label order_lbl = new Label("Current order");
    private Label number_lbl = new Label();
    private Label paymentamount = new Label();
    private Button pay_btn = new Button("Pay");
    private Button cancel_btn = new Button("Cancel");

    private Label orderState = new Label();

    public void setGap (GridPane gridPane){
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(10,10,10,10));
    }

    public void setStartGrid(){
        stage.setTitle("lab2");
        GridPane grid = new GridPane();
        stage.setWidth(355);
        stage.setHeight(155);
        setGap(grid);

        GridPane.setHalignment(name_lbl, HPos.LEFT);
        grid.add(name_lbl,0,0);

        GridPane.setHalignment(name, HPos.LEFT);
        grid.add(name,0,1);

        GridPane.setHalignment(money_lbl, HPos.LEFT);
        grid.add(money_lbl,1,0);

        GridPane.setHalignment(money, HPos.LEFT);
        grid.add(money,1,1);

        GridPane.setHalignment(btn1, HPos.LEFT);
        grid.add(btn1,0,2);

        GridPane.setHalignment(btn2, HPos.LEFT);
        grid.add(btn2,1,2);
        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void setCreateGrid(){
        GridPane grid = new GridPane();
        stage.setWidth(270);
        stage.setHeight(195 );
        setGap(grid);

        order_subject.clear();
        order_amount.clear();

        GridPane.setHalignment(phys_btn, HPos.LEFT);
        grid.add(phys_btn,0,0);
        phys_btn.setToggleGroup(group);
        phys_btn.setSelected(true);

        GridPane.setHalignment(urid_btn, HPos.LEFT);
        grid.add(urid_btn,1,0);
        urid_btn.setToggleGroup(group);

        subject_lbl.setText("subject: ");
        GridPane.setHalignment(subject_lbl, HPos.LEFT);
        grid.add(subject_lbl,0,1);

        order_subject.setPromptText("");
        GridPane.setHalignment(order_subject, HPos.LEFT);
        grid.add(order_subject,1,1);

        amount_lbl.setText("amount: ");
        GridPane.setHalignment(amount_lbl, HPos.LEFT);
        grid.add(amount_lbl,0,2);

        order_amount.setPromptText("");
        GridPane.setHalignment(order_amount, HPos.LEFT);
        grid.add(order_amount,1,2);

        GridPane.setHalignment(create_btn, HPos.CENTER);
        grid.add(create_btn,0,3,2,1);

        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void setPayGrid(Order o){
        GridPane grid = new GridPane();
        stage.setWidth(270);
        stage.setHeight(140);
        grid.setHgap(15);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,10,10));

        GridPane.setHalignment(order_lbl, HPos.LEFT);
        grid.add(order_lbl,0,0);

        number_lbl.setText("number: "+ o.get_number());
        GridPane.setHalignment(number_lbl, HPos.LEFT);
        grid.add(number_lbl,0,1);

        subject_lbl.setText("subject: "+ o.get_subject());
        GridPane.setHalignment(subject_lbl, HPos.LEFT);
        grid.add(subject_lbl,0,2);

        amount_lbl.setText("amount: "+ o.get_amount());
        GridPane.setHalignment(amount_lbl, HPos.LEFT);
        grid.add(amount_lbl,0,3);

        paymentamount.setText("Payment amount: " + o.get_amount() * 100);
        GridPane.setHalignment(paymentamount, HPos.LEFT);
        grid.add(paymentamount, 1,1,2,1);

        pay_btn.setPrefWidth(65);
        GridPane.setHalignment(pay_btn, HPos.RIGHT);
        grid.add(pay_btn,1,2,1,2);

        cancel_btn.setPrefWidth(65);
        GridPane.setHalignment(cancel_btn, HPos.RIGHT);
        grid.add(cancel_btn,2,2,1,2);

        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void setOrderGrid(Client client){
        GridPane grid = new GridPane();
        stage.setWidth(220);
        stage.setHeight(150);
        setGap(grid);

        if(client.getComp().getOrderList().lastElement().get_state() == true) {
            orderState.setStyle("-fx-text-fill: green;");
            orderState.setText("Order completed!");
        }
        else {
            orderState.setStyle("-fx-text-fill: red;");
            orderState.setText("Order cancelled!");
        }

        GridPane.setHalignment(orderState, HPos.LEFT);
        grid.add(orderState, 0,0,2,1);

        name_lbl.setText("Name: "+ client.getName());
        GridPane.setHalignment(name_lbl, HPos.LEFT);
        grid.add(name_lbl,0,1);

        money_lbl.setText("Money: "+ client.getMoney());
        GridPane.setHalignment(money_lbl, HPos.LEFT);
        grid.add(money_lbl,1,1);

        GridPane.setHalignment(btn1, HPos.RIGHT);
        grid.add(btn1,0,2);

        GridPane.setHalignment(btn2, HPos.LEFT);
        grid.add(btn2,1,2);

        name.setText(client.getName());
        money.setText(Integer.toString(client.getMoney()));

        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void setMakeOrderEvent (EventHandler<ActionEvent> handle){
        btn1.setOnAction(handle);
    }

    public void setCreateOrderEvent (EventHandler<ActionEvent> handle){
        create_btn.setOnAction(handle);
    }

    public void setPayOrderEvent (EventHandler<ActionEvent> handle){
        pay_btn.setOnAction(handle);
    }

    public void setCancelOrderEvent (EventHandler<ActionEvent> handle){
        cancel_btn.setOnAction(handle);
    }

    public void setPhysicalOrderEvent (EventHandler<ActionEvent> handle){
        phys_btn.setOnAction(handle);
    }

    public void setUridicalOrderEvent (EventHandler<ActionEvent> handle){
        urid_btn.setOnAction(handle);
    }

    public void setExitEvent (EventHandler<ActionEvent> handle){
        btn2.setOnAction(handle);
    }

    public String getOrderName(){
        return order_subject.getText();
    }

    public String getOrderAmount(){
        return order_amount.getText();
    }

    public String getName(){
        return name.getText();
    }

    public String getMoney(){
        return money.getText();
    }

    public void nameErr(){
        name.clear();
        name.setPromptText("Name doesn't entered!");
    }

    public void moneyErr(){
        money.clear();
        money.setPromptText("Uncorrect digit!");
    }

    public void subjectErr(){
        order_subject.clear();
        order_subject.setPromptText("Subject doesn't entered!");
    }

    public void amountErr(){
        order_amount.clear();
        order_amount.setPromptText("Uncorrect digit!");
    }

    public void AmountLimitError(int max){
        order_amount.clear();
        order_amount.setPromptText("Max amount is " + max);
    }
}