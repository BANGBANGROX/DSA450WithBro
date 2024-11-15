//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long countTriplets(int n, int sum, long[] arr) {
        Arrays.sort(arr);

        long answer = 0;

        for (int i = 0; i < n - 1; ++i) {
            int left = i + 1;
            int right = n - 1;
            long thresholdSum = sum - arr[i];
            while (left < right) {
                long currentSum = arr[left] + arr[right];
                if (currentSum < thresholdSum) {
                    answer += (right - left);
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return answer;
    }
}


//{ Driver Code Starts.

// Driver class
public class Main {
    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            //            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int k = Integer.parseInt(q[1]);
            //            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            long ans = ob.countTriplets(n, k, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends