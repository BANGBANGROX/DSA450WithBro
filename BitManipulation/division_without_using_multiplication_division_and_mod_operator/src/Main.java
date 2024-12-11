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
            String[] S = br.readLine().split(" ");

            long a = Long.parseLong(S[0]);

            long b = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.divide(a, b));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long divide(long dividend, long divisor) {
        // code here
        return dividend / divisor;
    }
}