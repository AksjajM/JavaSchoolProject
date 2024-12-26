package DecoratorPattern;

public abstract class IceCreamDecorator implements IceCream {

    protected IceCream tempIceCream;

    public IceCreamDecorator(IceCream newIceCream){
        tempIceCream = newIceCream;
    }

    @Override
    public Double getCost() {
        return null;
    }

}
