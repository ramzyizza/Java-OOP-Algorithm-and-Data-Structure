package StringMatching;

public class StringMatching {

    static void naive(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();
        int naiveCounter = 0;
        boolean found = false;

        for(int i = 0; i +  patternLength <= textLength; i ++){
            boolean currentFound = true;
            for(int j = 0; j < patternLength; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    currentFound = false;
                    break;
                } 
            }
            if(currentFound){
                found = true;
                // naiveCounter++;
            }
        }
        // if(!found){
        //     System.out.println("Naive algorithm - Pattern not found.");
        // }
        // System.out.println("Total pattern found using Naive Algorithm: " + naiveCounter);
    }

    static int[] computeLPSArray(String str){
        int length = str.length();

        int[] lps = new int [length];
        lps[0] = 0;

        for(int i = 1; i < length; i++){
            int j = lps[i-1];
            
            while((j > 0) && (str.charAt(i) != str.charAt(j))){
                j = lps[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    static void kmp(String text, String pattern){
        String combined = pattern + "#" + text;
        int combineLength = combined.length();
        int patternLength = pattern.length();
        int KMPCounter = 0;

        int lps[] = computeLPSArray(combined);
        boolean found = false;

        for(int i = patternLength + 1; i < combineLength; i++){
            if(lps[i] == patternLength){
                found = true;
                // KMPCounter++;
            }
        }
        // System.out.println("Total pattern found using KMP Algorithm: " + KMPCounter + " Pattern(s)");

        // if(!found){
        //     System.out.println("Pattern not found");
        // }
    }

    static boolean kmpFindIndex(String text, String pattern){
        String combined = pattern + "#" + text;
        int combineLength = combined.length();
        int patternLength = pattern.length();

        int lps[] = computeLPSArray(combined);
        boolean found = false;
        for(int i = patternLength + 1; i < combineLength; i++){
            if(lps[i] == patternLength)
                found = true;
        }
        if(!found)
            found = false;
        return found;
    }

    // static void cycleShift(String s, String t){
    //     StringBuilder S = new StringBuilder(s);
	// 	StringBuilder T = new StringBuilder(t);
    //     int len = S.length();
	// 	int cycleShifts = 0, count = 0;
        
    //     System.out.println("\nBase word (S) = " + S);
    //     System.out.println("Shifted word (T) = "+ T);
    //     for(; cycleShifts < len; cycleShifts++){
    //         if(S.toString().equals(T.toString())){
    //             System.out.println("Yes, It's Match!");
    //             break;
    //         }

	// 		char firstChar = S.charAt(0);
    //         S.substring(1);
	// 		S.deleteCharAt(0);
	// 		S.append(firstChar);
    //         count++;
	// 		System.out.println("Iteration " + count + " : " +  S.toString());

    //         if(cycleShifts == (len-1) && !S.toString().equals(T.toString())){
    //             System.out.println("No, It is not Match");
    //         }
	// 	}
    // }

    static String shiftChar(String text, char ch, int i) { 
        StringBuilder s = new StringBuilder(text);
        s.setCharAt(i, ch); 
        return s.toString();
    }

    static void cycleShift(String S, String T){ 
        int shiftCounter = 0; int iteration  = 1; int length = S.length(); 
        boolean index = kmpFindIndex(S,T); char shift;
        System.out.println("\nBase word (S) = " + S + "\nShifted word (T) = " + T);
        while(shiftCounter < length && !index){ 
            int i = 0;
            shift = S.charAt(0);

            while(i != length - 1){
                S = shiftChar(S, S.charAt(i + 1), i); i++;
            }

            S = shiftChar(S, shift, length - 1); 
            System.out.println("Iteration " + iteration + " : " + S);
            index = kmpFindIndex(S,T);
            shiftCounter++; iteration++; 
        }
        String result = (index) ? "\nYes, it is match" : "\nNo it is not";
        System.out.println(result);
    }
}
        
    
