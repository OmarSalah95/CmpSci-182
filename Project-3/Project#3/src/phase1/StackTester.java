/*
 * Project 3 Phase 1
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: Driver function to test the functionality of phase 1 array based stack
 */
package phase1;

public class StackTester {

    public static void main(String[] args) {
        StackArrayBased stack = new StackArrayBased();

        for (int i = 1; i<4; i++) {
            for(int j = 0; j<i*50; j++){
                if(i==1){
                    stack.push(j);
                } else if(i>1){
                    stack.push(((i-1)*50)+j);
                }
            }
        }

        while (!stack.isEmpty())
        System.out.println(stack.pop());
    } 
}
