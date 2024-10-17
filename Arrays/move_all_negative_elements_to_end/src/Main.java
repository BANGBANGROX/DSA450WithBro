//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            int[] a = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            Solution ob = new Solution();
            ob.segregateElements(a);
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            T--;
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        int itr = 0;
        List<Integer> positiveElements = new ArrayList<>();
        List<Integer> negativeElements = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) {
                positiveElements.add(num);
            } else {
                negativeElements.add(num);
            }
        }

        for (int num : positiveElements) {
            arr[itr] = num;
            ++itr;
        }

        for (int num : negativeElements) {
            arr[itr] = num;
            ++itr;
        }
    }
}