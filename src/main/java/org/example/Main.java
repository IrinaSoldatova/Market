package org.example;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human human = new Human("Dima");
        Human human1 = new Human("Vika");

        market.acceptToMarket(human);
        market.acceptToMarket(human1);
        market.update();
    }
}