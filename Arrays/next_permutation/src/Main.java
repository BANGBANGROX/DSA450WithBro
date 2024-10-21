//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int j : arr) {
                out.append(j).append(" "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private void reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            ++left;
            --right;
        }
    }

    public void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int last = n - 2;

        while (last >= 0 && arr[last + 1] <= arr[last]) {
            --last;
        }

        if (last < 0) {
            reverseArray(arr, 0, n - 1);
            return;
        }

        int idx = last + 1;

        for (int i = last + 2; i < n; ++i) {
            if (arr[i] <= arr[idx] && arr[i] > arr[last]) {
                idx = i;
            }
        }

        int temp = arr[last];
        arr[last] = arr[idx];
        arr[idx] = temp;

        reverseArray(arr, last + 1, n - 1);
    }
}