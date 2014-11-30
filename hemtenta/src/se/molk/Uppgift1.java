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

import java.util.Calendar;

public class Uppgift1 extends Application {

    TextField textField;
    Button btn;
    Label yearLabel;
    Label ageLabel;
    Label driveLabel;
    Label rideLabel;
    Label receiveLabel;
    Label retireLabel;



    @Override
    public void start(Stage primaryStage) {
        textField = new TextField();
        textField.setText("Födelseår");
        yearLabel = new Label("");
        ageLabel = new Label("");
        driveLabel = new Label("");
        rideLabel = new Label("");
        receiveLabel = new Label("");
        retireLabel = new Label("");

        btn = new Button();
        btn.setText("Beräkna ålder och rättigheter");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int year = Integer.parseInt(textField.getText());
                    yearLabel.setText("Födelseår: " + year);
                    int age = getAgeFromYear(year);
                    printAge(age);
                    printMayDrive(age);
                    printMayRideCheap(age);
                    printMayRecieveCSN(age);
                    printMayRetire(age);
                } catch (java.lang.NumberFormatException e) {
                    yearLabel.setText("Ej giltigt årtal.");
                    ageLabel.setText("");
                    driveLabel.setText("");
                    rideLabel.setText("");
                    receiveLabel.setText("");
                    retireLabel.setText("");
                }
            }
        });

        Pane root = new Pane();
        root.getChildren().addAll(textField, btn, yearLabel, ageLabel, driveLabel, rideLabel, receiveLabel, retireLabel);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Ålderskalkylatorn");
        primaryStage.setScene(scene);
        primaryStage.show();

        int x = 10;
        int y = 10;

        textField.relocate(x, y);
        btn.relocate(2 * x + textField.getWidth(), y);
        yearLabel.relocate(x, y + textField.getLayoutY() + textField.getHeight());
        ageLabel.relocate(x, y + yearLabel.getLayoutY() + yearLabel.getHeight());
        driveLabel.relocate(x, y + ageLabel.getLayoutY() + ageLabel.getHeight());
        rideLabel.relocate(x, y + driveLabel.getLayoutY() + driveLabel.getHeight());
        receiveLabel.relocate(x, y + rideLabel.getLayoutY() + rideLabel.getHeight());
        retireLabel.relocate(x, y + receiveLabel.getLayoutY() + receiveLabel.getHeight());
    }

    public int getAgeFromYear(int year) {
        year = 2014-year;
        return year;
    }

    public void printAge(int age) {
        ageLabel.setText("Ålder: " + age);
    }

    public void printMayDrive(int age) {
        if(age < 18) {
            driveLabel.setText("Du är under 18 och får inte skaffa körkort");
        }
        else{
            driveLabel.setText("Du är 18 eller äldre och får skaffa körkort");
        }
    }

    public void printMayRideCheap(int age) {
        if(age < 26) {
            rideLabel.setText("Du är under 26 och får åka stadsbuss billigt");
        }
        else{
            rideLabel.setText("Du är 26 eller äldre och får åka inte stadsbuss billigt");
        }
    }

    public void printMayRecieveCSN(int age) {
        if(age <= 56) {
            receiveLabel.setText("Du är 56 eller yngre och kan få bidrag från CSN");
        }
        else{
            receiveLabel.setText("Du är över 56 och kan inte få bidrag från CSN");
        }
    }

    public void printMayRetire(int age) {
        if(age <61) {
            retireLabel.setText("Du är under 61 och får inte gå i pension");
        }
        else if(age >67){
            retireLabel.setText("Du är över 67 och har inte längre rätt att arbeta.");
        }
        else{
            retireLabel.setText("Du är mellan 61 och 67 och får gå i pension.");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}