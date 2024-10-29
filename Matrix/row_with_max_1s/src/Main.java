//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int[][] arr) {
        // code here
        int m = arr.length;
        int n = arr[0].length;
        int right = n - 1;
        int maxOnesCnt = 0;
        int answer = -1;

        for (int i = 0; i < m; ++i) {
            int[] row = arr[i];
            while (right >= 0 && row[right] == 1) {
                --right;
            }
            int onesCnt = n - right - 1;
            if (maxOnesCnt < onesCnt) {
                answer = i;
                maxOnesCnt = onesCnt;
            }
        }

        return answer;
    }
}