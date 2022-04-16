/*
 * Project 3 Phase 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: Another stack data structure built on top of a linked list as opposed to an array
 */
package phase2;

public class StackReferenceBased
    implements StackInterface{
    public Node top;

    public StackReferenceBased() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Object newItem) {
        top = new Node((char)newItem, top);
    }

    public Object pop() throws StackException {
        if (!isEmpty()) {
            Node temp = top;
            top = top.next;
            return temp.getItem();
        } else {
            throw new StackException("StackException on " + "pop: stack empty");
        }
    }

    public void popAll() {
        top = null;
    }

    public Object peek() throws StackException {
        if (!isEmpty()) {
            return top.getItem();
        } else {
            throw new StackException("StackException on "
                    + "peek: stack empty");
        }
    }
}



         
    

