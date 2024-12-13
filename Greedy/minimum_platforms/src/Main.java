//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                    " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                        Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                    " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                        Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    public int findPlatform(int[] arrivals, int[] departures) {
        // add your code here
        int n = arrivals.length;
        int answer = 0;
        int currentPlatforms = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        while (i < n && j < n) {
            if (arrivals[i] <= departures[j]) {
                ++i;
                ++currentPlatforms;
            } else {
                answer = Math.max(answer, currentPlatforms);
                --currentPlatforms;
                ++j;
            }
        }

        answer = Math.max(answer, currentPlatforms);

        return answer;
    }
}
