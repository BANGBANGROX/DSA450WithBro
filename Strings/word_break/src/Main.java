//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            ArrayList<String> dictionary = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String p = sc.next();
                dictionary.add(p);
            }
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.wordBreak(n, s, dictionary));


            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int wordBreak(int n, String s, ArrayList<String> dictionary) {
        //code here
        Set<String> dictionarySet = new HashSet<>(dictionary);
        int len = s.length();
        boolean[] dp = new boolean[len];

        for (int i = 0; i < len; ++i) {
            String subString = s.substring(0, i + 1);
            if (dictionarySet.contains(subString)) {
                dp[i] = true;
            }
        }

        if (dp[len - 1]) return 1;

        for (int i = 0; i < len; ++i) {
            if (!dp[i]) {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && dictionarySet.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[len - 1] ? 1 : 0;
    }
}