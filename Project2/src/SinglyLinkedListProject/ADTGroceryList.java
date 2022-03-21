/*
 * Project 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 3/19/2022
 * Description: This will be the grocery list object and all attached
 */

package SinglyLinkedListProject;

public class ADTGroceryList {
   public ADTGroceryList(){
        this.head = null;
        this.size = 0;
    }
    public ADTGroceryList(String[] listItems){
       Node current = new Node(listItems[0]);
       this.head = current;
       this.size +=1;
       for(int i = 1; i< listItems.length; i++){
               Node newNode = new Node(listItems[i]); // Create a new Node
               current.setNext(newNode); // set the last node next attribute to the newlyCreated node
               current = newNode; // Step forward in the list
               this.size += 1;
        }
    }

    private Node head;
    private int size;

    public String get(int index){
        Node current = this.head;
        if(index>=0 && index<this.size){
            if(index == 0){
                return current.getItem();
            }else{
                for(int i = 1; i <= index; i++){
                    current = current.getNext();
                }
                return current.getItem();
            }
        }else {
            return "Please enter a valid index.";
        }

    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        } else{
            return false;
        }
    }

    public void add(int index, String item){
        Node current = this.head;
        Node newNode = new Node(item);
        if(index >=0 && index<=this.size){
            if(index ==0){
                this.head = newNode;
                this.head.setNext(current);
                this.size++;
            } else if(index < this.size){
                Node temp;
                for(int i = 0; i< index -1; i++){
                    current=current.getNext();
                }
                temp = current.getNext();
                current.setNext(newNode);
                current.getNext().setNext(temp);
                this.size++;
            } else{
                while(current.getNext()!= null){
                    current = current.getNext();
                }
                current.setNext(newNode);
                this.size++;
            }
        } else{
            System.out.println("Please enter a valid index to add this new node");
        }

    }

    public void remove(int index){
        Node current = this.head;
        if(index >= 0 && index<size){
            if(index == 0){
                this.head=current.getNext();
                size--;
            } else{
                for(int i=0; i < index-1; i++){
                    current = current.getNext();
                }
                current.setNext(current.getNext().getNext());
                size--;
            }
        }else{
            System.out.println("Please enter a valid index to remove.");
        }
    }

    public void removeAll(){
        Node next = null;
        while(this.head!=null){
            next = this.head.getNext();
            this.head = null;
            this.head = next;
            this.size -=1;
        }
        System.out.println("All nodes deleted from Linked List");
    }
    public String toString(){
        Node current = this.head;
        if(current == null){
            return "";
        }
        String line="0 "+ this.get(0)+ "\n";
        for(int i =1; i<this.size; i++){
            line +=  i +" " + this.get(i) + "\n";
        }
        return line;
    }
}
