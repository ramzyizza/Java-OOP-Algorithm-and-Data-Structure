package Assignment_2;

import java.util.*;

/*
Create a program to reverse the order of a string of characters inserted by the user (eg
REVELATION -> NOITALEVER)
 */

public class reversed{
    public static void main(String[] args){
        //linked list implementation
        LinkedList<Character> words = new LinkedList<Character>();
        Scanner input = new Scanner(System.in); //input
        System.out.print("Enter the words you want to reverse: ");
        String word = input.nextLine();
        int size = word.length();
        
        for(int i = 0; i < size; i++){
            words.add(word.charAt(i)); //push string to linked list by char
        }
        for(int i = size-1; i >= 0; i--){
            System.out.print(words.get(i)); //sysout the reversed order
        }
    }
}