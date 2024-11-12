//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution obj = new Solution();

            boolean a = obj.areIsomorphic(s1, s2);
            if (a)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to check if two strings are isomorphic.
    public boolean areIsomorphic(String s1, String s2) {
        // Your code here
        int m = s1.length();
        int n = s2.length();

        if (m != n) return false;

        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (!mapping.containsKey(ch1) && !reverseMapping.containsKey(ch2)) {
                mapping.put(ch1, ch2);
                reverseMapping.put(ch2, ch1);
            } else if (mapping.containsKey(ch1)) {
                if (mapping.get(ch1) != ch2) return false;
                if (!reverseMapping.containsKey(ch2) || reverseMapping.get(ch2) != ch1)
                    return false;
            } else if (reverseMapping.containsKey(ch2)) {
                if (reverseMapping.get(ch2) != ch2) return false;
                if (!mapping.containsKey(ch1) || mapping.get(ch1) != ch2)
                    return false;
            }
        }

        return true;
    }
}