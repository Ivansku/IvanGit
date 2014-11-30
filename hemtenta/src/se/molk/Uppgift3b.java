package se.molk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se.molk.models.CoffeeBrewer;
import se.molk.models.CoffeeCup;

/////////////////////////////////////////////////////////
//
// Ändra i models.CoffeeBrewer för den här uppgiften
//
// Ändra INTE i denna fil. Denna fil är bara till för
// att köra och testa programmet.
//
/////////////////////////////////////////////////////////

public class Uppgift3b extends Application {
    int width = 640;
    int height = 480;

    TextField textField;
    Pane cupPane;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, width, height);
        cupPane = new Pane();
        textField = new TextField();
        Button btn = new Button();
        btn.setText("Brygg kaffe");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                brewCoffee();
            }
        });

        root.getChildren().addAll(cupPane, textField, btn);

        primaryStage.setTitle("Kaffebryggaren");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.relocate(textField.getWidth(), 0);
    }

    public void brewCoffee() {
        cupPane.getChildren().clear();
        int cups = Integer.parseInt(textField.getText());
        CoffeeBrewer brewer = new CoffeeBrewer(cups);
        for (CoffeeCup cup : brewer.getCoffeeCups()) {
            cup.relocate(
                    cup.getXPosition(width - (int) cup.getBoundsInParent().getWidth()),
                    cup.getYPosition(height - (int) cup.getBoundsInParent().getHeight())
            );
            cupPane.getChildren().add(cup);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
