/*
 * Project 4
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/27/2022
 * Description: This will be a class used to create a queue based on references from a Singly Linked List
 */
package Queue;

public class ADTQueue {
    private Node head,
            tail;
    private int length = 0;

    public ADTQueue() {
        this.head = null;
        this.tail = null;
    }

    public ADTQueue(Object i) {
        Node firstNode = new Node(i);
        this.head = firstNode;
        this.tail = firstNode;
        this.length++;
    }

    public ADTQueue(int[] Arr) {
        Node newNode = new Node(Arr[0]);
        this.head = newNode;
        this.tail = newNode;
        this.length++;
        for(int i = 1; i<Arr.length; i++){
            newNode = new Node(Arr[i]);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.length++;
        }
    }

    public ADTQueue(char[] Arr) {
        Node newNode = new Node(Arr[0]);
        this.head = newNode;
        this.tail = newNode;
        this.length++;
        for(int i = 1; i<Arr.length; i++){
            newNode = new Node(Arr[i]);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.length++;
        }
    }

    public Object dequeue() {
        Object item = this.head.getItem();
        this.head = this.head.getNext();
        this.length--;
        return item;
    }

    public void enqueue(Object newItem) {
        Node newNode = new Node(newItem);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    public void showQueue(){
        if(this.length >0){
            String ret = "";
            Node cur = this.head;
            while(cur != null){
                ret += "<-" + cur.getItem();
                cur = cur.getNext();
            }
            System.out.println(ret);
        } else {
            System.out.println("Queue is empty");
        }
    }

    public void dequeueAll() {
        while(this.length!=0){
            this.dequeue();
        }
        if(this.head == null && this.length ==0){
            System.out.println("Queue is now empty!");
        }

    }

}