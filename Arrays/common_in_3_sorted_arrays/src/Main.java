//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.isEmpty()) System.out.print(-1);
            for (Integer re : res) System.out.print(re + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private List<Integer> commonElementsHandler(List<Integer> nums1,
                                                List<Integer> nums2) {
        int i = 0;
        int j = 0;
        int m = nums1.size();
        int n = nums2.size();
        List<Integer> answer = new ArrayList<>();

        while (i < m && j < n) {
            while (i < m - 1 && Objects.equals(nums1.get(i), nums1.get(i + 1))) ++i;
            while (j < n - 1 && Objects.equals(nums2.get(j), nums2.get(j + 1))) ++j;
            if (Objects.equals(nums1.get(i), nums2.get(j))) {
                answer.add(nums1.get(i));
                ++i;
                ++j;
            } else if (nums1.get(i) < nums2.get(j)) {
                ++i;
            } else {
                ++j;
            }
        }

        return answer;
    }

    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        return commonElementsHandler(arr1, commonElementsHandler(arr2, arr3));
    }
}