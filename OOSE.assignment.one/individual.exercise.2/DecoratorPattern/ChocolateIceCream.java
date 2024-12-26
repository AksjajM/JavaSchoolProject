package DecoratorPattern;

public class ChocolateIceCream extends IceCreamDecorator {

    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
    }

    public Double getCost() {
        return tempIceCream.getCost() + 2.00;
    }

}
