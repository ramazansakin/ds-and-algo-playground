package com.rsakin.practise.leetcode;

import java.util.*;

public class MergeIntervalsSolution {

//    Example 1:
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    // 1.way - while traversing the list, we need to take care of each inner list comparing with next one
    // so, it is similar to SummaryRanges Solution, this is just 2D array-based version of it

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort the intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (end >= nextStart) {
                // Overlapping intervals, update the end if needed
                end = Math.max(end, nextEnd);
            } else {
                // Non-overlapping interval found, add the current merged interval to the result
                merged.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }

        // Add the last merged interval
        merged.add(new int[]{start, end});

        // convert List of 1D-array to 2D-array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals1 = solution.merge(intervals1);
        System.out.println("Merged intervals for Example 1:");
        printIntervals(mergedIntervals1);

        // Test case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] mergedIntervals2 = solution.merge(intervals2);
        System.out.println("\nMerged intervals for Example 2:");
        printIntervals(mergedIntervals2);


        System.out.println("------------------------------------------------------");
        // Solution without sorting test
        MergeIntervalsSolution mergeIntervals = new MergeIntervalsSolution();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merged = mergeIntervals.merge(intervals);

        System.out.print("Merged Intervals: ");
        for (Interval interval : merged) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }

    }

    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }


    // ######################################
    // ### Solution without sorting
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;

        List<Interval> merged = new ArrayList<>();

        for (Interval current : intervals) {
            boolean mergedWithPrevious = false;

            for (Interval mergedInterval : merged) {
                if (current.start <= mergedInterval.end && current.end >= mergedInterval.start) {
                    // Merge intervals
                    mergedInterval.start = Math.min(current.start, mergedInterval.start);
                    mergedInterval.end = Math.max(current.end, mergedInterval.end);
                    mergedWithPrevious = true;
                    break;
                }
            }

            if (!mergedWithPrevious) {
                // If the current interval did not merge with any previous interval, add it to the result
                merged.add(current);
            }
        }

        return merged;
    }


}
