/*
 * Project 5
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 5/30/2022
 * Description: This will be the basic Binary search tree and all included functionality
 *      to operate the BST that is storing Person's as nodes
 */
package phonebook;

import java.io.*;
import java.util.*;


public class PhoneBook {
    private Person root;

    public PhoneBook(){
        load(); // Default constructor will try to load data from "contacts.csv" immediately
    }

    public PhoneBook(Person p1){
        this.root = p1;
    } // Also not needed now, but was used in early testing

    // Recursion helper function mainly used to call the recursive add.
    public void add(String nam, String num){
        this.root = add(nam, num, this.root);
    }
    // Recursive add function
    private Person add(String nam, String num, Person cur)  {
        int flg;
            // If the cur person recieved is null, we are simply going to create a new person based
            //      off of their information and return that person
            if (cur == null) {
                cur = new Person(nam, num);
                return cur;
            }
            flg = nam.compareToIgnoreCase(cur.getName());
            // This would mean that our new contact belongs somewhere in the left subtree
            //      and we can recursively add them somewhere in there
            if (flg < 0)
                cur.setLeft(add(nam, num, cur.getLeft()));
            // This would mean that our current person belongs in the right subtree and we
            //      can recursively add them there
            else if (flg > 0)
                cur.setRight(add(nam,num, cur.getRight()));
            // This is basically our else, which is saying this person belongs right where they are
            //      and to add them here
            return cur;
    }

    public void delete(String name)
    {
        Person target = search(name); // Finding the node that is to be deleted
        // Our next inline will be depending on if the target has a no, left, right, or both subtrees
        //      If we have both, or just a left child we can simply find the max(Alphabetically last) person in the left
        //      subtree
        //      If we have a single child on the right, we can find the min(First alphabetically)
        //      in the right subtree
        //      If the target to be deleted has no children, i.e. is a leaf, then we have no successor
        //      So we can just assign it to null
        // So I went ahead and built all the logic in to find the successor to replace the parent node
        Person successor = target.getLeft() != null // Single child on the left or 2 children
                    ? findMax(target.getLeft())
                : target.getRight() != null // Single child on the right
                    ? findMin(target.getRight())
                : target; // No Children
        // We will need to know who the parent of the successor is, so that we can setLeft or Right
        //      to be null, i.e. dereference that node in particular, so we can search for them here
        Person successorParent = searchParent(successor.getName());

        // In any case the target is not a leaf node
        if(successor!=target){
            // Re-assign values for the node that is "deleted"
            // This is basically moving the leaf node that is the successor into the
            // predecessors position
            target.setName(successor.getName());
            target.setNumber(successor.getNumber());
            // Re assign the refrence to the leaf node to be null i.e. delete the leaf
            if( successorParent.getLeft() != null && successorParent.getLeft().getName().compareToIgnoreCase(successor.getName()) == 0) successorParent.setLeft(null);
            if( successorParent.getRight() != null && successorParent.getRight().getName().compareToIgnoreCase(successor.getName()) == 0) successorParent.setRight(null);
        } else {
            // If this case is triggered that would mean that the node being deleted is a leaf, and thus
            // we will simply assign the node to be deleted to be null
            if( successorParent.getLeft() != null && successorParent.getLeft().getName().compareToIgnoreCase(name) == 0) successorParent.setLeft(null);
            if( successorParent.getRight() != null && successorParent.getRight().getName().compareToIgnoreCase(name) == 0) successorParent.setRight(null);
        }
    }
    // Simple helper function to find the bottom right most node(Last alphabetically) in a sub-tree
    private Person findMax(Person cur){
        while (cur.getRight() != null){
            cur = cur.getRight();
        }
        return cur;
    }
    // Simple helper function to find the bottom leftt most node(first alphabetically) in a sub-tree
    private Person findMin(Person cur){
        while (cur.getLeft() != null){
            cur = cur.getLeft();
        }
        return cur;
    }
    // I dont actually need this after reading the specs more carefully, but it may come in handy
    //      If working on this again later
    public void updateName(String oName, String nName){
        Person p = search(oName);
        p.setName(nName);
        p.printInfo();
    }
    // Simply updates a users phone number
    public void updateNumber(String oName, String nNum){
        Person p = search(oName);
        p.setNumber(nNum);
        p.printInfo();
    }
    // Recursive helper function that calls the recursive search
    public Person search(String name){
        return search(name, this.root);
    }
    // Private recursive search since there is no need for this implementation to be used by a
    //      user, similar patterns follow for all recursive functions. Only Methods that will be
    //      used by the menu will be made public while all others will be made private as they
    //      are internal use only
    private Person search(String name, Person cur) {
        int flg = name.compareToIgnoreCase(cur.getName());
        // This means that the person we are looking for is somewhere in the left subtree so ea
        //      can recursively search there
        if (flg < 0 ){
            if(cur.getLeft()!=null){
                return search(name, cur.getLeft());
            } else{
                System.out.println("Contact Does not exist gone left");
            }
        }
        // This means our target is in the right subtree so we can recursively search there
        if (flg > 0){
            if( cur.getRight() != null){
                return  search(name, cur.getRight());
            } else {
                System.out.println("Contact not found in right");
            }
        }
        // This means that our current node, is in fact the target we are searching for so
        //      we can simply return it
        return cur;
    }
    // Simple recursive method similar to search that will find a parent given a name to look for
    //      This is mainly an internal function only used for deleting but may come in handy
    //      later
    public Person searchParent(String name){
        return searchParent(name, this.root);
    }
    // Recursive search for parent
    private Person searchParent(String name, Person cur) {
        int flg = name.compareToIgnoreCase(cur.getName());
        if (flg < 0 ){
            if(cur.getLeft()!=null){
                if(cur.getLeft().getName().compareToIgnoreCase(name) == 0) {
                    return cur;
                }
                return searchParent(name, cur.getLeft());
            }
        }

        if (flg > 0){
            if( cur.getRight() != null){
                if(cur.getRight().getName().compareToIgnoreCase(name) == 0) {
                    return cur;
                }
                return  searchParent(name, cur.getRight());
            }
        }
        return null;
    }
    // This method simply just reads data from a file, then parses that data into parameters
    //      that are then used to instantiate new person as they are being added to the phonebook
    private void load(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("contacts.csv"));
            String mystring;
            in.readLine(); // Read past the csv description headers
            while ((mystring = in.readLine()) != null) {
                String[] data = mystring.split(","); // Parse the data into a name(data[0]) & num(data[1])
                add(data[0], data[1]);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }

    // Simple method to save data to a file "contacts.csv" in Comma Separated Value format
    public void save(){
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("contacts.csv"));
            out.write("Name,Number\n");
            out.write(this.toString());
            out.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }
    // Recursive helper function to display contacts in alphabetical order
    public void displayContacts(){
        displayContacts(this.root);
    }
    // Recursive implementation of in-order traversal printing
    public void displayContacts(Person cur){
        if (cur == null) return;
            displayContacts(cur.getLeft());
            cur.printInfo();
            displayContacts(cur.getRight());
    }
    // Recursive helper function
    public void displayPreorder() {
        displayPreorder(this.root);
    }
    // Recursive implementation of pre-order traversal printing
    public void displayPreorder(Person cur) {
        if (cur == null) return;
        cur.printInfo();
        displayPreorder(cur.getLeft());
        displayPreorder(cur.getRight());
    }
    // Recursive helper function
    public void displayPostorder() {
        displayPreorder(this.root);
    }
    // Recursive implementation of post-order traversal printing
    public void displayPostorder(Person cur) {
        if (cur == null) return;
        displayPostorder(cur.getRight());
        cur.printInfo();
        displayPostorder(cur.getLeft());
    }

    @Override
    // This method is really mainly used just for saving data to a file
    //      The main purpose is to clean and remove duplicate entries while preserving
    //      the order (Since pre-order will form the most balanced tree) befor returning it
    //      as a string
    public String toString() {
        String temp = "";
        String[] dirtyString = stringifyTree(this.root, "").split("\n");
        Set<String> set = new LinkedHashSet<>();
        set.addAll(List.of(dirtyString));
        for(String str : set){
            temp += str + "\n";
        }
        return temp;
    }
    // Recursively creates a string that shows all the steps of traversal until ultimately ending
    //      in the pre-order display of all the contacts information formatted as it would be needed
    //      For saving. So all we really need to do is remove all of the duplicate entries in the string
    //      so this long string can be passed to toString which can then spit out a cleaned versoin
    //      without any dupes
    private String stringifyTree(Person cur, String prev){
        if(cur == null) return prev;
        prev += cur.getName() + "," + cur.getNumber() + "\n";
        prev += stringifyTree(cur.getLeft(), prev);
        prev += stringifyTree(cur.getRight(), prev);
        return prev;
    }
}
