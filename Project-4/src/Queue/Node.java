/*
 * Project 4
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/27/2022
 * Description: Simple Node Class to be used for the singly linked list
 */
package Queue;

public class Node {
    private Object item;
    Node next = null;


    public Node(Object newItem) {
        this.item = newItem;
    }
    public void setItem(int newItem) {
        this.item = newItem;
    }
    public void setNext(Node newNext) {
        this.next = newNext;
    }
    public Object getItem() {
        return this.item;
    }
    public Node getNext() {
        return this.next;
    }
}