/*
 * Project 3 Phase 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: Simple Node Class to be used for the singly linked list
 */
package phase2;

public class Node {
    private char item;
    Node next;
   
    public Node(char newItem) {
        setItem(newItem);
        next = null;
    }
    public Node(char newItem, Node newNext) {
        setItem(newItem);
        setNext(newNext);    
    }
    public void setItem(char newItem) {
        item = newItem;
    }
    public void setNext(Node newNext) {
        next = newNext;
    }
    public char getItem() {
        return item;
    }
    public Node getNext() {
        return next;
    }
}
    


    

