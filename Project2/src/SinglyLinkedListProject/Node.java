/*
 * Project 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 3/19/2022
 * Description: Simple Node Class to be used for the singly linked list
 */
package SinglyLinkedListProject;

public class Node {
    public Node(String item){
        this.item = item;
        this.next = null;
    }
    private String item;
    private Node next;

    public String getItem(){
        return this.item;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node newNext){
        this.next = newNext;
    }

}
