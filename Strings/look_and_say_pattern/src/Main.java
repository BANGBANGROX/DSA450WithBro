//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.lookandsay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String lookandsay(int n) {
        // your code here
        if (n == 1) return "1";

        String last = "1";

        for (int i = 2; i <= n; ++i) {
            StringBuilder next = new StringBuilder();
            for (int j = 0; j < last.length(); ++j) {
                int cnt = 1;
                while (j < last.length() - 1 && last.charAt(j) == last.charAt(j + 1)) {
                    ++cnt;
                    ++j;
                }
                next.append(cnt);
                next.append(last.charAt(j));
            }
            last = next.toString();
        }

        return last;
    }
}
