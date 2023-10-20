package Assignment_2;

import java.util.*;

// Create an array that stores 10 numbers, then triple each number.

public class tripleArray {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] array = new int[10]; //array declaration
    
        System.out.printf("Enter data seperated by spaces: ");
        for(int i = 0;i < 10; i++){ //itterate input
            array[i] = input.nextInt();
            array[i] *= 3; //data multipled by 3
        }
        System.out.println("The Data inside array after multiplied by 3 is given as: ");
        for(int i = 0;i < 10; i++){ //itterate output
            System.out.printf(array[i] + " ");
        }
    }
}