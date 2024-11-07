//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();

            System.out.println(ob.minFlips(S));

        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    private String s;

    private int minFlipsWithStartingCharacter(char ch) {
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c != ch) ++result;
            ch = (char) (1 - (ch - '0') + '0');
        }

        return result;
    }

    public int minFlips(String s) {
        // Code here
        this.s = s;

        return Math.min(minFlipsWithStartingCharacter('0'), minFlipsWithStartingCharacter('1'));
    }
}