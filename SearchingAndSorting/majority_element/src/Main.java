//{ Driver Code Starts
// Initial Template for Java

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
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int majorityElement(int[] arr) {
        // your code here
        int count = 1;
        int element = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            if (arr[i] == element) {
                ++count;
            } else {
                --count;
                if (count == 0) {
                    element = arr[i];
                    count = 1;
                }
            }
        }

        count = 0;

        for (int j : arr) {
            if (j == element) ++count;
        }

        return count > n / 2 ? element : -1;
    }
}