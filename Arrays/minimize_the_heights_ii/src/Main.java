//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;

        Arrays.sort(arr);

        int answer = arr[n - 1] - arr[0];
        int overallMinHeight = arr[0] + k;
        int overallMaxHeight = arr[n - 1] - k;

        for (int i = 0; i < n - 1; ++i) {
            int currentMinHeight = Math.min(overallMinHeight, arr[i + 1] - k);
            int currentMaxHeight = Math.max(overallMaxHeight, arr[i] + k);
            if (currentMinHeight < 0) continue;
            answer = Math.min(answer, currentMaxHeight - currentMinHeight);
        }

        return answer;
    }
}
