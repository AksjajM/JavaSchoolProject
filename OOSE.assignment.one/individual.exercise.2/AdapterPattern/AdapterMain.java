package AdapterPattern;

public class AdapterMain {
    public static void main(String[] args) {

        OldPrinter oldPrinterWithUSB = new OldPrinter();

        PrinterAdapter USBAdapter = new PrinterAdapter(oldPrinterWithUSB);

        System.out.println("This is the old printer using the new USB adapter ");
        USBAdapter.connectWithUSB();

        oldPrinterWithUSB.printUsingParallelPort();

        ModernMusicPlayer Sony = new ModernMusicPlayer();

        OldMusicPlayer LP = new OldMusicPlayer();
        MusicPlayerAdapter LPWithCableConverter = new MusicPlayerAdapter(LP);

        LPWithCableConverter.connectWithUSB();

        Sony.connectWithUSB();
    }
}
