//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args)throws IOException{

        //taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            //Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            //Creating an object of class Rotate
            Solution obj = new Solution();

            //calling areRotations method
            //of class Rotate and printing
            //"1" if it returns true
            //else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    private int[] getLps(String s) {
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

    //Function to check if two strings are rotations of each other or not.
    public boolean areRotations(String s1, String s2) {
        // Your code here
        String text = s1 + s1;
        int[] lps = getLps(s2);
        int i = 0;
        int j = 0;
        int n = text.length();

        while (i < n) {
            if (text.charAt(i) == s2.charAt(j)) {
                ++i;
                ++j;
                if (j == s2.length()) return true;
            } else {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return false;
    }
}