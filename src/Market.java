import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market implements MarketBehaviour, QueueBehaviour {
    private List<Actor> queue;

    private Random random = new Random();

    public Market() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        if (actor.isMakeOrder()) {
            System.out.println(actor.getName() + "пришел в магазин, чтобы сделать заказ.");
            queue.add(actor);
        } else {
            System.out.println(actor.getName() + "пришел в магазин, чтобы забрать заказ.");
        }
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        queue.removeAll(actorList);
        for (Actor actor : actorList) {
            System.out.println(actor.getName() + "вышел из магазина.");
        }
    }

    @Override
    public void update() {
        int orderToGive = random.nextInt(queue.size() / 2) + 1;
        List<Actor> readyToLeave = new ArrayList<>();

        for (int i = 0; i < orderToGive; i++) {
            if (!queue.isEmpty()) {
                Actor actor = queue.get(0);
                if (actor.isTakeOrder()) {
                    readyToLeave.add(actor);
                }
                queue.remove(0);
            }
        }

        releaseFromMarket(readyToLeave);
    }

    @Override
    public void takeInQueue(Actor actor) {
        acceptToMarket(actor);
    }

    @Override
    public void takeOrders() {

    }

    @Override
    public void giveOrders() {

    }

    @Override
    public void releaseFromQueue() {

    }
}
