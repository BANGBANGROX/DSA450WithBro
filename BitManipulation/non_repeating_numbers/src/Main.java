//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public List<Integer> singleNumber(int[] arr) {
        // Code here
        int totalXor = 0;

        for (int num : arr) {
            totalXor ^= num;
        }

        int rightMostSetBit = totalXor & -totalXor;
        int num1 = 0;
        int num2 = 0;

        for (int num : arr) {
            if ((num & rightMostSetBit) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        if (num1 > num2) {
            num1 += num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
        }

        return List.of(num1, num2);
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.singleNumber(arr);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends