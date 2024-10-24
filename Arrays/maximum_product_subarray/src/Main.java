//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    public long maxProduct(int[] arr) {
        // code here
        long answer = arr[0];
        long maxProduct = arr[0];
        long minProduct = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int num = arr[i];
            if (num < 0) {
                long temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(num, maxProduct * num);
            minProduct = Math.min(num, minProduct * num);
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}