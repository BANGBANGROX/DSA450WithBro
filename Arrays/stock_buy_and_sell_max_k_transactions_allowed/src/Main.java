//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String[] input_line = in.readLine().trim().split("\\s+");
            int[] A = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxProfit(int k, int n, int[] price) {
        // code here
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; ++i) {
            int previousDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; ++j) {
                previousDiff = Math.max(previousDiff, dp[i - 1][j - 1] - price[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], previousDiff + price[j]);
            }
        }

        return dp[k][n - 1];
    }
}