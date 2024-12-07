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
            System.out.println(ob.findPosition(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findPosition(int n) {
        // code here
        int answer = -1;

        for (int i = 0; i < 32; ++i) {
            if ((n & (1 << i)) > 0) {
                if (answer == -1) {
                    answer = i + 1;
                } else return -1;
            }
        }

        return answer;
    }
}