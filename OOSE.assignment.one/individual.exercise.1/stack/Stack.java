package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This class is supposed to represent a stack
 * Finish the methods below
 * The tests can guide you in the right direction but are not absolute infallible
 */
public class Stack implements OOSEStack {
    /***
     * Leave these two variables
     */
    private StackNode<Double> top;
    int size = 0;

    /**
     * @param d Pushes element to the top of the stack.
     *          If an element already exists on the top. Update the reference (Stacknode.next)
     *          Also increases size
     */
    @Override
    public void push(Double d) {
        StackNode<Double> newNode = new StackNode<>(d);

        if (top != null) {
            newNode.setNext(top);
        }

        top = newNode;
        size++;
    }

    /**
     * @return The element on top of the stack but does NOT remove it.
     * If stack is empty throw an EmptyStackException
     * Also checks if top is null. If it is, throw an exception.
     */
    @Override
    public Double peek() {
        if (top != null) {
            return top.getValue();
        } else {
            throw new EmptyStackException();

        }
    }

    /**
     * @return The element on top of the stack and removes it.
     * If stack is empty throw an EmptyStackException.
     * Also checks if top is null. If it is, throw an exception.
     */
    @Override
    public Double pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        double poppedValue = top.getValue();
        top = top.getNext();
        size--;
        return poppedValue;
    }

    /**
     * @return the size of the stack
     */
    @Override
    public Integer getSize() {
        return size;
    }

    /**
     * Sorts the stack in ascending order.
     * You can use any existing sorting algorithm like Bubble sort, Merge sort, quick sort etc.
     * Or you can create your own...
     * You cannot use build in sort methods like Collection.sort() or Arrays.sort()
     * The sorting algorithm should be a different from the one used for the LinkedList.
     */
    public static OOSEStack sort(OOSEStack stack) throws Exception {
        //Create a new arrayList to add and sort the values
        ArrayList<Double> listToSort = new ArrayList<>();

        if (stack == null || stack.getSize() == 0) {
            return null;
        }

        //Turn stack into the arrayList
        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++) {
            listToSort.add(stack.peek());
            stack.pop();
        }

        //Sort the arrayList
        for (int i = 0; i < listToSort.size(); i++) {
            for (int j = 0; j < listToSort.size() - 1; j++) {
                if (listToSort.get(j) > listToSort.get(j + 1)) {
                    Double temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                }
            }
        }

        //Adding the sorted values from the arrayList to the Stack
        for (int i = listToSort.size() - 1; i >= 0; i--) {
            stack.push(listToSort.get(i));
        }

        return stack;
    }
}
