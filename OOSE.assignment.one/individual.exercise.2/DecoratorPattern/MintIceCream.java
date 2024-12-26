package DecoratorPattern;

public class MintIceCream extends IceCreamDecorator {

    public MintIceCream(IceCream iceCream) {
        super(iceCream);
    }

    public Double getCost() {
        return tempIceCream.getCost() + 1.50;
    }

}
