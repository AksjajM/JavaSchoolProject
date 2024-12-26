package DecoratorPattern;

//Runnable clss of Individual Exercise 2
public class DecoratorMain {
    public static void main(String[] args) {

        IceCream basicIceCream = new BasicIceCream();
        System.out.println("Basic ice cream cost €" + basicIceCream.getCost());
        // Add Vanilla to the order
        IceCream vanilla = new VanillaIceCream(basicIceCream); // wrapping basic ice cream with vanilla
        System.out.println("Adding Vanilla - cost is: €" + vanilla.getCost());
        // Add Mint to the order
        IceCream mintVanilla = new MintIceCream(vanilla); // wrapping
        System.out.println("Adding Mint - cost is: €" + mintVanilla.getCost());
        // Add Chocolate to the order
        IceCream chocolateMintVanilla = new ChocolateIceCream(mintVanilla); // wrapping
        System.out.println("Adding Chocolate - cost is: €" + chocolateMintVanilla.getCost());
    }
}
