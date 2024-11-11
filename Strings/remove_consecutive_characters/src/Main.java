//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String S = read.readLine().trim();

            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private String s;
    private int n;

    private String removeConsecutiveCharacterHandler(int idx, char lastChar) {
        if (idx == n) return "";

        if (s.charAt(idx) == lastChar)
            return removeConsecutiveCharacterHandler(idx + 1, lastChar);

        return s.charAt(idx) +
                removeConsecutiveCharacterHandler(idx + 1, s.charAt(idx));
    }

    public String removeConsecutiveCharacter(String s) {
        this.s = s;
        n = s.length();

        return removeConsecutiveCharacterHandler(0, '#');
    }
}