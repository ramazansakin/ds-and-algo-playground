package com.rsakin.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static String StringChallenge(String str) {

        Map<String, Integer> numbers = createNumbersMap();
        String[] strs = str.split("(?<=[a-z])");

        String op = "plus";
        // need to hold curr value and append it to res regarding the operation
        int res = 0, curr = 0;

        for (String s : strs) {
            if (numbers.containsKey(s)) {
                curr = curr * 10 + numbers.get(s);
            } else {
                if (op.equals("plus"))
                    res = res + curr;
                else
                    res = res - curr;
            }
            curr = 0;
            op = s;
        }

        if (op.equals("plus"))
            res = res + curr;
        else
            res = res - curr;

        // NOT : I just try to run it on my IDE because it s hard to check and debug it here !
        // I forgot not to copy-paste :/
        String response = "";
        if (res < 0) {
            response = "negative";
            res = -1 * res;
        }
        if (res >= 1000) {
            response += conversionToTens(res / 1000) + "thousand";
            res = res % 1000;
        }
        if (res >= 100) {
            response += convertionToOnes(res / 100) + "hundred";
            res = res % 100;
        }
        if (res >= 20) {
            response += conversionToTens(res / 10);
            res = res % 10;
        }

        if (res > 0) response += convertionToOnes(res);

        return response;
    }

    private static String conversionToTens(int number) {
        String[] tens = {
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
        return tens[number];
    }

    private static String convertionToOnes(int number) {
        String[] ones = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        return ones[number];
    }


    private static Map<String, Integer> createNumbersMap() {
        // First we need to map numbers with corresponfding strings
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        return numbers;
    }

    public static void main(String[] args) {
        // keep this function call here
        System.out.print(StringChallenge("onezeropluseight"));
    }


}



class Employee {

    private int ID;
    private String name;
    private int age;
    private static int nextId = 1;
    // it is made static because it
    // is keep common among all and
    // shared by all objects

    public Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }
    public void show()
    {
        System.out.println("Id=" + ID + "\nName=" + name
                + "\nAge=" + age);
    }
    public void showNextId()
    {
        System.out.println("Next employee id will be="
                + nextId);
    }

    protected void finalize()
    {
        --nextId;
        // In this case,
        // gc will call finalize()
        // for 2 times for 2 objects.
    }

}

class UseEmployee {
    public static void main(String[] args)
    {
        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);
        E.show();
        F.show();
        G.show();
        E.showNextId();
        F.showNextId();
        G.showNextId();

        { // It is sub block to keep
            // all those interns.
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
            X = Y = null;
            System.gc();
//            System.runFinalization();
        }
        // After countering this brace, X and Y
        // will be removed.Therefore,
        // now it should show nextId as 4.

        // Output of this line
        System.out.println("Last Show : ");
        E.showNextId();
        // should be 4 but it will give 6 as output.
    }
}