//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for (String i : ans)
                System.out.print(i + " ");
            System.out.println();


            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> answer = new ArrayList<>();
        int n = s.length();

        for (int mask = 1; mask < (1 << n); ++mask) {
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) > 0) {
                    current.append(s.charAt(i));
                }
            }
            answer.add(current.toString());
        }

        return answer;
    }
}