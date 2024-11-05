//{ Driver Code Starts
//Initial Template for Java

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);

            for (Integer re : res) System.out.print(re + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] getLps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

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

    public ArrayList<Integer> search(String pattern, String text) {
        // your code here
        int[] lps = getLps(pattern);
        int m = pattern.length();
        int n = text.length();
        int i = 0;
        int j = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        while (j < n) {
            if (pattern.charAt(i) == text.charAt(j)) {
                ++i;
                ++j;
                if (i == m) {
                    answer.add(j - m + 1);
                    i = lps[i - 1];
                }
            } else {
                if (i == 0) ++j;
                else i = lps[i - 1];
            }
        }

        return answer;
    }
}