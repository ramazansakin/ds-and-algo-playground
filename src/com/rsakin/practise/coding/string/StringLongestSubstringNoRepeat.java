package com.rsakin.practise.coding.string;


// Normalde naive ve ya brute-force yaklaşımda direk bütün ikililer denenir ve klasik olarak,
// bu O(n^2) dir. Burda birde denenen her bir substring in distinct olup olmadıgının kontrolü de işin içine girince
// O(n^3) olarak bit time komplexity karşımıza çıkıyor. Aynı şekilde neredeyse bütün String sorularının
// ve ya benzer şekilde array sorularınında basit çözümünde bu 2'li iç içe for-loop yatıyor ama gel-geleim iş daha optimum
// bir çözüme gelince burada işte "prefixSum", "slidingWindow", "Dynamic Programming", "Two pointer" gibi yaklaşımlar ile
// optimum çözüme yaklaşılabiliyor.


import java.util.HashMap;

// ## Sliding Window
// Length of the longest substring without repeating characters using Sliding Window in O(n2) time:
public class StringLongestSubstringNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int n = s.length();
        int maxLength = 0, start = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                // If the current character is already in the substring, update the start index
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
            // Update the index of the current character in the map
            charIndexMap.put(currentChar, end);
        }

        return maxLength;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);

        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of the longest "
                + "non-repeating character "
                + "substring is " + len);
    }

}
