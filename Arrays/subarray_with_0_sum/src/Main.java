//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            t--;

            System.out.println(new Solution().findsum(arr) ? "true" : "false");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    public boolean findsum(int[] arr) {
        // Your code here
        Set<Integer> visited = new HashSet<>();
        int runningSum = 0;

        visited.add(0);

        for (int num : arr) {
            runningSum += num;
            if (visited.contains(runningSum)) return true;
            visited.add(runningSum);
        }

        return false;
    }
}