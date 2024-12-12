//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine().trim();

            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String chooseandswap(String s) {
        // Code Here
        int n = s.length();
        int[] firstIndex = new int[26];
        char oldChar = '#';
        char newChar = '#';

        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'a';
            if (firstIndex[idx] == -1) {
                firstIndex[idx] = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (char ch = 'a'; ch <= s.charAt(i); ++ch) {
                if (firstIndex[ch - 'a'] > firstIndex[s.charAt(i) - 'a']) {
                    oldChar = s.charAt(i);
                    newChar = ch;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (oldChar == '#') return s;

        char[] sArray = s.toCharArray();

        for (int i = 0; i < n; ++i) {
            if (sArray[i] == oldChar) {
                sArray[i] = newChar;
            } else if (sArray[i] == newChar) {
                sArray[i] = oldChar;
            }
        }

        return new String(sArray);
    }
}