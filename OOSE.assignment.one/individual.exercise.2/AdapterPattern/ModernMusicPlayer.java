package AdapterPattern;

public class ModernMusicPlayer implements USBDevice {

    @Override
    public void connectWithUSB() {
        System.out.println("I'm playing new music!");
    }

}
