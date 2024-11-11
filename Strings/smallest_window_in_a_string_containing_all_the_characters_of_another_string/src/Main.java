//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        scan.nextLine(); // Consume the newline character after the integer input

        while (test > 0) {
            String s1 = scan.nextLine(); // Read first string on a new line
            String s2 = scan.nextLine(); // Read second string on a new line

            System.out.println(new Solution().smallestWindow(s1, s2));
            test--;
        }
    }
}

// } Driver Code Ends


class Solution {
    private boolean check(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i) {
            if (count1[i] < count2[i]) return false;
        }

        return true;
    }

    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public String smallestWindow(String s1, String s2) {
        // Your code here
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        int left = 0;
        int start = -1;
        int end = -1;
        int n = s1.length();

        for (char ch : s2.toCharArray()) {
            ++countS2[ch - 'a'];
        }

        for (int right = 0; right < n; ++right) {
            ++countS1[s1.charAt(right) - 'a'];
            if (check(countS1, countS2)) {
                while (left <= right && check(countS1, countS2)) {
                    --countS1[s1.charAt(left) - 'a'];
                    ++left;
                }
                if (start == -1 || (end - start + 1) > (right - left + 2)) {
                    start = left - 1;
                    end = right;
                }
            }
        }

        return start != -1 ? s1.substring(start, end + 1) : "-1";
    }
}