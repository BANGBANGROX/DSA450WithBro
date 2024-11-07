//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String s = sc.next ();
            System.out.println (new Sol().countRev (s));

            System.out.println("~");
        }

    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol {
    public int countRev (String s) {
        // your code here
        int n = s.length();

        if ((n & 1) > 0) return -1;

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }

        int answer = stack.size() / 2;
        int openBrackets = 0;

        while (!stack.isEmpty() && stack.peek() == '{') {
            ++openBrackets;
            stack.pop();
        }

        answer += (openBrackets % 2);

        return answer;
    }
}