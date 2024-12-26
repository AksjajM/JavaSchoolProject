package stack;

public interface OOSEStack {
    void push(Double d);

    Double peek() throws Exception;

    Double pop() throws Exception;

    Integer getSize();

    static OOSEStack sort(OOSEStack stack){return null;}
}
