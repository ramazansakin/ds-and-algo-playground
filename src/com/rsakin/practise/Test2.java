package com.rsakin.practise;

import java.util.Arrays;

public class Test2 {

    public static String total(String[] groceryList) {
        //Insert your code here
        StringBuilder st = new StringBuilder();
        int total = 0;
        // product price amount
        for (int i = 0; i < groceryList.length; i++) {

            // extract special characters from a string
            String[] gSplits = groceryList[i].replaceAll("[-+.^:;,]", " ").split("\\s+");
            String product = gSplits[0];
            // Need to remove all special chars and try to get an integer or skip
            try {
                int price = Integer.parseInt(gSplits[1]);
                int amount = Integer.parseInt(gSplits[2]);

                st.append(price * amount);
                if (i + 1 < groceryList.length)
                    st.append("+");
                total += price * amount;
                // If there is formatting exp need to skip
            } catch (Exception exp) {
                // do nothing and skip
            }

        }
        if (total > 0)
            st.append("=").append(total);

        return st.toString();
    }

    public static void main(String[] args) {

        String[] groceryList = {"Apple -;5", "Banana 1 5"};

        System.out.println("Solution for " + Arrays.toString(groceryList));
        System.out.println(total(groceryList));

    }

}
