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

import java.util.InputMismatchException;
import java.util.*;



public class Menu {
    private PhoneBook pb;
    private Scanner scn;

    public Menu(){
        this.pb = new PhoneBook();
        this.scn  = new Scanner(System.in);
    }

    private void displayTimedMessage(String msg){
        String format = "~~~%1$-"+msg.length()+"s~~~";
        System.out.println("\n\n\n\n");
        System.out.printf(format,msg);
        System.out.println("\n\n\n\n");
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
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

            userInput = this.scn.nextInt();

            switch(userInput){
                case 1:
                    this.scn.nextLine();
                    System.out.println("\n\n\n\nPlease enter the new contacts name\n\n\n\n");
                    name = this.scn.nextLine();

                    System.out.println("\n\n\n\nPlease enter the new contacts number\n\n\n\n");
                    num = this.scn.nextLine();
                    pb.add(name, num);
                    displayTimedMessage("Contact Added!");
                    break;
                case 2:
                    pb.displayContacts();
                    break;
                case 3:
                    this.scn.nextLine();
                    System.out.println("\n\n\n\nPlease enter the name of the contact you would like to delete:\n\n\n\n");
                    name = this.scn.nextLine();
                    pb.delete(name);
                    displayTimedMessage("Contact deleted");
                    break;
                case 4:
                    this.scn.nextLine();
                    System.out.println("\n\n\n\nPlease enter name of the contact you would like to find\n\n\n\n");
                    name = this.scn.nextLine();
                    System.out.println("\n\n\n\n");
                    pb.search(name).printInfo();
                    System.out.println("\n\n\n\n");
                    break;
                case 5:
                    this.scn.nextLine();
                    System.out.println("\n\n\n\nPlease enter the contacts name who's number you would like to update\n\n\n\n");
                    name = this.scn.nextLine();
                    System.out.println("\n\n\n\nPlease enter the new contact number\n\n\n\n");
                    num = this.scn.nextLine();
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
