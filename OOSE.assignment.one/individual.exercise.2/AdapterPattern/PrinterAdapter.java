package AdapterPattern;

public class PrinterAdapter implements USBDevice {

    //Why is IntelliJ saying that this variable could be final
    //Is this because the name of printer could be final?
    private final OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter newPrinter) {
        oldPrinter = newPrinter;
    }

    @Override
    public void connectWithUSB() {
        oldPrinter.printUsingParallelPort();
    }
}
