import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TimeMap {
    private final Map<String, List<Integer>> keyTimestamps;
    private final Map<String, String> keyAndTimestampsValue;
    private final String HASH = "#";

    public TimeMap() {
        keyTimestamps = new HashMap<>();
        keyAndTimestampsValue = new HashMap<>();
    }

    private int lowerBound(List<Integer> timestamps, int key) {
        int left = 0;
        int right = timestamps.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (timestamps.get(mid) <= key) {
                result = timestamps.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public void set(String key, String value, int timestamp) {
        String finalKey = key + HASH + timestamp;

        keyTimestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        keyAndTimestampsValue.put(finalKey, value);
    }

    public String get(String key, int timestamp) {
        int requiredTimestamp = lowerBound(keyTimestamps.getOrDefault(key,
                new ArrayList<>()), timestamp);

        String EMPTY_STRING = "";
        if (requiredTimestamp == -1) return EMPTY_STRING;

        String finalKey = key + HASH +requiredTimestamp;

        return keyAndTimestampsValue.getOrDefault(finalKey, EMPTY_STRING);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           TimeMap timeMap = new TimeMap();

           timeMap.set("1", "1", 1);
           System.out.println(timeMap.get("1", 1));
       }
       
       scanner.close();
   }
}
