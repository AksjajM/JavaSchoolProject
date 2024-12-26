package SingletonPattern;

public class LampController {

    //Variables
    private static LampController lampController;
    boolean status;

    //When making an object of the CodingPatterns.Singleton.LampController Class the first status is set to false
    private LampController() {
        setInitialStatus();
    }

    //LampControllerObject
    public static LampController getLCObject() {
        if (lampController == null) {
            lampController = new LampController();
        }
        return lampController;
    }

    private void setInitialStatus() {
        status = false;
    }

    public void turnOn() {
        status = true;
        System.out.println("Lamp has been turned on!");
    }

    public void turnOff() {
        status = false;
        System.out.println("Lamp has been turned off!");
    }

    public void getStatus() {
        if (!status) {
            System.out.println("Lamp is off!");
        } else {
            System.out.println("Lamp is turned on!");
        }
    }

}
