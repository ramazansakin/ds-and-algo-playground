package com.rsakin.practise.leetcode;

public class LengthofLastWordSolution {

//    Example 1:
//    Input: s = "Hello World"
//    Output: 5
//    Explanation: The last word is "World" with length 5.

    // Split the input string by ' ', then get the last one and return the length
    public int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");
        return splits[splits.length - 1].length();
    }

    // 2.way without using split, it ll be like tracing all the list
    // and then check ' ' characters occurs and take a startIndex int to keep
    // starting index of the last string
    // actually this is not efficient, for better effciency, instead of tracing the list from 0, we can start from end
    // then just check if there is ' ' char and return the length but the input might be single string
    // then check also the index is 0 ? it ll be more efficient !!!

}
