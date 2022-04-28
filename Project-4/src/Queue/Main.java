/*
 * Project 4
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/27/2022
 * Description: Main execution point of project 4 used to test all the functionality built into the ADTQueue
 */
package Queue;

public class Main {
    public static final String RESET = "\033[0m";  // Text color Reset
    public static final String RED = "\033[0;31m"; // RED text color
    public static final String GREEN = "\033[0;32m"; // Green text color

    public static void main(String[] args) {
	// write your code here
        int[] intArr = {1,2,3,4,5,6,7,8,9,10};
        char[] charArr = {'b','c','d','e','f'};
        ADTQueue q1 = new ADTQueue('a');
        ADTQueue q2 = new ADTQueue(intArr);

        System.out.println(GREEN);
        System.out.println("q1: ");
        q1.showQueue();
        System.out.println("q1 enqueue b, c, d, e, f");
        for(char a: charArr){
            q1.enqueue(a);
        }
        q1.showQueue();
        System.out.println("q1 dequeue returns: " + q1.dequeue());
        q1.showQueue();
        System.out.println("q1 dequeue returns: " + q1.dequeue());
        q1.showQueue();
        System.out.println("Clearing the whole Queue");
        q1.dequeueAll();
        q1.showQueue();


        System.out.println(RESET +"\n\n\n" + RED);


        System.out.println("q2: ");
        q2.showQueue();
        System.out.println("q2 dequeue returns: " + q2.dequeue());
        q2.showQueue();
        System.out.println("q2 dequeue returns: " + q2.dequeue());
        q2.showQueue();
        System.out.println("q2 enqueue 11 ");
        q2.enqueue(11);
        q2.showQueue();
        System.out.println("Clearing the whole Queue");
        q2.dequeueAll();
        q2.showQueue();
    }
}
