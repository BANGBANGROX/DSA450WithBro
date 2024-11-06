//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
        Map<Character, Integer> value = new HashMap<>();
        int answer = 0;
        int n = s.length();

        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        for (int i = 0; i < n; ++i) {
            if (i + 1 < n && value.get(s.charAt(i)) < value.get(s.charAt(i + 1))) {
                answer += (value.get(s.charAt(i + 1)) - value.get(s.charAt(i)));
                ++i;
            } else {
                answer += value.get(s.charAt(i));
            }
        }

        return answer;
    }
}