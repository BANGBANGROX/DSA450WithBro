//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long[] a = new long[(int) (n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));


            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long maximizeSum(long[] nums, int n, int k) {
        // Your code goes here
        Arrays.sort(nums);

        long answer = 0;
        int cnt = 0;
        long leastAbsValue = 0;

        for (long num : nums) {
            leastAbsValue = Math.min(leastAbsValue, Math.abs(num));
            if (num < 0) {
                if (cnt < k) {
                    ++cnt;
                    answer += Math.abs(num);
                } else {
                    answer += num;
                }
            } else {
                answer += num;
            }
        }

        k -= cnt;
        k %= 2;

        if (k > 0) answer -= 2 * leastAbsValue;

        return answer;
    }
}