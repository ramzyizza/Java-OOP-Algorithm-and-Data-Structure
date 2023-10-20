package Assignment_2;

import java.util.*;

/*
Using an array, create a program that can add up all the numbers inserted by the user.
Note that the program will read the number of numbers to be inserted and the numbers
to be inserted. Do the same as the question above, but use a linked list.
 */

public class linkedList{
    public static void main(String[] args){
        int size, dataEntry; 
        LinkedList<Integer> list = new LinkedList<Integer>(); //linked list declaration
        Scanner input = new Scanner(System.in); //input

        System.out.print("Entered desired amount of number you want to sum: ");
        size = input.nextInt(); //size declaration
        
        //itterate input
        for(int i = 0; i < size; i++){
            System.out.print("Enter the number in consecutive order: ");
            dataEntry = input.nextInt(); //input
            list.add(dataEntry); //insert to linked list
        }
        int sum = 0;
        for(int j = 0; j < size; j++){
            sum += list.get(j); //itterate and sum
        }

        System.out.println("The total value of inserted integers is: " + sum);
    }
}