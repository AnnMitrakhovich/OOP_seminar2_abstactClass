public class Program {
    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Yakov");
        Human human2 = new Human("Vasiliy");
        Human human3 = new Human("Irina");
        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);
        market.update();
    }
}