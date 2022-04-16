/*
 * Project 3 Phase 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: Just an interface of functions to be used to extend other classes and implemented in those subsequent classes
 */
package phase2;

import phase1.StackException;

public interface StackInterface { 
    public boolean isEmpty();
    //Determines whether the stack is empty.
    //Precondition: None.
    //Postcondition: Returns true if the stack is empty;
    //otherwise returns false.
public void popAll();
    //Removes all the items from the stack. 
    //Precondition: None.
    //Postcondition : Stack is empty.
public void push(Object newitem) throws StackException; 
    //Adds an item to the top of a stack.
    //Precondition: newitem is the item to be added.
    //Postcondition : If insertion is successful, newitem 
    //is on the top of the stack.
    //Exception: Some implementations may throw
    //StackException when newitem cannot be placed on the stack.
public Object pop() throws StackException;
    //Removes the top of a stack.
    //Precondition: None.
    //Postcondition: If the stack is not empty, the item 
    //that was added most recently is removed from the
    //stack and returned.
    //Exception: Throws StackException if the stack is 
    //empty.
public Object peek() throws StackException;
    //Retrieves the top of a stack.
    //Precondition: None.
    //Postcondition: If the stack is not empty, the item 
    //that was added most recently is returned. The
    //stack is unchanged.
    //Exception: Throws StackException if the stack is II empty.
} // end Stackinterface
    
    

