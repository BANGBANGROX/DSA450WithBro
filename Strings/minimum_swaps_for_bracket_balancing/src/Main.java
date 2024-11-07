//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int minimumNumberOfSwaps(String s) {
        // code here
        int openCnt = 0;
        int closeCnt = 0;
        int imbalance = 0;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                ++openCnt;
                if (imbalance > 0) {
                    answer += imbalance;
                }
            } else {
                ++closeCnt;
            }
            imbalance = (closeCnt - openCnt);
        }

        return answer;
    }
}