package phonebook;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PhoneBook pb1 = new PhoneBook(new Person("Omar Salah", "4704994575"));
        pb1.add("A", "1234567891");
        pb1.add("b", "1234567891");
        pb1.add("c", "1234567891");
        pb1.add("y", "1234567891");
        pb1.add("x", "1234567891");
        pb1.add("z", "1234567891");
        pb1.displayContacts();
    }
}
