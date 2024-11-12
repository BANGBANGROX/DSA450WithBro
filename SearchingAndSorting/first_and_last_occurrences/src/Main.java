//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


// } Driver Code Ends
// User function Template for Java

class GFG {
    private int[] arr;
    private int x;

    private int findFirstIndex() {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (arr[mid] == x) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private int findLastIndex() {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (arr[mid] == x) {
                answer = mid;
                left = mid + 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public ArrayList<Integer> find(int[] arr, int x) {
        // code here
        this.arr = arr;
        this.x = x;

        return new ArrayList<>(Arrays.asList(findFirstIndex(), findLastIndex()));
    }
}


//{ Driver Code Starts.

// Driver class
public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends