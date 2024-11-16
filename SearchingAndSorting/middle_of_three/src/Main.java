//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int A=Integer.parseInt(S[0]);
            int B=Integer.parseInt(S[1]);
            int C=Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.middle(A,B,C));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int middle(int a, int b, int c) {
        //code here
        if (a > b) {
            if (a > c) {
                return Math.max(b, c);
            }
        } else {
            if (a > c) return a;
            return Math.min(b, c);
        }

        return a;
    }
}