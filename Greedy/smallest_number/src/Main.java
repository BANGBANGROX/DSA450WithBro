//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if (s > 9 * d) return "-1";

        --s;

        char[] number = new char[d];

        for (int i = d - 1; i > 0; --i) {
            if (s > 9) {
                number[i] = '9';
                s -= 9;
            } else {
                number[i] = (char) (s + '0');
                s = 0;
            }
        }

        number[0] = (char) ((s + 1) + '0');

        return new String(number);
    }
}
