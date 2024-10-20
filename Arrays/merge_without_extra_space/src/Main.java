//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            long[] arr1 = new long[n];
            long[] arr2 = new long[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Long.parseLong(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Long.parseLong(inputLine[i]);
            }
            Solution ob = new Solution();
            ob.merge(n, m, arr1, arr2);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i]).append(" ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i]).append(" ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void merge(int m, int n, long[] arr1, long[] arr2) {
        // code here
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                --i;
                ++j;
            } else break;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
