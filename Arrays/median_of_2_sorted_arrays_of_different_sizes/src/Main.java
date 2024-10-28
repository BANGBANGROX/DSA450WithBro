//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int m = sc.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            double res = new GFG().medianOfArrays(n, m, a, b);

            if (res == (int) res) System.out.println((int) res);
            else System.out.println(res);
        }

    }
}
// } Driver Code Ends


//User function Template for Java

class GFG {
    public double medianOfArrays(int m, int n, int[] a, int[] b) {
        // Your Code Here
        if (m > n) return medianOfArrays(n, m, b, a);

        int totalSize = m + n;
        int left = 0;
        int right = m;

        while (left <= right) {
            int cut1 = (left + ((right - left) >> 1));
            int cut2 = (totalSize + 1) / 2 - cut1;
            int first1 = Integer.MIN_VALUE;
            int first2 = Integer.MIN_VALUE;
            int last1 = Integer.MAX_VALUE;
            int last2 = Integer.MAX_VALUE;
            if (cut1 > 0) first1 = a[cut1 - 1];
            if (cut2 > 0) first2 = b[cut2 - 1];
            if (cut1 < m) last1 = a[cut1];
            if (cut2 < n) last2 = b[cut2];
            if (first1 <= last2 && first2 <= last1) {
                if ((totalSize & 1) > 0) return Math.max(first1, first2);
                return (Math.max(first1, first2) + Math.min(last1, last2)) / 2.0;
            }
            if (first1 > last2) right = cut1 - 1;
            else left = cut1 + 1;
        }

        return -1;
    }
}