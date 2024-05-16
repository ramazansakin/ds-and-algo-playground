package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervalSolution {


//    !! Note that you don't need to modify intervals in-place. You can make a new array and return it.

//    Example 1:
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]

//    Example 2:
//    Input: intervals = [[1,2],[4,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


    // [[1,2],[4,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // [[1,2],[4,5],[6,7],[8,10],[12,16]], newInterval = [2,3]
    // [[1,2],[4,5],[6,7],[8,10],[12,16]], newInterval = [17,18]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge intervals that overlap with the new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval); // Insert the merged interval

        // Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // Case-1
        int[][] intervals = {{1, 2}, {4, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] insert = new InsertIntervalSolution().insert(intervals, newInterval);
        System.out.println("Result : " + Arrays.deepToString(insert));


        // Case-2
        int[][] intervals2 = {{1, 2}, {4, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {2, 3};

        int[][] insert2 = new InsertIntervalSolution().insert(intervals2, newInterval2);
        System.out.println("Result : " + Arrays.deepToString(insert2));

        // Case-3
        int[][] intervals3 = {{1, 2}, {4, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval3 = {17, 18};

        int[][] insert3 = new InsertIntervalSolution().insert(intervals3, newInterval3);
        System.out.println("Result : " + Arrays.deepToString(insert3));

    }

}
