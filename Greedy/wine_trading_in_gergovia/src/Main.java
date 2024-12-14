import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public long getMinimumAmountOfWork(int[] requirements) {
        int n = requirements.length;
        int ptr1 = 0;
        int ptr2 = 0;
        long answer = 0;
        List<Integer> sellers = new ArrayList<>();
        List<Integer> buyers = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (requirements[i] < 0) {
                buyers.add(i);
            } else {
                sellers.add(i);
            }
        }

        while (ptr1 < sellers.size() && ptr2 < buyers.size()) {
            int distance = Math.abs(sellers.get(ptr1) - buyers.get(ptr2));
            if (requirements[sellers.get(ptr1)] <= -1 * requirements[buyers.get(ptr2)]) {
                answer += ((long) distance * requirements[sellers.get(ptr1)]);
                requirements[buyers.get(ptr2)] += requirements[sellers.get(ptr1)];
                requirements[sellers.get(ptr1)] = 0;
                ++ptr1;
            } else {
                answer += ((long) distance * (-1 * requirements[buyers.get(ptr2)]));
                requirements[sellers.get(ptr1)] += requirements[buyers.get(ptr2)];
                requirements[buyers.get(ptr2)] = 0;
                ++ptr2;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       while (true) {
           int n = scanner.nextInt();
           if (n == 0) break;
           int[] requirements = new int[n];
           for (int i = 0; i < n; ++i) {
               requirements[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getMinimumAmountOfWork(requirements));
       }

       scanner.close();
   }
}
