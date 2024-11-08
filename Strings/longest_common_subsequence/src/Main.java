//{ Driver Code Starts

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(); // Take size of both the strings as input
            int m = sc.nextInt();

            String str1 = sc.next(); // Take both the string as input
            String str2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(n, m, str1, str2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private int[][] dp;
    private String s1;
    private String s2;
    private int m;
    private int n;

    private int lcsHandler(int i, int j) {
        if (i == m || j == n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int result;

        if (s1.charAt(i) == s2.charAt(j)) {
            result = lcsHandler(i + 1, j + 1) + 1;
        } else {
            result = Math.max(lcsHandler(i + 1, j), lcsHandler(i, j + 1));
        }

        return dp[i][j] = result;
    }

    // Function to find the length of longest common subsequence in two strings.
    public int lcs(int m, int n, String s1, String s2) {
        // your code here
        this.s1 = s1;
        this.s2 = s2;
        this.m = m;
        this.n = n;
        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcsHandler(0, 0);
    }
}