package Lists;

public class ListNode<T> {

    private T element;

    private ListNode<T> previous;
    private ListNode<T> next;

    public ListNode(T element) {
        this.element = element;
    }

    public ListNode(T element, ListNode<T> previous, ListNode<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> node) {
        this.next = node;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

}
