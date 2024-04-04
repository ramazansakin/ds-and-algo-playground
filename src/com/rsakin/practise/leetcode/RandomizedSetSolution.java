package com.rsakin.practise.leetcode;

import java.util.*;

public class RandomizedSetSolution {

    static class RandomizedSet {

        private Map<Integer, Integer> valToIndex;
        private List<Integer> values;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            valToIndex = new HashMap<>();
            values = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (valToIndex.containsKey(val))
                return false;

            values.add(val);
            valToIndex.put(val, values.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val))
                return false;

            int index = valToIndex.get(val);
            int lastVal = values.get(values.size() - 1);
            values.set(index, lastVal);
            valToIndex.put(lastVal, index);
            values.remove(values.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2));        // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2));        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom());      // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1));        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2));        // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom());      // Since 2 is the only number in the set, getRandom() will always return 2.
    }


}
