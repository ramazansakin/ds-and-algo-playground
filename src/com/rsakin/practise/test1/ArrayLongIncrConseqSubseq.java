package com.rsakin.practise.test1;

import java.util.Collections;
import java.util.HashMap;

public class ArrayLongIncrConseqSubseq {
    static int LongIncrConseqSubseq(int arr[], int n) {
        // create hashmap to save latest consequent
        // number as "key" and its length as "value"
        HashMap<Integer, Integer> map = new HashMap<>();

        // put first element as "key" and its length as "value"
        map.put(arr[0], 1);
        for (int i = 1; i < n; i++) {

            // check if last consequent of arr[i] exist or not
            if (map.containsKey(arr[i] - 1)) {

                // put the updated consequent number
                // and increment its value(length)
                map.put(arr[i], map.get(arr[i] - 1) + 1);

                // remove the last consequent number
                map.remove(arr[i] - 1);
            }

            // if there is no last consequent of
            // arr[i] then put arr[i]
            else {
                map.put(arr[i], 1);
            }
        }
        return Collections.max(map.values());
    }

    // driver code
    public static void main(String[] args) {
        // Take input from user
        int[] arr = {3, 10, 3, 11, 4, 5, 7, 7, 8, 12};
        int n = arr.length;

        System.out.println("#################");
        System.out.println(LongIncrConseqSubseq(arr, n));
        System.out.println("#################");
    }

}
