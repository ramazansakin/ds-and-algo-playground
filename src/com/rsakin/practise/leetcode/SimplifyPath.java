package com.rsakin.practise.leetcode;

import java.util.Stack;


// Example 1:
// Input: path = "/home/"
// Output: "/home"

// Example 2:
// Input: path = "/home//foo/"
// Output: "/home/foo"

// Example 3:
// Input: path = "/home/user/Documents/../Pictures"
// Output: "/home/user/Pictures"

// Example 4:
// Input: path = "/../"
// Output: "/"

// Example 5:
// Input: path = "/.../a/../b/c/../d/./"
// Output: "/.../b/d"

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (s.equals(".") || s.isEmpty()) {
                // do nothing just escape
            } else stack.push(s);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }

        return sb.toString().isEmpty() ? "/" : sb.toString();
    }


    public static void main(String[] args) {

        String simplifiedStr = new SimplifyPath().simplifyPath("/home//foo/");
        System.out.println("1 - Path : \"/home//foo/\" -> Simplified String = " + simplifiedStr);
        System.out.println();

        simplifiedStr = new SimplifyPath().simplifyPath("/../");
        System.out.println("2 - Path : \"/../\" -> Simplified String = " + simplifiedStr);
        System.out.println();

        simplifiedStr = new SimplifyPath().simplifyPath("/.../a/../b/c/../d/./");
        System.out.println("3 - Path : \"/.../a/../b/c/../d/./\" -> Simplified String = " + simplifiedStr);

    }

}
