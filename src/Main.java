public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human person1 = new Human("Alice");
        person1.setMakeOrder(true);
        market.acceptToMarket(person1);

        Human person2 = new Human("Bob");
        person2.setTakeOrder(true);
        market.acceptToMarket(person2);


        market.update();
    }
}