//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for (String an : ans) {
                out.print(an + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    private void reverse(char[] currentWord, int left, int right) {
        while (left < right) {
            char temp = currentWord[left];
            currentWord[left] = currentWord[right];
            currentWord[right] = temp;
            ++left;
            --right;
        }
    }

    private boolean nextPermutation(char[] currentWord, int n) {
        int last = n - 2;

        while (last >= 0 && currentWord[last + 1] <= currentWord[last]) {
            --last;
        }

        if (last < 0) return false;

        int next = last + 1;

        for (int i = last + 2; i < n; ++i) {
            if (currentWord[i] > currentWord[last] && currentWord[i] <= currentWord[next]) {
                next = i;
            }
        }

        char temp = currentWord[last];
        currentWord[last] = currentWord[next];
        currentWord[next] = temp;

        reverse(currentWord, last + 1, n - 1);

        return true;
    }

    public List<String> find_permutation(String s) {
        // Code here
        TreeSet<String> answer = new TreeSet<>();
        char[] currentWord = s.toCharArray();

        Arrays.sort(currentWord);

        do {
            answer.add(new String(currentWord));
        } while (nextPermutation(currentWord, currentWord.length));

        return new ArrayList<>(answer);
    }
}