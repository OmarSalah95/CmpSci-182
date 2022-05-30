/*
 * Project 5
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 5/30/2022
 * Description: This will be the basic Binary search tree and all included functionality
 *      to operate the BST that is storing Person's as nodes
 *
 */
package phonebook;

import java.io.*;
import java.util.*;


public class PhoneBook {
    private Person root;

    public PhoneBook(){
        load();
    }

    public PhoneBook(Person p1){
        this.root = p1;
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void add(String nam, String num){
        this.root = add(nam, num, this.root);
    }

    public Person add(String nam, String num, Person cur)  {
        int flg;
            if (cur == null) {
                cur = new Person(nam, num);
                System.out.println("\n\n\n\nContact added\n\n\n\n");
                return cur;
            }
            flg = nam.compareToIgnoreCase(cur.getName());
            if (flg < 0)
                cur.setLeft(add(nam, num, cur.getLeft()));
            else if (flg > 0)
                cur.setRight(add(nam,num, cur.getRight()));
            return cur;
    }

    public void delete(String name)
    {
        Person target = search(name); // Finding the node that is to be deleted
        Person successor = target.getLeft() != null // Single child on the left or 2 children
                    ? findMax(target.getLeft())
                : target.getRight() != null // Single child on the right
                    ? findMin(target.getRight())
                : target; // No Children
        Person successorParent = searchParent(successor.getName());

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

    private Person findMax(Person cur){
        while (cur.getRight() != null){
            cur = cur.getRight();
        }
        return cur;
    }

    private Person findMin(Person cur){
        while (cur.getLeft() != null){
            cur = cur.getLeft();
        }
        return cur;
    }

    public void updateName(String oName, String nName){
        Person p = search(oName);
        p.setName(nName);
        p.printInfo();
    }

    public void updateNumber(String oName, String nNum){
        Person p = search(oName);
        p.setNumber(nNum);
        clearScreen();
        p.printInfo();
    }

    public Person search(String name){
        return search(name, this.root);
    }

    private Person search(String name, Person cur) {
        int flg = name.compareToIgnoreCase(cur.getName());
        if (flg < 0 ){
            if(cur.getLeft()!=null){
                return search(name, cur.getLeft());
            } else{
                System.out.println("Contact Does not exist gone left");
            }
        }

        if (flg > 0){
            if( cur.getRight() != null){
                return  search(name, cur.getRight());
            } else {
                System.out.println("Contact not found in right");
            }
        }
        return cur;
    }

    public Person searchParent(String name){
        return searchParent(name, this.root);
    }

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
        System.out.println("Case triggered returning the item searched for"); // Should never be triggered
        return null;
    }

    private void load(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("contacts.csv"));
            String mystring;
            in.readLine();
            while ((mystring = in.readLine()) != null) {
                String[] data = mystring.split(",");
                add(data[0], data[1]);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }

    public void save(){
        save(this.root);
    }

    private void save(Person cur){
        if(cur == null) return;
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

    public void displayContacts(){
        clearScreen();
        displayContacts(this.root);
    }

    public void displayContacts(Person cur){
        if (cur == null) return;
            displayContacts(cur.getLeft());
            cur.printInfo();
            displayContacts(cur.getRight());
    }

    public void displayPreorder() {
        clearScreen();
        displayPreorder(this.root);
    }

    public void displayPreorder(Person cur) {
        if (cur == null) return;
        cur.printInfo();
        displayPreorder(cur.getLeft());
        displayPreorder(cur.getRight());
    }

    public void displayPostorder() {
        clearScreen();
        displayPreorder(this.root);
    }

    public void displayPostorder(Person cur) {
        if (cur == null) return;
        displayPostorder(cur.getRight());
        cur.printInfo();
        displayPostorder(cur.getLeft());
    }

    @Override
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

    private String stringifyTree(Person cur, String prev){
        if(cur == null) return prev;
        prev += cur.getName() + "," + cur.getNumber() + "\n";
        prev += stringifyTree(cur.getLeft(), prev);
        prev += stringifyTree(cur.getRight(), prev);
        return prev;
    }

}
