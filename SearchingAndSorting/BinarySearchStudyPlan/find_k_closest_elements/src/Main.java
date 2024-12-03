import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> (
                !Objects.equals(b.getFirst(), a.getFirst()) ? b.getFirst() - a.getFirst() : b.get(1) - a.get(1)));

        for (int num : nums) {
            int absoluteValue = Math.abs(x - num);
            if (pq.size() < k) pq.add(new ArrayList<>(Arrays.asList(absoluteValue, num)));
            else {
                ArrayList<Integer> top = pq.peek();
                assert top != null;
                if (absoluteValue <= top.get(0)) {
                    if (absoluteValue < top.get(0) || top.get(1) > num) {
                        pq.poll();
                        pq.add(new ArrayList<>(Arrays.asList(absoluteValue, num)));
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.peek().get(1));
            pq.poll();
        }

        Collections.sort(ans);

        return ans;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();
           int x = scanner.nextInt();

           System.out.println(new Solution().findClosestElements(nums, k, x));
       }
       
       scanner.close();
   }
}
