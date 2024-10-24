//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.findLongestConseqSubseq(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return length of longest subsequence of consecutive integers.
    public int findLongestConseqSubseq(int[] arr) {
        // code here
        Arrays.sort(arr);

        int n = arr.length;
        int currentLength = 1;
        int answer = 1;

        for (int i = 1; i < n; ++i) {
            if (arr[i] == arr[i - 1]) {
                ++currentLength;
            } else {
                answer = Math.max(answer, currentLength);
                currentLength = 1;
            }
        }

        answer = Math.max(answer, currentLength);

        return answer;
    }
}