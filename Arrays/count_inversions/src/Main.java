//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int internalInversions(int[] arr, int left, int mid,
                                   int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        int inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++i;
            } else {
                temp[k] = arr[j];
                ++j;
                inversions += (mid - i + 1);
            }
            ++k;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            ++i;
            ++k;
        }

        while (j <= right) {
            temp[k] = arr[j];
            ++j;
            ++k;
        }

        for (i = left; i <= right; ++i) {
            arr[i] = temp[i - left];
        }

        return inversions;
    }

    private int inversionCountHandler(int[] arr, int left,
                                      int right) {
        int inversions = 0;

        if (left < right) {
            int mid = (left + ((right - left) >> 1));
            inversions += inversionCountHandler(arr, left, mid);
            inversions += inversionCountHandler(arr, mid + 1, right);
            inversions += internalInversions(arr, left, mid, right);
        }

        return inversions;
    }

    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    public int inversionCount(int[] arr) {
        // Your Code Here
        return inversionCountHandler(arr, 0, arr.length - 1);
    }
}