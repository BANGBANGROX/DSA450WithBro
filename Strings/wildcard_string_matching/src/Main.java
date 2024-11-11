//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();

            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private String regex;
    private String s;
    private int m;
    private int n;
    private int[][] dp;

    private boolean matchHandler(int i, int j) {
        if (i >= m) {
            if (j >= n) return true;
            if (regex.charAt(j) == '*') return matchHandler(i, j + 1);
            return false;
        }

        if (j >= n) return false;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean result;

        if (s.charAt(i) == regex.charAt(j)) {
            result = matchHandler(i + 1, j + 1);
        } else {
            if (regex.charAt(j) == '?') {
                result = matchHandler(i + 1, j + 1);
            } else if (regex.charAt(j) == '*') {
                result = matchHandler(i + 1, j) || matchHandler(i + 1, j + 1) ||
                        matchHandler(i, j + 1);
            } else {
                result = false;
            }
        }

        dp[i][j] = result ? 1 : 0;

        return result;
    }

    public boolean match(String regex, String s) {
        // code here
        this.regex = regex;
        this.s = s;
        m = s.length();
        n = regex.length();
        dp = new int[m + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return matchHandler(0, 0);
    }
}