package phonebook;

import java.io.*;

public class PhoneBook {
    private Person root;

    public PhoneBook(){
        load();
    }

    public PhoneBook(Person p1){
        this.root = p1;
    }

    public void clearScreen(){
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
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                clearScreen();
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

//        delete(name, this.root);

        Person target = search(name); // Finding the node that is to be deleted
        Person nextInLine = target.getLeft() != null // Single child or 2 children
                ? findMax(target.getLeft())
                : target.getRight() != null // Single child on the left
                    ? findMin(target.getRight())
                : null; // No Children

        if(nextInLine!=null){
            // Re-assign values for the node that is "deleted"
            // This is basically moving the leaf node that is the successor into the
            // predecessors position
            target.setName(nextInLine.getName());
            target.setNumber(nextInLine.getNumber());


            // Re assign the refrence to the leaf node to be null i.e. delete the leaf
            nextInLine = null; // I think this is where my problem is

        } else {
            // If this case is triggered that would mean that the node being deleted is a leaf, and thus
            // we will simply assign the node to be deleted to be null
            target = nextInLine; // Issue here too
        }


    }


//    private Person delete(String target, Person cur)
//    {
//        int flg;
//        Person max;
//        if (cur == null) return null;
//        flg = target.compareToIgnoreCase(cur.getName());
//        //Traverse until the target node is found
//        if (flg < 0) cur.setLeft(delete(target, cur.getLeft()));
//        if (flg > 0) cur.setRight(delete(target, cur.getRight()));
//
//            // case 3: Target has 2 children
//            if (cur.getLeft() != null && cur.getRight() != null) {
//                max = findMax(cur.getLeft());
//                cur.setName(max.getName());
//                cur.setNumber(max.getNumber());
//                cur.setLeft(delete(max.getName(), cur.getLeft()));
//                return cur;
//            }
//            //case 2: Target has one child
//            if (cur.getLeft() != null) return cur.getLeft();
//            if (cur.getRight() != null) return cur.getRight();
//
//            //case 1: Target has no children
//            if(cur.getRight() == null && cur.getLeft() == null) return null;
//
//            return cur;
//    }

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
//    public void delete(String name){
////        Person target = search(name);
////        System.out.println(target.isParent());
////        if(target.isParent() == 0) {
////            System.out.println("if triggered");
////            target = null;
////        }
//
//
//    }

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

    public Person search(String name, Person cur) {
        int flg = name.compareToIgnoreCase(cur.getName());
        if (flg < 0 ){
            if(cur.getLeft()!=null){
                return search(name, cur.getLeft());
            } else{
                System.out.println("Contact Does not exist gone left");
                return cur;
            }
        }

        if (flg > 0){
            if( cur.getRight() != null){
                return  search(name, cur.getRight());
            } else {
                System.out.println("Contact not found in right");
                return cur;
            }
        }

        return cur;
    }

    public void load(){
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

    public void save(Person cur){
        if(cur == null) return;
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("contacts.csv"));
            out.write("Name,Number\n");
            if(cur.getLeft()!= null) save(cur.getLeft());
            out.write(cur.getName() +","+cur.getNumber()+ "\n");
            if(cur.getRight()!=null) save(cur.getRight());
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
}
