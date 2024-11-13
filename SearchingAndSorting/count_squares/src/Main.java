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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countSquares(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int countSquares(int n) {
        // code here
        double squareRoot = Math.sqrt(n);

        if (squareRoot == Math.floor(squareRoot)) {
            return (int) (squareRoot - 1);
        }

        return (int) squareRoot;
    }
}