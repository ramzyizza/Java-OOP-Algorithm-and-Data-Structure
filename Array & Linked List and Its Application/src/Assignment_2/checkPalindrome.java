package Assignment_2;

import java.util.*;

/* 
Create a program that checks whether a string is a palindrome (a palindrome is a string
reads from the forward or backward, for example: TACOCAT)
*/

public class checkPalindrome{
    public static void main(String[] args){
        //linked list declaration
        LinkedList<Character> words = new LinkedList<Character>();
        Scanner input = new Scanner(System.in);
        //input
        System.out.print("Palindrome Checker : ");
        String word = input.nextLine();
        //size declaration
        int size = word.length();
        int front = 0;
        int back = size - 1;
        //itterate to check
        boolean ifPal = true;
        for(int i = 0; i < size; i++){
            words.add(word.charAt(i));
        }
        while(front <=  back){
            if(words.get(front) == words.get(back))
                ifPal = true;
            else{
                ifPal = false;
                break;
            }
            front++;
            back--;
        }
        if(ifPal == true)
            System.out.println("Palindrome");
        else
            System.out.println("NOT Palindrome");
    }
}