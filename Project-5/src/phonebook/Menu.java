/*
 * Project 5
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 5/30/2022
 * Description: This is the main menu driver that takes the users inputs to search
 *      and operate the Phonebook Binary Tree allowing users to add, delete,
 *      display, update, and search contacts
 */
package phonebook;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    private PhoneBook pb;

    public Menu(){
        this.pb = new PhoneBook();
    }

    private void displayTimedMessage(String msg){
        String format = "~~~%1$-"+msg.length()+"s~~~";
        System.out.println("\n\n\n\n");
        System.out.printf(format,msg);
        System.out.println("\n\n\n\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                    System.out.println("\n\n\n\nPlease enter the new contacts name\n\n\n\n");
                    name = scn.nextLine();

                    System.out.println("\n\n\n\nPlease enter the new contacts number\n\n\n\n");
                    num = scn.nextLine();
                    pb.add(name, num);
                    displayTimedMessage("Contact Added!");
                    break;
                case 2:
                    pb.displayContacts();
                    break;
                case 3:
                    scn.nextLine();
                    System.out.println("Please enter the name of the contact you would like to delete: ");
                    name = scn.nextLine();
                    pb.delete(name);
                    displayTimedMessage("Contact deleted");
                    break;
                case 4:
                    scn.nextLine();
                    System.out.println("Please enter name of the contact you would like to find");
                    name = scn.nextLine();
                    System.out.println("\n\n\n\n");
                    pb.search(name).printInfo();
                    System.out.println("\n\n\n\n");
                    break;
                case 5:
                    scn.nextLine();
                    System.out.println("Please enter the contacts name who's number you would like to update");
                    name = scn.nextLine();
                    System.out.println("Please enter the new contact number");
                    num = scn.nextLine();
                    pb.updateNumber(name, num);
                    displayTimedMessage("Contact Updated");
                    break;
                default:
                    pb.save();
                    displayTimedMessage("Data stored");
                    running = false;
                    break;
            }
        }
    }
}
