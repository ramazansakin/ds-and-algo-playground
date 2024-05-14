package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRangesSolution {

//    Example 1:
//    Input: nums = [0,1,2,4,5,7]
//    Output: ["0->2","4->5","7"]
//    Explanation: The ranges are:
//            [0,2] --> "0->2"
//            [4,5] --> "4->5"
//            [-,7] --> "7"

    //
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int firstInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1 == nums.length) || (nums[i] + 1 != nums[i + 1])) {
                if (i == firstInd)
                    result.add("" + nums[firstInd]);
                else
                    result.add(nums[firstInd] + "->" + nums[i]);

                firstInd = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Case-1
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println("List : " + Arrays.toString(nums));
        System.out.println("Result list : " + new SummaryRangesSolution().summaryRanges(nums));

        System.out.println();
        // Case-2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println("List : " + Arrays.toString(nums2));
        System.out.println("Result list : " + new SummaryRangesSolution().summaryRanges(nums2));

    }

}
