package Assignment_2;

import java.util.*; //input package included

/*
Using an array, create a program that can add up all the numbers inserted by the user.
Note that the program will read the number of numbers to be inserted and the numbers
to be inserted. Do the same as the question above, but use a linked list.
 */

public class array {
    public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.printf("Entered desired amount of number you want to sum: ");
    //array declaration and array size
    int arraySize = input.nextInt();
    int[] array = new int[arraySize];
    int sum = 0;//to sum up
    
    for(int i = 0; i < arraySize; i++){ //itterate input and sum
        System.out.printf("Enter the number in consecutive order: ");
        array[i] = input.nextInt();
        sum += array[i]; //sum process
    }

    System.out.printf("Summed up value is : " + sum); //output the value
    }     
}