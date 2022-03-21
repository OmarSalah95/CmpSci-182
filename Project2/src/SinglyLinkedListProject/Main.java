/*
 * Project 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 3/19/2022
 * Description: This is simply the driver class for testing the functionality of the linked list and its nodes.
 */
package SinglyLinkedListProject;

public class Main {
        public static final String RESET = "\033[0m";  // Text Reset
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";
        public static void testPassed(){
                System.out.println( GREEN +"Passed\n*************************************************" + RESET);
        }
        public static void testFailed(){
                System.out.println(RED + "Failed\n*************************************************" + RESET);
        }

    public static void main(String[] args) {
	// write your code here
            /* Test #1
             * Create a new ADTGroceryList object using the no-arg constructor.
             * This creates an empty ADTGroceryList object.
             */
            System.out.println("Test #1");
            ADTGroceryList groceryList1 = new ADTGroceryList();
            if(groceryList1.isEmpty()){
                    testPassed();
            }else{
                   testFailed();
            }
            System.out.println();

            /* Test #2
             * Test the add(index, item) method by adding six items,
             * milk, eggs, butter, apples, bread, chicken.
             * milk is at the head of groceryList1.
             */
            System.out.println("Test #2");
            groceryList1.add(0, "milk");
            groceryList1.add(1, "eggs");
            groceryList1.add(2, "butter");
            groceryList1.add(3, "apples");
            groceryList1.add(4, "bread");
            groceryList1.add(5, "chicken");
            if(groceryList1.get(0) == "milk" && groceryList1.get(1) == "eggs" && groceryList1.get(2) == "butter"
                    && groceryList1.get(3) == "apples" && groceryList1.get(4) == "bread" && groceryList1.get(5) == "chicken"){
                    testPassed();
            } else{
                    testFailed();
            }


            /* Test #3
             * Test the toString() method.
             * toString() should return a String containing the six items and
             * and their index numbers:
             * 0 milk
             * 1 eggs
             * 2 butter
             * 3 apples
             * 4 bread
             * 5 chicken
             */
            System.out.println("Test #3");
            String line=null;
            for(int i =0; i<groceryList1.size(); i++){
                    line +=  i +" " + groceryList1.get(i) + "\n";
            }
            // This test passes when I manually check it against the expected return, the issue in automating it is
            // just that I am not sure what the compiler is doing or how it is ultimately justifying it in the return,
            // otherwise these do indeed match. Maybe I can get some help to figure it out.
            if(groceryList1.toString() == line){
                    testPassed();
            } else {
                    testFailed();
            }


            /* Test #4
             * Test the remove() method.
             * remove(0) should remove the item at the head of groceryList1,
             * milk.  After removal, groceryList1 contains:
             * 0 eggs
             * 1 butter
             * 2 apples
             * 3 bread
             * 4 chicken
             */
            System.out.println("Test #4");
            groceryList1.remove(0);
            if(groceryList1.get(0) == "eggs" && groceryList1.get(1) == "butter"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #5
             * Test the remove() method again.
             * remove(3) should remove the item in index 3 of groceryList1,
             * bread.  After removal, the groceryList1 contains:
             * 0 eggs
             * 1 butter
             * 2 apples
             * 3 chicken
             */
            System.out.println("Test #5");
            groceryList1.remove(3);
            if(groceryList1.get(2) == "apples" && groceryList1.get(3) == "chicken" && groceryList1.get(4) == "Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #6
             * Test the remove() method again.
             * remove(3) should remove the item in index 3 of this groceryList1,
             * chicken.  After removal, the groceryList1 contains:
             * 0 eggs
             * 1 butter
             * 2 apples
             */
            System.out.println("Test #6");
            groceryList1.remove(3);
            System.out.println(groceryList1.get(3));
            if(groceryList1.size() == 3 && groceryList1.get(3) == "Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #7
             * Test the add() method again.
             * add(2) should insert the item in index 2 of groceryList1.
             * The item at index 2, apples "shifts" to index 3.  After adding,
             * groceryList1 contains:
             * 0 eggs
             * 1 butter
             * 2 potatoes
             * 3 apples
             */
            System.out.println("Test #7");
            groceryList1.add(2, "potatoes");
            if(groceryList1.get(1) == "butter" && groceryList1.get(2) == "potatoes" && groceryList1.get(3) == "apples"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #8
             * Test the add() method again.
             * add(1) should insert the item in index 1 of groceryList1.
             * The item at index 1, butter "shifts" to index 2.  After adding,
             * the groceryList1 contains:
             * 0 eggs
             * 1 tea
             * 2 butter
             * 3 potatoes
             * 4 apples
             */
            System.out.println("Test #8");
            groceryList1.add(1, "tea");
            if(groceryList1.get(0) == "eggs" && groceryList1.get(1) == "tea" && groceryList1.get(2) == "butter"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #9
             * Test the add() method again.
             * add(0) should insert the item in index 0 of groceryList1.
             * The item at index 0, eggs "shifts" to index 1.  After adding,
             * groceryList1 contains:
             * 0 distilled water
             * 1 eggs
             * 2 tea
             * 3 butter
             * 4 potatoes
             * 5 apples
             */
            System.out.println("Test #9");
            groceryList1.add(0, "distilled water");
            if(groceryList1.get(0) == "distilled water" && groceryList1.get(1) == "eggs" && groceryList1.get(2) == "tea"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #10
             * Test the add() method again.
             * add(6) should insert the item in index 6 of groceryList1.
             * This addition causes no "shifting" as the new item is added at the
             * tail of this groceryList1.  After adding, groceryList1 contains:
             * 0 distilled water
             * 1 eggs
             * 2 tea
             * 3 butter
             * 4 potatoes
             * 5 apples
             * 6 coffee
             */
            System.out.println("Test #10");
            groceryList1.add(6, "coffee");
            if(groceryList1.get(5) == "apples" && groceryList1.get(6) == "coffee" ){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #11
             * Test the add() method again.
             * add(7) should insert the item in index 7 of groceryList1.
             * This addition causes no "shifting" as the new item is added at the
             * tail of groceryList1.  After adding, groceryList1 contains:
             * 0 distilled water
             * 1 eggs
             * 2 tea
             * 3 butter
             * 4 potatoes
             * 5 apples
             * 6 coffee
             * 7 celery
             */
            System.out.println("Test #11");
            groceryList1.add(7, "celery");
            if(groceryList1.get(6) == "coffee" && groceryList1.get(7) == "celery" ){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #12
             * Test the add() method again.
             * add(4) should insert the item in index 4 of groceryList1.
             * The item at index 4, potatoes "shifts" to index 5.  After
             * adding, groceryList1 contains:
             * 0 distilled water
             * 1 eggs
             * 2 tea
             * 3 butter
             * 4 lettuce
             * 5 potatoes
             * 6 apples
             * 7 coffee
             * 8 celery
             */
            System.out.println("Test #12");
            groceryList1.add(4, "lettuce");
            if(groceryList1.get(3) == "butter" && groceryList1.get(4) == "lettuce" && groceryList1.get(5) == "potatoes"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #13
             * Test the add() method again.
             * add(7) should insert the item in index 7 of groceryList1.
             * The item at index 7, coffee "shifts" to index 8.  After adding,
             * groceryList1 contains:
             * 0 distilled water
             * 1 eggs
             * 2 tea
             * 3 butter
             * 4 lettuce
             * 5 potatoes
             * 6 apples
             * 7 radish
             * 8 coffee
             * 9 celery
             */
            System.out.println("Test #13");
            groceryList1.add(7, "radish");
            if(groceryList1.get(6) == "apples" && groceryList1.get(7) == "radish" && groceryList1.get(8) == "coffee"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #14
             * Test the isEmpty() method.
             * isEmpty() should return false.
             */
            System.out.println("Test #14");
            if(!groceryList1.isEmpty()){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #15
             * Test the size() method.
             * size() should return 10.
             */
            System.out.println("Test #15");
            if(groceryList1.size() == 10){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #16
             * Test the get() method using a loop.
             * The 10 items in groceryList1 should be displayed by this loop:
             * distilled water
             * eggs
             * tea
             * butter
             * lettuce
             * potatoes
             * apples
             * radish
             * coffee
             * celery
             */
            System.out.println("Test #16");
            boolean result =true;
            String current;
            for(int i = 0; i < groceryList1.size(); i++) {
                    current = groceryList1.get(i);
                    switch (i){
                            case 0:
                                    if(current != "distilled water"){
                                            result = false;
                                    }
                                    break;
                            case 1:
                                    if(current != "eggs"){
                                            result = false;
                                    }
                                    break;
                            case 2:
                                    if(current != "tea"){
                                            result = false;
                                    }
                                    break;
                            case 3:
                                    if(current != "butter"){
                                            result = false;
                                    }
                                    break;
                            case 4:
                                    if(current != "lettuce"){
                                            result = false;
                                    }
                                    break;
                            case 5:
                                    if(current != "potatoes"){
                                            result = false;
                                    }
                                    break;
                            case 6:
                                    if(current != "apples"){
                                            result = false;
                                    }
                                    break;
                            case 7:
                                    if(current != "radish"){
                                            result = false;
                                    }
                                    break;
                            case 8:
                                    if(current != "coffee"){
                                            result = false;
                                    }
                                    break;
                            default:
                                    if(current != "celery"){
                                            result = false;
                                    }
                                    break;
                    }
            }

            if(result){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #17
             * Test the get() method by invoking it with an invalid index of -1.
             * groceryList1.get(-1) should return an empty String.
             */
            System.out.println("Test #17");
            if(groceryList1.get(-1) == "Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }


            /* Test #18
             * Test the get() method by invoking it with an invalid index of 10.
             * groceryList1.get(10) should return an empty String.
             */
            System.out.println("Test #18");
            if(groceryList1.get(10) == "Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }


            /* Test #19
             * Test the remove() method using a loop.
             * The following loop will invoke the remove() method size() number
             * of times, removing the item at the head of the list each time.
             * At the end of the loop, groceryList1 should be empty and
             * isEmpty() should return true.
             */
            System.out.println("Test #19");
            int listSize = groceryList1.size();
            for(int i = 0; i < listSize; i++) {
                groceryList1.remove(0);
            }
            if(groceryList1.isEmpty()){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #20
             * Test the ADTGroceryList(String[] listItems) constructor overload by
    creating
             * an array of 20 food item names, then passing this array to
             * the ADTGroceryList(String[] listItems) constructor.  After this test,
    the
             * groceryList2 object should contain the 20 items.
             */
            System.out.println("Test #20");
            String[] listItems = {"peanut butter", "succotash", "fennel seeds",
                    "ginger ale", "almond butter", "okra", "blue cheese",
                    "five-spice powder", "vegemite", "mozzarella", "baking powder",
                    "breadfruit", "squid", "ale", "panko bread crumbs", "tortelini",
                    "sugar", "salt", "maraschino cherries", "pears"};
            System.out.println();
            ADTGroceryList groceryList2 = new ADTGroceryList(listItems);
            // This should be another issue, similar to that we checked in test 3 where I can not be sure of what the return
            // looks like exactly to test against. One thing I can do is similar to test 16 with stich cases but this.

            for(int i = 0; i < groceryList1.size(); i++) {
                    current = groceryList1.get(i);
                    switch (i){
                            case 0:
                                    if(current != "peanut butter"){
                                            result = false;
                                    }
                                    break;
                            case 1:
                                    if(current != "succotash"){
                                            result = false;
                                    }
                                    break;
                            case 2:
                                    if(current != "fennel seeds"){
                                            result = false;
                                    }
                                    break;
                            case 3:
                                    if(current != "ginger ale"){
                                            result = false;
                                    }
                                    break;
                            case 4:
                                    if(current != "almond butter"){
                                            result = false;
                                    }
                                    break;
                            case 5:
                                    if(current != "okra"){
                                            result = false;
                                    }
                                    break;
                            case 6:
                                    if(current != "blue cheese"){
                                            result = false;
                                    }
                                    break;
                            case 7:
                                    if(current != "five-spice powder"){
                                            result = false;
                                    }
                                    break;
                            case 8:
                                    if(current != "vegemite"){
                                            result = false;
                                    }
                                    break;
                            case 9:
                                    if(current != "mozzarella"){
                                            result = false;
                                    }
                                    break;
                            case 10:
                                    if(current != "baking powder"){
                                            result = false;
                                    }
                                    break;
                            case 11:
                                    if(current != "breadfruit"){
                                            result = false;
                                    }
                                    break;
                            case 12:
                                    if(current != "squid"){
                                            result = false;
                                    }
                                    break;
                            case 13:
                                    if(current != "ale"){
                                            result = false;
                                    }
                                    break;
                            case 14:
                                    if(current != "panko bread crumbs"){
                                            result = false;
                                    }
                                    break;
                            case 15:
                                    if(current != "tortelini"){
                                            result = false;
                                    }
                                    break;
                            case 16:
                                    if(current != "sugar"){
                                            result = false;
                                    }
                                    break;
                            case 17:
                                    if(current != "salt"){
                                            result = false;
                                    }
                                    break;
                            case 18:
                                    if(current != "maraschino cherries"){
                                            result = false;
                                    }
                                    break;
                            default:
                                    if(current != "pears"){
                                            result = false;
                                    }
                                    break;
                    }
            }

            if(result){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #21
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an invalid index number, add(-1, grapes).  The ADT
             * should output an error message "-1 is an invalid index number
             * for the item grapes".  groceryList2.toString() should show that
             * the item was NOT added to groceryList2.
             */
            System.out.println("Test #21");
            groceryList2.add(-1, "grapes");
            if(groceryList2.get(-1) =="Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #22
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an invalid index number, add(-100, grapes).  The ADT
             * should output an error message "-100 is an invalid index number
             * for the item grapes".  groceryList2.toString() should show that
             * the item was NOT added to groceryList2.
             */
            System.out.println("Test #22");
            groceryList2.add(-100, "grapes");
            if(groceryList2.get(-100) =="Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #23
             * Test the add() method on the groceryList2 object by adding an item
             * at index 0 of the list, add(0, grapes).  groceryList2.toString()
             * should show that the item is added to the list at index 0.
             */
            System.out.println("Test #23");
            groceryList2.add(0, "grapes");
            if(groceryList2.get(0) =="grapes" && groceryList2.get(1) == "peanut butter" ){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #24
             * Test the remove() method on the groceryList2 object by removing the
             * item at index 0 of the list, remove(0).  groceryList2.toString()
             * should show that the item at index 0 is removed from the list.
             */
            System.out.println("Test #24");
            groceryList2.remove(0);
            if(groceryList2.get(0) =="peanut butter" && groceryList2.get(1) == "succotash"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #25
             * Test the add() method on the groceryList2 object by adding an item
             * at index 1 of the list, add(1, grapes).  groceryList2.toString()
             * should show that the item is added to the list at index 1.
             */
            System.out.println("Test #25");
            groceryList2.add(1, "grapes");
            if(groceryList2.get(0) =="peanut butter" && groceryList2.get(1) == "grapes" && groceryList2.get(2) == "succotash"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #26
             * Test the remove() method on the groceryList2 object by removing the
             * item at index 1 of the list, remove(1).  groceryList2.toString()
             * should show that the item at index 1 is removed from the list.
             */
            System.out.println("Test #26");
            groceryList2.remove(1);
            if(groceryList2.get(0) =="peanut butter" && groceryList2.get(1) == "succotash"&& groceryList2.get(2) == "fennel seeds"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #27
             * Test the add() method on the groceryList2 object by adding an item at
             * index 19 of the list, add(19 grapes).  groceryList2.toString() should
             * show that the item is added to the list at index 19.
             */
            System.out.println("Test #27");
            groceryList2.add(19, "grapes");
            if(groceryList2.get(18) =="maraschino cherries" && groceryList2.get(19) == "grapes"&& groceryList2.get(20) == "pears"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #28
             * Test the remove() method on the groceryList2 object by removing the
             * item at index 19 of the list, remove(19).  groceryList2.toString()
             * should show that the item at index 19 is removed from the list.
             */
            System.out.println("Test #28");
            groceryList2.remove(1);
            if(groceryList2.get(0) == "peanut butter" && groceryList2.get(1) =="fennel seeds" && groceryList2.get(2) =="ginger ale"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #29
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an index number which is equal to the current size
             * of the list, add(20, grapes).  groceryList2.toString() should show
             * that the item is added to the tail of the list.
             */
            System.out.println("Test #29");
            groceryList2.add(20, "grapes");
            if(groceryList2.get(20) =="grapes" && groceryList2.get(19) == "pears"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #30
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an index number which is greater than the current
             * size of the list, add(100, honey).  The ADT should output an error
             * message "100 is an invalid index number for the item honey".
             */
            System.out.println("Test #30");
            groceryList2.add(100, "honey");
            if(groceryList2.get(100) =="Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #31
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an index number which is greater than the current
             * size of the list, add(22, honey).  The ADT should output an error
             * message "22 is an invalid index number for the item honey".
             */
            System.out.println("Test #31");
            groceryList2.add(22, "honey");
            if(groceryList2.get(22) =="Please enter a valid index."){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #32
             * Test the add() method on the groceryList2 object by attempting to
             * add an item with an index number which is equal to the current
             * size of the list, add(21, honey).  groceryList2.toString() should
             * show that the item is added to the tail of the list.
             */
            System.out.println("Test #32");
            groceryList2.add(21, "honey");
            if(groceryList2.get(21) == "honey"){
                    testPassed();
            }else{
                    testFailed();
            }

            /* Test #33
             * Test the removeAll() method on the groceryList2 object.  After all
             * items have been removed, groceryList2.isEmpty() should return true,
             * groceryList2.size() should return 0 and groceryList2.toString()
             * should return an empty String.
             */
            System.out.println("Test #33");
            groceryList2.removeAll();
            if(groceryList2.size() == 0 && groceryList2.isEmpty() && groceryList2.toString()==""){
                    testPassed();
            }else{
                    testFailed();
            }

        }
    }

