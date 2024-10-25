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
            System.out.println(new Solution().trappingWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long trappingWater(int[] arr) {
        // code here
        long answer = 0;
        int left = 0;
        int right = arr.length - 1;
        int maxLeft = arr[left];
        int maxRight = arr[right];

        while (left < right) {
            maxLeft = Math.max(maxLeft, arr[left]);
            maxRight = Math.max(maxRight, arr[right]);
            if (maxLeft < maxRight) {
                answer += (maxLeft - arr[left]);
                ++left;
            } else {
                answer += (maxRight - arr[right]);
                --right;
            }
        }

        return answer;
    }
}
