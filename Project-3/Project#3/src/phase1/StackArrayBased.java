/*
 * Project 3 Phase 1
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: Simple array based stack
 */
package phase1;

public class StackArrayBased implements StackInterface {

    int MAX_STACK = 50;
    private Object items[];
    private int top;

    public StackArrayBased() {
        items = new Object[MAX_STACK];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == MAX_STACK - 1;
    }

    public void push(Object newItem) throws StackException {
        if (isFull()) {
            this.MAX_STACK *= 2;
            Object temp_items[] = new Object[this.MAX_STACK];
            System.arraycopy(this.items, 0, temp_items, 0, this.items.length);
            this.items = temp_items;
        }
        items[++top] = newItem;
    }

    public void popAll() {
        items = new Object[MAX_STACK];
        top = -1;
    }

    public Object pop() throws StackException {
        if (!isEmpty()) {
            return items[top--];
        } else {
            throw new StackException("StackException on " + "pop: stack empty");
        }
    }

    public Object peek() throws StackException {
        if (!isEmpty()) {
            return items[top];
        } else {
            throw new StackException("Stack exception on " + "peek - stack empty");
        }
    }
}

