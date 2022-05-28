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

    public void printInfo(){
        System.out.println("-----------------------------------");
        System.out.println("Name: "+ this.name + "\nNumber: "+this.number);
    }


}
