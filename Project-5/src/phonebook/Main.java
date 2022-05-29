package phonebook;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PhoneBook pb1 = new PhoneBook();
        pb1.displayContacts();
//        pb1.displayPostorder();
//        pb1.displayPreorder();
        Person b = pb1.search("a");
        System.out.println("\n\n");
        b.printInfo();
    }
}
