//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int[] array = new int[N];
            Map<Integer, Integer> mp = new HashMap<>();

            String[] input_line = read.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input_line[i]);
                if (mp.containsKey(array[i])) {
                    mp.put(array[i], mp.get(array[i]) + 1);
                } else {
                    mp.put(array[i], 1);
                }
            }

            input_line = read.readLine().trim().split(" ");
            int a = Integer.parseInt(input_line[0]);
            int b = Integer.parseInt(input_line[1]);

            int[] original = new int[N];

            System.arraycopy(array, 0, original, 0, N);

            int k1 = 0, k2 = 0, k3 = 0;
            int kk1 = 0;
            int kk2 = 0;
            int kk3 = 0;

            for (int i = 0; i < N; i++) {
                if (original[i] > b)
                    k3++;
                else if (original[i] <= b && original[i] >= a)
                    k2++;
                else if (original[i] < b)
                    k1++;
            }
            Solution ob = new Solution();
            ob.threeWayPartition(array, a, b);

            for (int i = 0; i < k1; i++) {
                if (array[i] < b)
                    kk1++;
            }

            for (int i = k1; i < k1 + k2; i++) {
                if (array[i] <= b && array[i] >= a)
                    kk2++;

            }

            for (int i = k1 + k2; i < k1 + k2 + k3; i++) {
                if (array[i] > b)
                    kk3++;
            }
            boolean ok = k1 == kk1 && k2 == kk2 && k3 == kk3;

            for (int k : array) mp.put(k, mp.get(k) - 1);

            for (int j : array)
                if (mp.get(j) != 0)
                    ok = false;

            if (ok)
                System.out.println(1);
            else
                System.out.println(0);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int[] nums, int a, int b) {
        // code here
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int itr = 0;

        while (itr < n && j >= itr) {
            if (nums[itr] < a) {
                int temp = nums[itr];
                nums[itr] = nums[i];
                nums[i] = temp;
                ++itr;
                ++i;
            } else if (nums[itr] > b) {
                int temp = nums[itr];
                nums[itr] = nums[j];
                nums[j] = temp;
                --j;
            } else {
                ++itr;
            }
        }
    }
}
