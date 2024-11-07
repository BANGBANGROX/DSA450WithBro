//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] arr = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String[] arr) {
        // code here
        String smallestString = arr[0];
        StringBuilder currentString = new StringBuilder();
        int n = arr.length;
        boolean match = true;

        for (int i = 1; i < n; ++i) {
            if (arr[i].length() < smallestString.length()) {
                smallestString = arr[i];
            }
        }

        for (char ch : smallestString.toCharArray()) {
            currentString.append(ch);
            int len = currentString.length();
            for (String s : arr) {
                for (int i = 0; i < len; ++i) {
                    if (s.charAt(i) != currentString.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (!match) break;
            }
            if (!match) break;
        }

        if (!match) {
            if (currentString.length() == 1) return "-1";
            return currentString.substring(0, currentString.length() - 1);
        }

        return currentString.toString();
    }
}