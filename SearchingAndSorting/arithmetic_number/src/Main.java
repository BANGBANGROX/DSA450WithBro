//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] arr = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);

            Solution ob = new Solution();
            int ans = (ob.inSequence(a, b, c));
            if (ans == 1)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int inSequence(int a, int b, int c) {
        // code here
        double val = 1.0 * (b - a) / c + 1;

        return val == Math.floor(val) && val > 0 ? 1 : 0;
    }
}