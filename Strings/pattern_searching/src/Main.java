//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String str;
            str = br.readLine();


            String pat;
            pat = br.readLine();

            Solution obj = new Solution();
            boolean res = obj.searchPattern(str, pat);

            if (res)
                System.out.println("Present");
            else
                System.out.println("Not present");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[] getLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1;
        int len = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                lps[i] = len;
                ++i;
            } else {
                if (len == 0) ++i;
                else len = lps[len - 1];
            }
        }

        return lps;
    }

    public boolean searchPattern(String text, String pattern) {
        // code here
        int[] lps = getLPS(pattern);
        int m = text.length();
        int n = pattern.length();
        int i = 0;
        int j = 0;

        while (i < m) {
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                if (j == n) return true;
            } else {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return false;
    }
}
        
