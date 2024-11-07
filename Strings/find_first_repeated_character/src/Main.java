//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public String firstRepChar(String s) {
        // code here
        boolean[] visited = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (visited[ch - 'a']) return "" + ch;
            visited[ch - 'a'] = true;
        }

        return "-1";
    }
}