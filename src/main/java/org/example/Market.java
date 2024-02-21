package org.example;


import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private List<Actor> queue = new ArrayList<>();
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел(ла) в магазин.");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " покинул(а) магазин.");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал(а) в очередь.");
        queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал(а) заказ.");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил(а) заказ.");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел(ла) из очереди.");
            }
        }
        releaseFromMarket(releasedActors);
    }
}
