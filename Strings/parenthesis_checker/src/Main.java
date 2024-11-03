//{ Driver Code Starts

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Parenthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (Solution.isParenthesisBalanced(st))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    public static boolean isParenthesisBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closingToOpeningMap = new HashMap<>();
        Set<Character> closingBrackets = new HashSet<>();

        closingToOpeningMap.put(')', '(');
        closingToOpeningMap.put('}', '{');
        closingToOpeningMap.put(']', '[');
        closingBrackets.add(')');
        closingBrackets.add('}');
        closingBrackets.add(']');

        for (char ch : s.toCharArray()) {
            if (closingBrackets.contains(ch)) {
                if (!stack.isEmpty() && closingToOpeningMap.get(ch) == stack.peek()) {
                    stack.pop();
                }
                else return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
