package DecoratorPattern;

public class VanillaIceCream extends IceCreamDecorator{

    public VanillaIceCream(IceCream iceCream) {
        super(iceCream);
    }

    public Double getCost() {
        return tempIceCream.getCost() + 1.00;
    }

}
