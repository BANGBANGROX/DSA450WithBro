//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while (t > 0) {
            int n = Integer.parseInt(sc.next());
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(sc.next());

            int k = Integer.parseInt(sc.next());
            Solution ob = new Solution();
            System.out.println(ob.kthSmallest(a, n, k));

            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    private int[][] mat;
    private int n;

    private int findEqualOrSmaller(int key) {
        int result = 0;

        for (int i = 0; i < n; ++i) {
            if (mat[i][0] > key) return result;
            if (mat[i][n - 1] <= key) {
                result += n;
                continue;
            }
            int ind = 0;
            for (int jump = n / 2; jump > 0; jump /= 2) {
                while (ind + jump < n && mat[i][ind + jump] <= key) {
                    ind += jump;
                }
            }
            result += (ind + 1);
        }

        return result;
    }

    public int kthSmallest(int[][] mat, int n, int k) {
        //code here.
        this.mat = mat;
        this.n = n;
        int left = mat[0][0];
        int right = mat[n - 1][n - 1];

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int cnt = findEqualOrSmaller(mid);
            if (cnt >= k) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}