//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[] nums;
    private int k;
    private int[][] dp;

    private int solveWordWrapHandler(int idx, int spaceLeft) {
        if (idx >= nums.length) return 0;

        if (dp[idx][spaceLeft] != -1) return dp[idx][spaceLeft];

        int result = solveWordWrapHandler(idx + 1, k - nums[idx]) +
                spaceLeft * spaceLeft;

        if (spaceLeft > nums[idx]) {
            result = Math.min(result,
                    solveWordWrapHandler(idx + 1, spaceLeft - nums[idx] - 1));
        }

        return dp[idx][spaceLeft] = result;
    }

    public int solveWordWrap(int[] nums, int k) {
        // Code here
        this.nums = nums;
        this.k = k;
        dp = new int[nums.length][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solveWordWrapHandler(1, k - nums[0]);
    }
}