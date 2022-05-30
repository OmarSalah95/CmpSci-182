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
    private String name = "";
    private String number = "";
    private Person right = null;
    private Person left = null;

    public Person(String nam, String num){
        this.setName(nam);
        this.setNumber(num);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newNam){
        String[] names = newNam.split(" ");
        newNam = "";
        for(String nam : names){
            newNam +=  nam.substring(0, 1).toUpperCase() + nam.substring(1) + " ";
        }
        newNam = newNam.substring(0, newNam.length()-1);
        this.name = newNam;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String newNum){
        newNum = newNum.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "+1($1) $2-$3");
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

    public int isParent(){
        if(this.getLeft() == null && getRight() == null){
            return 0;
        }
        if(this.getLeft() != null && this.getRight() == null){
            return 1;
        }
        if(this.getLeft() == null && this.getRight() != null){
            return 2;
        }
        if(this.getLeft() != null && this.getRight() != null){
            return 3;
        }
        return 2;
    }


    public void printInfo(){
        System.out.println("-----------------------------------");
        System.out.println("Name: "+ this.name + "\nNumber: "+this.number);
    }


}
