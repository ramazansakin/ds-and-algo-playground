package com.rsakin.practise.coding.stack;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {

        int arr[] = {11, 13, 21, 3, 5, 25, 40, 7, 6, 1};
        printNGE(arr);

    }

    private static void printNGE(int[] arr) {
        int n = arr.length;
        if (n < 1) {
            System.err.println("Array needs to have at least 1 element!");
            return;
        }

        int[] ngeArr = new int[n];
        Stack<Integer> st = new Stack<>();
        ngeArr[n - 1] = -1;

        for (int i = n - 1; i > 0; --i) {
            if (arr[i] < arr[i - 1]) {
                while (!st.empty()) {
                    if (st.peek() > arr[i - 1]) {
                        ngeArr[i - 1] = st.peek();
                        break;
                    } else st.pop();
                }

                if (st.empty()) ngeArr[i - 1] = -1;

            } else {
                ngeArr[i - 1] = arr[i];
                st.push(arr[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ngeArr[i]);
        }
    }

}
