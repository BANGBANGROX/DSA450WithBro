//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }
            int K = Integer.parseInt(br.readLine());

            Complete obj = new Complete();
            int ans = obj.minSwap(arr, sizeOfArray, K);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Complete {
    // Function for finding maximum and value pair
    public int minSwap (int[] nums, int n, int k) {
        // Complete the function
        int subarraySize = 0;
        int greaterThanKElements = 0;

        for (int num : nums) {
            if (num <= k) ++subarraySize;
        }

        for (int i = 0; i < subarraySize; ++i) {
            if (nums[i] > k) ++greaterThanKElements;
        }

        int answer = greaterThanKElements;

        for (int right = subarraySize, left = 0; right < n; ++right, ++left) {
            if (nums[left] > k) --greaterThanKElements;
            if (nums[right] > k) ++greaterThanKElements;
            answer = Math.min(answer, greaterThanKElements);
        }

        return answer;
    }
}
