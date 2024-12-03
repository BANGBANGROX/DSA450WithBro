import java.util.Scanner;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = m;

        while (l <= r) {
            int cut1 = (l + ((r - l) >> 1));
            int cut2 = (m + n + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                return Math.max(left1, left2);
            }
            if (left1 > right2) r = cut1 - 1;
            else l = cut1 + 1;
        }

        return 0;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int[] nums1 = new int[m];
           for (int i = 0; i < m; ++i) {
               nums1[i] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int[] nums2 = new int[n];
           for (int i = 0; i < n; ++i) {
               nums2[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
       }
       
       scanner.close();
   }
}
