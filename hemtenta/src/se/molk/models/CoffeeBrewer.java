package se.molk.models;

public class CoffeeBrewer {
    private CoffeeCup[] coffeeCups;

    public CoffeeBrewer(int numberOfCupsToBrew) {
        this.coffeeCups = new CoffeeCup[numberOfCupsToBrew];
        //För varje antal kopp jag vill rita så körs denna
        for (int i= 0; i < numberOfCupsToBrew; i++) {
            this.coffeeCups[i] = new CoffeeCup();

        }

    }

    public CoffeeCup[] getCoffeeCups() {





        return coffeeCups;
    }
}
