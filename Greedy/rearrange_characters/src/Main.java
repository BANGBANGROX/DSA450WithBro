//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String str = br.readLine();
                Solution ob = new Solution();
                String str1 = ob.rearrangeCharacters(str);

                int flag = 1;
                int[] c = new int[26];
                Arrays.fill(c, 0);
                for (int i = 0; i < str.length(); i++)
                    c[str.charAt(i) - 'a'] += 1;
                int f = 0;
                int x = (str.length() + 1) / 2;
                for (int i = 0; i < 26; i++) {
                    if (c[i] > x) {
                        f = 1;
                        break;
                    }
                }
                if (f == 1) {
                    if (Objects.equals(str1, "-1"))
                        System.out.println(0);
                    else
                        System.out.println(1);
                } else {
                    int[] a = new int[26];
                    Arrays.fill(a, 0);
                    int[] b = new int[26];
                    Arrays.fill(b, 0);
                    for (int i = 0; i < str.length(); i++)
                        a[str.charAt(i) - 'a'] += 1;
                    for (int i = 0; i < str1.length(); i++)
                        b[str1.charAt(i) - 'a'] += 1;

                    for (int i = 0; i < 26; i++) {
                        if (a[i] != b[i]) {
                            flag = 0;
                            break;
                        }
                    }

                    for (int i = 0; i < str1.length(); i++) {
                        if (i > 0)
                            if (str1.charAt(i - 1) == str1.charAt(i))
                                flag = 0;
                    }
                    if (flag == 1)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }

                System.out.println("~");
            }
        } catch (Exception ignored) {

        }
    }
}
// } Driver Code Ends


class Solution {
    public String rearrangeCharacters(String s) {
        //code here
        int[] count = new int[26];
        int n = s.length();
        char maxCntChar = '#';

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
            if (maxCntChar == '#' || count[ch - 'a'] > count[maxCntChar - 'a']) {
                maxCntChar = ch;
            }
        }

        StringBuilder answer = new StringBuilder();

        answer.append(maxCntChar);
        --count[maxCntChar - 'a'];

        for (int i = 1; i < n; ++i) {
            char nextChar = '#';
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (count[ch - 'a'] > 0 && ch != maxCntChar) {
                    if (nextChar == '#' || count[ch - 'a'] > count[nextChar - 'a']) {
                        nextChar = ch;
                    }
                }
            }
            if (nextChar == '#') return "-1";
            maxCntChar = nextChar;
            answer.append(maxCntChar);
            --count[maxCntChar - 'a'];
        }

        // System.out.println(answer.toString());

        return answer.toString();
    }
}