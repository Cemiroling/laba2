package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    private View view = new View();
    private Model model = new Model();

    public void setGridPane() {
        view.setStartGrid();
    }

    EventHandler<ActionEvent> MakeOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.MakeOrder(view);
        }
    };

    EventHandler<ActionEvent> CancelOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.CancelOrder(view);
        }
    };

    EventHandler<ActionEvent> ExitEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
        }
    };

    EventHandler<ActionEvent> PhysicalEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.PhysicalOrder(view);
        }
    };

    EventHandler<ActionEvent> UridicalEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.UridicalOrder(view);
        }
    };

    EventHandler<ActionEvent> CreateOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.CreateOrder(view);
        }
    };

    EventHandler<ActionEvent> PayOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.PayOrder(view);
        }
    };

    public Controller() {
        view.setMakeOrderEvent(MakeOrderEvent);
        view.setCreateOrderEvent(CreateOrderEvent);
        view.setPayOrderEvent(PayOrderEvent);
        view.setExitEvent(ExitEvent);
        view.setCancelOrderEvent(CancelOrderEvent);
        view.setPhysicalOrderEvent(PhysicalEvent);
        view.setUridicalOrderEvent(UridicalEvent);
    }
}