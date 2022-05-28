package phonebook;

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
        this.add(nam, num, this.root);
    }

    public void add(String nam, String num, Person cur){
        Person newP;

        if(nam.compareTo(cur.getName()) > 0){
            if(cur.getRight() == null){
                newP = new Person(nam,num);
                cur.setRight(newP);
                clearScreen();
                System.out.println("\n\n\n\n\n\n\nContact added");
            } else {
                add(nam, num, cur.getRight());
            }
        }else if(nam.compareTo(cur.getName()) < 0){
            if(cur.getLeft() == null){
                newP = new Person(nam,num);
                cur.setLeft(newP);
                System.out.println("\n\n\n\n\n\n\nContact added");
            } else {
                add(nam, num, cur.getRight());
            }
        } else {
            System.out.println("This contact already exists, try updating instead!");
        }
    }
//    Delete
//    Search
    public void displayContacts(){
        displayContacts(this.root);
    }
    public void displayContacts(Person cur){
        if (cur == null) return;
            displayContacts(cur.getLeft());
            cur.printInfo();
            displayContacts(cur.getRight());

    }
}
