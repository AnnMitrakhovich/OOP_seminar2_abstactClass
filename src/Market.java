import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> queue;

    public Market(){
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.printf("%s пришел в магазин\n", actor.getName());
        takeInQueue(actor);
    }
    @Override
    public void takeInQueue(Actor actor) {
        System.out.printf("%s встал в очередь\n", actor.getName());
        this.queue.add(actor);

    }
    @Override
    public void takeOrders() {
        for(Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder();
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for(Actor actor: queue){
            if(actor.isMakeOrder()){
                actor.setTakeOrder();
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for(Actor actor: queue){
            if(actor.isTakeOrder()){
                releaseActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
        releaseFromMarket(releaseActors);
    }
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor: actors){
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

}