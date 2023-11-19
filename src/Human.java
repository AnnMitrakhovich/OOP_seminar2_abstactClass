public class Human extends Actor{

    public Human(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setMakeOrder() {
        super.isMakeOrder = true;
    }

    @Override
    public void setTakeOrder() {
        super.isTakeOrder = true;
    }


    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
}
