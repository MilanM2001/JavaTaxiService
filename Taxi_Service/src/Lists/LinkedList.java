package Lists;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private ListNode<T> head;
    private ListNode<T> tail;

    private int listSize;

    ListNode<T> getHead() {
        return head;
    }

    public void addFirst(T element) {
        ListNode<T> newNode = new ListNode<>(element, null, head);
        head = newNode;

        if(tail == null)
            tail = newNode;

        listSize++;
    }

    public void addLast(T element) {
        ListNode<T> newNode = new ListNode<>(element, tail, null);

        if(listSize == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        listSize++;
    }

    public void add(T element) {
        addLast(element);
    }

    public void add(int index, T element){
        if(index < 0 || index >= (listSize + 1))
            throw new IndexOutOfBoundsException("Index out of bounds!");


    }

    public T getFirst(){
        if(listSize == 0)
            throw new IndexOutOfBoundsException("Empty list");

        return head.getElement();
    }

    public T getLast() {
        if(listSize == 0)
            throw new IndexOutOfBoundsException("Empty list");

        return tail.getElement();
    }

    public T get(int index){
        if(index < 0 || index >= listSize)
            throw new IndexOutOfBoundsException("Index out of bounds!");

        return getNode(index).getElement();
    }

    public void set(int index, T element){
        if(index < 0 || index >= listSize)
            throw new IndexOutOfBoundsException("Index out of bounds!");

        ListNode<T> currentNode = getNode(index);

        ListNode<T> previous = currentNode.getPrevious();
        ListNode<T> next = currentNode.getNext();

        ListNode<T> newNode = new ListNode<>(element, previous, next);

        if(previous != null)
            previous.setNext(newNode);
        else
            head = newNode;

        if(next != null)
            next.setPrevious(newNode);
        else
            tail = newNode;
    }

    public void removeFirst(){
        if(listSize == 0)
            throw new IndexOutOfBoundsException("Empty list");

        head = head.getNext();

        if(head != null)
            head.setPrevious(null);

        listSize--;
    }

    public void removeLast(){
        if(listSize == 0)
            throw new IndexOutOfBoundsException("Empty list");

        tail = tail.getPrevious();

        if(tail != null)
            tail.setNext(null);

        listSize--;
    }

    public void remove(int index){
        if(index < 0 || index >= listSize)
            throw new IndexOutOfBoundsException("Index out of bounds!");

        ListNode<T> node = getNode(index);

        ListNode<T> previous = node.getPrevious();
        ListNode<T> next = node.getNext();

        if(previous != null)
            previous.setNext(next);
        else
            head = next;

        if(next != null)
            next.setPrevious(previous);
        else
            tail = previous;

        listSize--;
    }

    public void remove(T element){

    }

    public int size(){
        return listSize;
    }

    public int indexOf(T element) {
        int i = 0;
        ListNode<T> currentNode = head;

        while(currentNode != null) {
            T listElement = currentNode.getElement();

            if(element == null) {
                if(listElement == null)
                    return i;
            } else if(element.equals(listElement))
                return i;

            currentNode = currentNode.getNext();
            i++;
        }

        return -1;
    }

    private ListNode<T> getNode(int index) {
        if(index < 0 || index >= listSize)
            throw new IndexOutOfBoundsException("Index out of bounds!");

        int i = 0;
        ListNode<T> currentNode = head;

        while(currentNode != null) {
            if(index == i)
                return currentNode;

            currentNode = currentNode.getNext();
            i++;
        }

        return null;
    }

    private ListNode<T> getNodeFromTail(int index) {

        return null;
    }

    private ListNode<T> getNodeFromHead(int index) {

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

}