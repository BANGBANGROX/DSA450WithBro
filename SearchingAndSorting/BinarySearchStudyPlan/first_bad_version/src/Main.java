import java.util.Scanner;

class VersionControl {
    private final int badVersion;

    VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

class Solution extends VersionControl {
    Solution(int badVersion) {
        super(badVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (isBadVersion(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int totalVersions = scanner.nextInt();
           int badVersion = scanner.nextInt();
           Solution solution = new Solution(badVersion);
           System.out.println(solution.firstBadVersion(totalVersions));
       }
       
       scanner.close();
   }
}
