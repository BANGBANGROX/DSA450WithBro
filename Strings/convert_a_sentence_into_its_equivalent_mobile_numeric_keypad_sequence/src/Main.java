//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0) {
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));

        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public String printSequence(String s) {
        // code here
        Map<Character, String> charToNumbersMap = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        charToNumbersMap.put('A', "2");
        charToNumbersMap.put('B', "22");
        charToNumbersMap.put('C', "222");
        charToNumbersMap.put('D', "3");
        charToNumbersMap.put('E', "33");
        charToNumbersMap.put('F', "333");
        charToNumbersMap.put('G', "4");
        charToNumbersMap.put('H', "44");
        charToNumbersMap.put('I', "444");
        charToNumbersMap.put('J', "5");
        charToNumbersMap.put('K', "55");
        charToNumbersMap.put('L', "555");
        charToNumbersMap.put('M', "6");
        charToNumbersMap.put('N', "66");
        charToNumbersMap.put('O', "666");
        charToNumbersMap.put('P', "7");
        charToNumbersMap.put('Q', "77");
        charToNumbersMap.put('R', "777");
        charToNumbersMap.put('S', "7777");
        charToNumbersMap.put('T', "8");
        charToNumbersMap.put('U', "88");
        charToNumbersMap.put('V', "888");
        charToNumbersMap.put('W', "9");
        charToNumbersMap.put('X', "99");
        charToNumbersMap.put('Y', "999");
        charToNumbersMap.put('Z', "9999");
        charToNumbersMap.put(' ', "0");

        for (char ch : s.toCharArray()) {
            answer.append(charToNumbersMap.get(ch));
        }

        return answer.toString();
    }
}