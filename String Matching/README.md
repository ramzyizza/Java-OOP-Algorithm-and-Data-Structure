## Problem Set

1. Given a text = "aaaa...aa" (100.000 times of letter a) and a pattern = "aaa...aab" (10.000 times of letter a and 1 letter b). Compare the running time of naïve algorithm and KMP algorithm to perform string matching! Perform the string matching 10 times, and then compute the average running time of each algorithm. 
2. Given a text = "aaaa...aa" (100.000 times of letter a) and a pattern = "aaa...aa" (10.000 times of letter a). Compare the running time of naïve algorithm and KMP algorithm (without any output) to perform string matching! Perform the string matching 10 times, and then compute the average running time of each algorithm.
3. Given two words S and T, both has equal length (the maximum length is 100.000). Your task is to determine whether T can be created by performing multiple cycle shifts to S (a cycle shift is a transfer of the first character of the string to the end of this string). For example, if S = "erwineko" and T = "ekoerwin", the answer must be "YES", because "erwineko" -> "rwinekoe" -> "winekoer" -> "inekoerw" -> "nekoerwi" -> "ekoerwin". In this problem, you have to use the KMP algorithm to solve this task (the approach may not be obvious, but you have to figure the usage of the KMP algorithm in this problem).

## CHAPTER 10: String Matching Algorithm (Naïve & KMP)

**10.1 Learning Objectives**

1.  Understand the concept of string matching.
2.  Understand the naïve algorithm for string matching.
3.  Understand the KMP algorithm for string matching.
4.  Solve problems related to string matching.

**10.2 Material**

**10.2.1 String Matching**

-   Problem definition: Finding all occurrences of a given pattern in a text.
-   Real-world application examples: Text-editing programs, DNA sequence searching.
-   Overview of various string matching algorithms.

**10.2.2 The Naïve Algorithm**

-   Basic approach: Check condition P[0…(m-1)] = T[s…(s+m-1)] for each possible value of s.
-   Example with T = “1011101110” and P = “111”.

**10.2.3 The KMP Algorithm**

-   Shortcomings of the naïve algorithm.
-   Introduction to the Knuth, Morris, and Pratt string searching algorithm.
-   Concepts of proper prefixes and proper suffixes.
-   Explanation of LPS (Longest Proper Prefix which is also a Suffix) table and its construction.
-   Examples of LPS table construction.
-   Detailed step-by-step algorithm to construct LPS table.
-   Steps of the KMP algorithm with examples.

**10.2.4 Java Implementation**

-   Introduction to the `StringMatcher` class.
-   Explanation of two main methods: `naive` and `kmp`.
-   Mention of the `computeLPSArray` method used in the KMP algorithm.
-   Introduction to the `StringMatcherMain` class for the main program execution.
