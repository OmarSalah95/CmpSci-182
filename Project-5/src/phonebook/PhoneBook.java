package phonebook;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.TimeUnit;

public class PhoneBook {
    private Person root;

    public PhoneBook(Person p1){
        this.root = p1;
    }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

//    Save
//    Load


    public void add(String nam, String num){
        this.root = add(nam, num, this.root);
    }

    public Person add(String nam, String num, Person cur)  {
        Person newP;

            if (cur == null) {
                cur = new Person(nam, num);
                System.out.println("\n\n\n\nContact added\n\n\n\n");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                clearScreen();
                return cur;
            }

            if (nam.compareToIgnoreCase(cur.getName()) < 0)
                cur.setLeft(add(nam, num, cur.getLeft()));
            else if (nam.compareToIgnoreCase(cur.getName()) > 0)
                cur.setRight(add(nam,num, cur.getRight()));
            return cur;

    }
//    Delete
//    Search
    public Person search(String name){
        return search(name, this.root);
    }

    public Person search(String name, Person cur) {
        if (name.compareToIgnoreCase(cur.getName()) < 0 && cur.getLeft() != null)
                 return search(name, cur.getLeft());
        if (name.compareToIgnoreCase(cur.getName()) > 0 && cur.getRight() != null)
                return  search(name, cur.getRight());
        return cur;
    }

    public void displayContacts(){
        displayContacts(this.root);
    }

    public void displayContacts(Person cur){
        if (cur == null) return;
            displayContacts(cur.getLeft());
            cur.printInfo();
            displayContacts(cur.getRight());

    }
    public void displayPreorder() {
        displayPreorder(this.root);
        System.out.println();
    }

    public void displayPreorder(Person cur) {
        if (cur == null) return;

        cur.printInfo();
        displayPreorder(cur.getLeft());
        displayPreorder(cur.getRight());

    }

    public void displayPostorder() {
        displayPreorder(this.root);
    }

    public void displayPostorder(Person cur) {
        if (cur == null) return;
        displayPostorder(cur.getRight());
        cur.printInfo();
        displayPostorder(cur.getLeft());

    }
}
