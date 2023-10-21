package StringMatching;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringMatcherMain {
    public static void main(String[] args){

        long timerStart = System.currentTimeMillis(); //start execution time in miliseconds

        String text = "a";//multiply a by 100.000 times for text
        String textRepeated = text.repeat(100000);

        String pattern = "a";//multiply a by 10.000 times for pattern
        String patternRepeated = pattern.repeat(10000) + "b";
        String patternRepeated2 = pattern.repeat(10000);

        // System.out.println("Text: (a) 100.000 Times\nSearched pattern (a) 10.000 Times + b\n");   
        // System.out.println("Text: (a) 100.000 Times\nSearched pattern (a) 10.000 Times\n");   

        // StringMatching.naive(textRepeated, patternRepeated2); //naive algorithm
        StringMatching.kmp(textRepeated, patternRepeated2); //KMP algorithm

        long endTimer = System.currentTimeMillis(); //end execution time in millisecondw

        NumberFormat formatter = new DecimalFormat("#0.000"); //convert miliseconds to seconds
        System.out.print("Runtime of KMP Algorithm:  " + formatter.format((endTimer - timerStart) / 1000d) + " seconds");
        // System.out.print("Runtime of KMP Algorithm:  " + formatter.format((endTimer - timerStart) / 1000d) + " seconds");

        // StringMatching.cycleShift("erwineko", "ekoerwin");

        StringMatching.cycleShift("ramzy", "ramzyganteng");

    }
}