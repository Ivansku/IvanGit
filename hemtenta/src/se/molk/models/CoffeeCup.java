package se.molk.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.molk.Uppgift3a;

import java.io.File;

public class CoffeeCup extends ImageView {

    public CoffeeCup() {
        super();
        Image image = new Image(new File("images/cup-of-coffee.png").toURI().toString());
        this.setImage(image);

    }

    /**
     * Anger x-position för det här objektet i fönstret
     */

    /**
     * @return ett slumptal mellan 0 och max
     */
    public double getXPosition(int max) {
        return (int) (Math.random() * (max));

    }

    /**
     * Anger y-position för det här objektet i fönstret
     *
     * @return ett slumptal mellan 0 och max
     */
    public int getYPosition(int max) {
        return (int) (Math.random() * (max));
    }

}
