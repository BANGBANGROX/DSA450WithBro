//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String str = sc.nextLine();
            //System.out.println(str.length());
            Solution ob  = new Solution();
            System.out.println(ob.countPS(str));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution {
    public long countPS(String s) {
        // Your code here
        int n = s.length();
        long[][] dp = new long[n + 1][n + 1];
        final int MOD = (int) 1e9 + 7;

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % MOD;
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + MOD) % MOD;
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}