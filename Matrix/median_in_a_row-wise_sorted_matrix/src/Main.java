//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int[][] matrix = new int[R][C];
            for (int i = 0; i < R; i++) {
                String[] line = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int upperBound(int[] nums, int left, int right, int key) {
        int answer = right + 1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] <= key) left = mid + 1;
            else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }

    public int median(int[][] matrix, int m, int n) {
        // code here
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < m; ++i) {
            minValue = Math.min(minValue, matrix[i][0]);
            maxValue = Math.max(maxValue, matrix[i][n - 1]);
        }

        int left = minValue;
        int right = maxValue;
        int required = (m * n + 1) / 2;

        while (left < right) {
            int mid = (left + ((right - left) >> 1));
            int current = 0;
            for (int i = 0; i < m; ++i) {
                current += upperBound(matrix[i], 0, n - 1, mid);
            }
            if (current < required) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}