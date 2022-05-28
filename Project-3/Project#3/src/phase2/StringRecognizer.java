/*
 * Project 3 Phase 2
 * Class: CmpSci-182/L
 * Developer: Omar Salah
 * Date: 4/12/2022
 * Description: This is simply the driver class for testing the functionality of the array based stack
 */
package phase2;

public class StringRecognizer {

    public static void main(String[] args) {
            String str1 = "ABC$CBA";
            String str2 = "ABC$ABC";
            String str3 = "RACECAR$RACECAR";

            testPalindrome(str1);
            testPalindrome(str2);
            testPalindrome(str3);
        }

    public static void testPalindrome(String str){
        StackReferenceBased aStack = new StackReferenceBased();
        int i = 0;
        boolean inLanguage = true;
        char ch = str.charAt(i);

        while(ch != '$') {
            aStack.push(ch);
            ch = str.charAt(++i);
        }

        i++;

        while (inLanguage && i < str.length())
        {
            try
            {
                ch = str.charAt(i);
                if((char)aStack.pop() != ch) {
                    inLanguage = false;
                } else{
                    i++;
                }
            }
            catch (StackException e) {
                inLanguage = false;
            }
        }

        if (inLanguage && aStack.isEmpty()) {
            System.out.println(str + " is in language");
        } else {
            System.out.println(str + " is not in language");
        }
    }
}
    

