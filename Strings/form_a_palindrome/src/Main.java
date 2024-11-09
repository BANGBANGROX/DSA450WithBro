//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.countMin(str));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countMin(String s) {
        // code here
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[0][n - 1];
    }
}