//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        Map<Integer, Integer> count = new HashMap<>();
        int threshold = n / k;
        int answer = 0;

        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > threshold) {
                ++answer;
            }
        }

        return answer;
    }
}
