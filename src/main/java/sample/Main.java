package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller = new Controller();

    @Override
    public void start(Stage stage) throws Exception
    {
        controller.setGridPane();
    }

    public static void main(String[] args) {
        launch(args);
    }
}