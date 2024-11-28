import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SnapshotArray {
    private final Map<String, Integer> map;
    private final Map<Integer, List<Integer>> indexSnaps;
    private final int length;
    private int currentSnapId;

    private String getKey(int index, int snapId) {
        String HASH = "#";

        return snapId + HASH + index;
    }

    public SnapshotArray(int length) {
        indexSnaps = new HashMap<>();
        map = new HashMap<>();
        this.length = length;
        currentSnapId = 0;

        for (int i = 0; i < length; ++i) {
            String key = getKey(i, currentSnapId);
            map.put(key, 0);
            indexSnaps.computeIfAbsent(i, k -> new ArrayList<>()).add(currentSnapId);
        }
    }

    public void set(int index, int val) {
        if (index >= length) return;

        String key = getKey(index, currentSnapId);
        map.put(key, val);

        List<Integer> currentIndexSnaps = indexSnaps.getOrDefault(index, List.of(currentSnapId));

        if (currentIndexSnaps.getLast() != currentSnapId) {
            currentIndexSnaps.add(currentSnapId);
        }
    }

    public int snap() {
        ++currentSnapId;

        return currentSnapId - 1;
    }

    private int lowerBound(List<Integer> snaps, int snapId) {
        int left = 0;
        int right = snaps.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (snaps.get(mid) <= snapId) {
                result = snaps.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int get(int index, int snapId) {
        int correctSnapId = lowerBound(indexSnaps.getOrDefault(index, new ArrayList<>()),
                snapId);

        if (correctSnapId == -1) return -1;

        String key = getKey(index, correctSnapId);

        return map.getOrDefault(key, -1);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           SnapshotArray snapshotArray = new SnapshotArray(1);

           snapshotArray.set(0, 1);
           System.out.println(snapshotArray.snap());
           System.out.println(snapshotArray.get(0, 0));
       }
       
       scanner.close();
   }
}
