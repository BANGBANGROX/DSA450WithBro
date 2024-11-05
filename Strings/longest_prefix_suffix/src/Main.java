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

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lps(String s) {
        // code here
        int n = s.length();
        int[] dp = new int[n];
        int i = 1;
        int len = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                dp[i] = len;
                ++i;
            } else {
                if (len == 0) ++i;
                else len = dp[len - 1];
            }
        }

        return dp[n - 1];
    }
}