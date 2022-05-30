package phonebook;

import java.util.Scanner;

public class Menu {
    private PhoneBook pb;

    public Menu(){
        this.pb = new PhoneBook();
    }

    public void run(){
        Scanner scn = new Scanner(System.in);
        String name,num;
        boolean running = true;
        int userInput;


        while(running){
            System.out.println("Menu");
            System.out.println("Please select a choice listed below(1-6)");
            System.out.println("1: Add Contact\n" +
                    "2: Display Contacts\n" +
                    "3: Delete Contact\n" +
                    "4: Find Contact\n" +
                    "5: Update Contact\n" +
                    "6: Quit");
            userInput = scn.nextInt();
            switch(userInput){
                case 1:
                    scn.nextLine();
                    System.out.println("Please enter the new contacts name");
                    name = scn.nextLine();

                    System.out.println("Please enter the new contacts number");
                    num = scn.nextLine();
                    pb.add(name, num);
                    break;
                case 2:
                    pb.displayContacts();
                    break;
                case 3:
                    System.out.println("Still need to implement delete");
                    scn.nextLine();
                    System.out.println("Please enter the name of the contact you would like to delete: ");
                    name = scn.nextLine();
//                    pb.searchParent(name);
                    pb.delete(name);
                    break;
                case 4:
                    scn.nextLine();
                    System.out.println("Please enter name of the contact you would like to find");
                    name = scn.nextLine();
                    pb.search(name).printInfo();
                    break;
                case 5:
                    scn.nextLine();
                    System.out.println("Please enter the contacts name who's number you would like to update");
                    name = scn.nextLine();
                    System.out.println("Please enter the new contact number");
                    num = scn.nextLine();
                    pb.updateNumber(name, num);
                    break;
                default:
                    System.out.println("Still needs to be fixed");
                    pb.save();
                    running = false;
                    break;
            }
        }
    }
}
