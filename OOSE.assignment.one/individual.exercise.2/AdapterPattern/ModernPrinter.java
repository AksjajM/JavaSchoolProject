package AdapterPattern;

public class ModernPrinter implements USBDevice {

    @Override
    public void connectWithUSB() {
        System.out.println("I'm printing!");
    }

}
