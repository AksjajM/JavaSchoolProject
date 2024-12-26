package linked.list;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This class is supposed to represent a doubly linked list
 * Finish the methods below
 * The tests can guide you in the right direction but are not absolute infallible
 */
public class LinkedList implements OOSELinkedList {
    /***
     * Leave these three variables.
     */
    private LinkedListNode<Double> head;
    private LinkedListNode<Double> tail;
    private Integer size = 0;

    /**
     * @return The value of the head of the linked list.
     * Checks if head is null. If it is, return null.
     */
    @Override
    public Double getFirst() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    /**
     * @return The value of the tail of the linked list.
     * Checks if tail is null. If it is, return null.
     */
    @Override
    public Double getLast() {
        if (tail == null) {
            return null;
        }
        return tail.getValue();
    }

    /**
     * @return The size of the linked list
     */
    @Override
    public Integer getSize() {
        return size;
    }

    /**
     * @param index
     * @return An element of the LinkedList based on an index.
     * If index is not present (List to small or negative index), throw IndexOutOfBoundsException
     * STUDENTS: implementing the exception is optional. You are allowed to return null a test will fail.
     */
    @Override
    public Double get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode<Double> nodeAtIndex = head;

        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.getNext();
        }
        return nodeAtIndex.getValue();
    }

    /**
     * @param d Adds an element to head of the linked list and increases the size.
     *          In case the head is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the tail.
     */
    @Override
    public void addFirst(Double d) {
        LinkedListNode<Double> newNode = new LinkedListNode<>(d);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * @param d Adds an element to tail of the linked list and increases the size.
     *          In case the tail is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the head.
     */
    @Override
    public void addLast(Double d) {
        LinkedListNode<Double> newNode = new LinkedListNode<>(d);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    /**
     * @param index
     * @param d     Adds an element to the linked list based on an index
     *              In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *              Updates the surrounding nodes' previous and next variables
     *              Also updates the size
     *              <p>
     *              TIP: be smart with how you 'move' to the correct element.
     *              Mind the time complexity - O(?)
     */
    @Override
    public void add(int index, Double d) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        LinkedListNode<Double> newNode = new LinkedListNode<>(d);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        } else {
            LinkedListNode<Double> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            LinkedListNode<Double> prevNode = current.getPrevious();
            newNode.setNext(current);
            newNode.setPrevious(prevNode);
            current.setPrevious(newNode);
            prevNode.setNext(newNode);
        }

        size++;
    }

    /**
     * Removes the head of the linked list.
     * If there is only one element - also remove tail
     * Otherwise it updates the next elements previous/next node variables
     * Also updates the size
     */
    @Override
    public void removeFirst() {
        if (head != null) {
            if (size > 1) {
                head = head.getNext();
                head.setPrevious(null);
            } else {
                head = null;
                tail = null;
            }
            size--;
        }
    }

    /**
     * Removes the tail of the linked list.
     * If there is only one element - also remove head
     * Otherwise it updates the previous elements previous/next node variables
     * Also updates the size
     */
    @Override
    public void removeLast() {
        if (tail != null) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.getPrevious();
                tail.setNext(null);
            }
            size--;
        }
    }

    /**
     * @param index Removes an element based on an index.
     *              In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *              Updates the surrounding nodes' previous and next variables
     *              Also updates the size
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode<Double> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }


        if (currentNode.getNext() != null) {
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        } else {
            tail = currentNode.getPrevious();
        }

        if (currentNode.getPrevious() != null) {
            currentNode.getPrevious().setNext(currentNode.getNext());
        } else {
            head = currentNode.getNext();
        }
        size--;
    }

    /**
     * Sets the value of an element based on an index.
     * In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *
     * @param index
     * @param value
     */
    @Override
    public void set(int index, Double value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        LinkedListNode<Double> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.getNext();
            currentIndex++;
        }

        if (current != null) {
            current.setValue(value);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Sorts the list in ascending order.
     * You can use any existing sorting algorithm like Bubble sort, Merge sort, quick sort etc.
     * Or you can create your own...
     * You cannot use build in sort methods like Collection.sort() or Arrays.sort()
     * The sorting algorithm should be a different from the one used for the Stack.
     */
    public static OOSELinkedList sort(OOSELinkedList list) {
        if (list == null) {
            return null;
        }
        ArrayList<Double> listToSort = new ArrayList<>();

        //Fill in all values from the LinkedList to the ArrayList
        for (int i = 0; i < list.getSize(); i++) {
            listToSort.add(list.get(i));
        }

        //Sort the arrayList with the InsertionSort
        for (int i = 0; i < listToSort.size(); i++) {
            double temp = listToSort.get(i);
            int j = i - 1;

            while (j >= 0 && listToSort.get(j) > temp) {
                listToSort.set(j + 1, listToSort.get(j));
                j--;
            }
            listToSort.set(j + 1, temp);
        }

        //Put the values from the ArrayList back into the LinkedList
        for (int i = 0; i < listToSort.size(); i++) {
            list.set(i, listToSort.get(i));
        }

        return list;
    }

    /*
     * OPTIONAL:
     *  Make the most out of the doubly linked list by determining whether to start from the head or from the tail
     *  Can be interesting for the Add(), Get() and Remove() methods
     *
     *  Also, optional: implement the following methods:
     *  Clear()
     *  Contains()
     *  IndexOf()
     * */

}


