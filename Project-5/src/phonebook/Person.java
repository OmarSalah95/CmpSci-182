/*
 * Project 5
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 5/30/2022
 * Description: This is the Person class that will store a contacts information
 *      such as name and number, and will also function as a node in the BST
 *      storing references to a right and left child as well as all the
 *      functionality needed as a node in a BST.
 */
package phonebook;

public class Person {
    private String name;
    private String number;
    private Person right;
    private Person left;

    public Person(String nam, String num){
        this.setName(nam); // I did it this way so I don't have to re-write all the formatting
        this.setNumber(num); // Same as line above
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newNam){
        // I am going to clean up the new name by capitalizing all of the first letters

        // First we split the string of new name into an array with space as the delimiter
        String[] names = newNam.split(" ");
        // Reset the newNam variable passed to setName so we can use it as a temp
        //      and not need to write a new temp to memory
        newNam = "";
        // For each loop will take each word that was in our name, each string will now be
        //      nam
        for(String nam : names){
            // Add to our recently reset newNam string the word we just had
            //      with the first letter capitalized
            newNam +=  nam.substring(0, 1).toUpperCase() + nam.substring(1) + " ";
        }
        // This is so that we can simply strip the last space following the last word
        //      from our string so that we can use string comparison in other functions
        newNam = newNam.substring(0, newNam.length()-1);
        // Return the name with the first letter of each name capitalized
        this.name = newNam;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String newNum){
        // Just a simple regex replace to split up the incoming data and make
        //      it look nice before we store it in the Contact
        newNum = newNum.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "+1 ($1) $2-$3");
        this.number = newNum;
    }

    public Person getRight(){
        return this.right;
    }

    public void setRight(Person p){
        this.right = p;
    }

    public Person getLeft(){
        return this.left;
    }

    public void setLeft(Person p){
        this.left = p;
    }
    // Thought that I might need this when checking if a node is a parent
    //      returning a int depening on if it has no children, 1 left
    //      child, 1 right child, or both left and right children
    //      But my implementations dont need it so it is just extra
//    public int isParent(){
//        if(this.getLeft() == null && getRight() == null){
//            return 0;
//        }
//        if(this.getLeft() != null && this.getRight() == null){
//            return 1;
//        }
//        if(this.getLeft() == null && this.getRight() != null){
//            return 2;
//        }
//        if(this.getLeft() != null && this.getRight() != null){
//            return 3;
//        }
//        return 4;
//    }
    // Helper function to pretty print data stored in this contact
    public void printInfo(){
        System.out.println("-----------------------------------");
        System.out.println("Name: "+ this.name + "\nNumber: "+this.number);
    }
}
