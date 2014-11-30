package se.molk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Uppgift2 extends Application {

    TextField firstField;
    TextField secondField;
    Label resultLabel;
    Button btn;

    @Override
    public void start(Stage primaryStage) {
        firstField = new TextField();
        firstField.setText("");
        firstField.setMaxWidth(120.0);
        secondField = new TextField();
        secondField.setText("");
        secondField.setMaxWidth(120.0);
        resultLabel = new Label();
        resultLabel.setText("");
        btn = new Button();
        btn.setText("Kombinera");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println();
                resultLabel.setText(combineWords(firstField.getText(), secondField.getText()));
            }
        });

        Pane root = new Pane();
        root.getChildren().addAll(firstField, secondField, btn, resultLabel);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Strängkombineraren");
        primaryStage.setScene(scene);
        primaryStage.show();

        int x = 10;
        int y = 10;

        firstField.relocate(x, y);
        secondField.relocate(2 * x + firstField.getWidth(), y);
        btn.relocate(secondField.getLayoutX() + secondField.getWidth() + x, y);
        resultLabel.relocate(x, 2 * y + firstField.getHeight());
    }

    public String combineWords(String first, String second) {
        int i = 0;
        String newString = "";
        //Kör en loop beroende på hur långa orden är
        while (i < first.length() && i < second.length()) {

            //Kollar varannan bokstav
            if(i%2 ==0){
                newString = newString + first.charAt(i);

            }
            //Kollar återstående bokstäver
            else{
                newString = newString +second.charAt(i);

            }
            //Plusar på i loopen tills ordlängderna är slut
            i++;

        }

        return newString;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
