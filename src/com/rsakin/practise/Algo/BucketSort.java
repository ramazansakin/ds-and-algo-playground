package com.rsakin.practise.Algo;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    // The size is important for data partitioning
    private static int BUCKET_SIZE = 20;

    public void bucketSort(float[] arr) {
        if (arr.length <= 0) return;
        List<Float>[] bucket = new LinkedList[BUCKET_SIZE];

        // Initialize empty buckets
        for (int i = 0; i < BUCKET_SIZE; i++)
            bucket[i] = new LinkedList<>();

        // Add elements into the buckets
        for (float v : arr) {
            int bucketIndex = (int) v * BUCKET_SIZE;
            bucket[bucketIndex].add(v);
        }

        // Sort the elements of each bucket
        Arrays.stream(bucket, 0, BUCKET_SIZE).forEach(Collections::sort);

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < BUCKET_SIZE; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        float[] arr = {(float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
                (float) 0.51, (float) 0.11, (float) 0.51, (float) 0.0051, (float) 0.011};
        b.bucketSort(arr);

        for (float i : arr) System.out.print(i + "  ");
    }
}
