package se.molk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se.molk.models.CoffeeCup;


/////////////////////////////////////////////////////////
//
// Ändra i models.CoffeeCup för den här uppgiften
//
// Ändra INTE i denna fil. Denna fil är bara till för
// att köra och testa programmet.
//
/////////////////////////////////////////////////////////

public class Uppgift3a extends Application {
    CoffeeCup cup;
    int width = 640;
    int height = 480;

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, width, height);
        Button btn = new Button();
        btn.setText("Slumpa position på koppen");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                relocateCup();
            }
        });

        cup = new CoffeeCup();
        root.getChildren().addAll(cup, btn);

        relocateCup();

        primaryStage.setTitle("Slumpkoppen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void relocateCup() {
        cup.relocate(
                cup.getXPosition(width - (int) cup.getBoundsInParent().getWidth()),
                cup.getYPosition(height - (int) cup.getBoundsInParent().getHeight())
        );
    }
}
