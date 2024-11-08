//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));


            System.out.println("~");
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString(String s) {
        // Your code goes here
        int[] count = new int[256];
        int n = s.length();
        int answer = n;
        int left = 0;
        int totalUniqueCharacters = 0;
        int currentUniqueCharacters = 0;

        for (char ch : s.toCharArray()) {
            ++count[ch];
            if (count[ch] == 1) ++totalUniqueCharacters;
        }

        count = new int[256];

        for (int right = 0; right < n; ++right) {
            ++count[s.charAt(right)];
            if (count[s.charAt(right)] == 1) {
                ++currentUniqueCharacters;
            }
            if (currentUniqueCharacters == totalUniqueCharacters) {
                while (currentUniqueCharacters == totalUniqueCharacters) {
                    --count[s.charAt(left)];
                    if (count[s.charAt(left)] == 0) --currentUniqueCharacters;
                    ++left;
                }
                answer = Math.min(answer, right - left + 1);
            }
        }

        return answer;
    }
}