//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Integer[] arr = new Integer[(int) (n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Compute obj = new Compute();
            obj.sortBySetBitCount(arr, n);
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++)
                output.append(arr[i]).append(" ");
            System.out.println(output);


            System.out.println("~");
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    private int getSetBitsCount(int num) {
        int result = 0;

        while (num > 0) {
            result += (num % 2);
            num >>= 1;
        }

        return result;
    }

    public void sortBySetBitCount(Integer[] arr, int n) {
        // Your code goes here
        Arrays.sort(arr, (a, b) -> getSetBitsCount(b) - getSetBitsCount(a));
    }
}
