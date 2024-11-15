//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            long[] ans;
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long[] productExceptSelf(int[] arr) {
        // code here
        int n = arr.length;
        long[] productSuffix = new long[n];
        long[] answer = new long[n];
        long productPrefix = 1;

        productSuffix[n - 1] = 1;

        for (int i = n - 2; i >= 0; --i) {
            productSuffix[i] = arr[i + 1] * productSuffix[i + 1];
        }

        for (int i = 0; i < n; ++i) {
            answer[i] = productPrefix * productSuffix[i];
            productPrefix *= arr[i];
        }

        return answer;
    }
}
