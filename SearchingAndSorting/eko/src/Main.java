import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] tree;
    private long woodNeeded;

    private boolean check(int height) {
        long woodCollected = 0;

        for (int currentHeight : tree) {
            if (currentHeight > height) {
                woodCollected += (currentHeight - height);
                if (woodCollected >= woodNeeded) return true;
            }
        }

        return false;
    }

    public int getMaxHeight(int[] tree, long woodNeeded) {
        this.tree = tree;
        this.woodNeeded = woodNeeded;
        int left = Arrays.stream(tree).min().getAsInt();
        int right = Arrays.stream(tree).max().getAsInt();
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long woodNeeded = scanner.nextLong();
        int[] tree = new int[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = scanner.nextInt();
        }

        System.out.println(new Solution().getMaxHeight(tree, woodNeeded));

        scanner.close();
    }
}
