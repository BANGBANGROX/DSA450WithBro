//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int runningSum = 0;

        for (int right = 0; right < n; ++right) {
            runningSum += arr[right];
            if (runningSum > x) {
                while (runningSum > x) {
                    runningSum -= arr[left];
                    ++left;
                }
                answer = Math.min(answer, right - left + 2);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
