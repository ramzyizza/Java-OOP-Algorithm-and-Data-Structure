package Assignment_2;

import java.util.*;

/*
Create a program that calculates the parking fee that must be paid for each car in the
parking lot. Each car has information on the car model and parking time. Assume the
rate is Rp. 2000 per hour.
*/


public class parkingSystem {
    public static void main(String[] args){
        String[] carModel = new String[5]; 
        carModel[0] = "La Ferarri";
        carModel[1] = "Toyota Avanza";
        carModel[2] = "Aston Martin DBS";
        carModel[3] = "Toyota Agya";
        carModel[4] = "Bugatti Divo";

        int[] carTime = new int[5]; 
        carTime[0] = 60; //minutes
        carTime[1] = 120; //minutes
        carTime[2] = 180; //minutes
        carTime[3] = 240; //minutes
        carTime[4] = 270; //minutes
        
        int position = 1;
        System.out.println("Welcome to Ramzy's Parking System! \n");
        System.out.println("Please Choose your car below:");
        for(int i = 0; i< 5; i++){
            System.out.println("Car Model " + position + " : " + carModel[i]);
            System.out.println("Time Parked : " + carTime[i] + " Minutes.\n");
            position++;
        }

        System.out.print("Enter model number: ");
        Scanner input = new Scanner(System.in);
        int model = input.nextInt();
        int price = carTime[model-1]/60 * 2000;

        System.out.println("Car Model: " + carModel[model-1]);
        System.out.println("Time Parked: " + carTime[model-1] + " Minutes");
        System.out.println("Total Price: " + price);
    }
}