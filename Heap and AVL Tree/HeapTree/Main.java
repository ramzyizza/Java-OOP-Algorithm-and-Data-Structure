package HeapTree;

/*
Airline System Program Using Priority Queue
My Idea & Approach for this problem : 
1. Input all the flight data into linked list
2. Use random() to determine the priority data and input to seperated linked list
3. Combine both linked list and insert it 1 by 1 to max heap
4. Input the sorted max heap into the regular queue
5. output the sorted data from queue in descending order
*/

import java.util.*;
public class Main {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        //Add airline data to the linked list
        LinkedList<String> airline = new LinkedList<String>();
        //Format = Airline Name - Flight Number - Destination
        airline.add("Garuda Indonesia - GA283 - Jakarta");
        airline.add("Lion Air - JT210 - Makassar");
        airline.add("Luthfansa - RM133 - Rome");
        airline.add("Delta Airline - DT99 - United States");
        airline.add("Jetblue Airline - JBA857 - Japan");
        airline.add("Singapore Airline - SG263 - Singapore");
        airline.add("Qatar Airways - QA957 - Abu Dhabi");
        airline.add("ANA Airways  - ANA442 - South Korea");
        airline.add("Emirates - EE842 - Madinah");
        airline.add("Cathay Pacific Airways - CPA134 - Hong Kong");
        airline.add("EVA Airline - EVA99 - Paris");
        airline.add("Qantas Airline - QA947 - Australia");
        airline.add("Air France - AF74 - Spain");
        airline.add("American Airlines - AA364 - New York");
        airline.add("Pakistan International Airlines - PIA484 - Pakistan");
        airline.add("Iceland Air - IA655 - Iceland");
        airline.add("India Airline - ID736 - India");
        airline.add("Turkish Airline - TA674 - Turki");
        airline.add("Emirates - EM377 - Jaddah");
        airline.add("British Airline - BT864 - United Kingdom");
        
        System.out.println("Welcome to Ramzy's Airport! \n");
        //receive flight data input from users
        System.out.print("Add Flight Data [Airline Name - Flight Number - Destination]: ");
        String newData = sc.nextLine();
        //Add data to the linked list
        airline.add(newData);

        //Printout the list of airline ready to take off - Not yet assigned the priority
        System.out.println("\n\nList of Airline ready for Take Off [NOT YET PRIORITIZE]: ");
        for(int i = 0, count = 1; i < airline.size(); i++){
            System.out.println(count + ". " + airline.get(i));
            count++;
        }
        //Randomize the priority 1-100 and push to seperated linked list
        LinkedList<Integer> priority = new LinkedList<Integer>();
        Random rand = new Random();
        int min = 0;
        int max = 100; //with bound 1-100
        //push the data of priority and flight data to the max heap
        Heap maxHeap = new Heap(22);
        for(int i = 0; i < airline.size();i++){
            priority.add( (int)Math.floor(Math.random()*(max-min+1)+min)); //add random priority number to linked list
             //concatenate both linked list flight data and random priority number
             //then insert it all to the MAX HEAP.
            maxHeap.insert(priority.get(i), airline.get(i));
        }
        
        //Set the queue and push the max heap into the queue
        Queue<Node> maxpq = new LinkedList<Node>(); 
        for(int i = 0; i < airline.size(); i++){
            maxpq.add(maxHeap.maxHeadNode()); 
        }
        //Priority Queue Max print in Descending Order
        System.out.println("\n\nAirline that have taken off in descending order: ");
        for(int i = 0; i < airline.size(); i++){
            //output the airline that have taken off based on highest priority value
            System.out.println(maxpq.peek().getKey() + " " + maxpq.peek().getData()); //print the head
            maxpq.remove(); //perform deletion one by one
        }
    }
}
