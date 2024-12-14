import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private static class Key {
        int place;
        int health;
        int armor;

        Key(int place, int health, int armor) {
            this.place = place;
            this.health = health;
            this.armor = armor;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;

            if (!(o instanceof Key key)) return false;

            return this.place == key.place && this.health == key.health &&
                    this.armor == key.armor;
        }
    }

    private Map<Key, Integer> dp;

    private int getMaxTimeSurvivedHandler(int place, int health,
                                          int armor) {
        if (health <= 0 || armor <= 0) return 0;

        Key key = new Key(place, health, armor);

        if (dp.containsKey(key)) return dp.get(key);

        int result;

        if (place == 0) {
            result = Math.max(getMaxTimeSurvivedHandler(1, health - 5,
                    armor - 10), getMaxTimeSurvivedHandler(2, health - 20,
                    armor + 5)) + 1;
        } else if (place == 1) {
            result = Math.max(getMaxTimeSurvivedHandler(0, health + 3,
                    armor + 2), getMaxTimeSurvivedHandler(2, health - 20,
                    armor + 5)) + 1;
        } else {
            result = Math.max(getMaxTimeSurvivedHandler(0, health + 3,
                    armor + 2), getMaxTimeSurvivedHandler(1, health - 5,
                    armor - 10)) + 1;
        }

        dp.put(key, result);

        return result;
    }

    public int getMaxTimeSurvived(int health, int armor) {
        dp = new HashMap<>();

        return Math.max(getMaxTimeSurvivedHandler(0, health + 3, armor + 2),
                Math.max(getMaxTimeSurvivedHandler(1, health - 5,
                        armor - 10), getMaxTimeSurvivedHandler(2,
                        health - 20, armor + 5)));
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int health = scanner.nextInt();
           int armor = scanner.nextInt();

           System.out.println(new Solution().getMaxTimeSurvived(health, armor));
       }
       
       scanner.close();
   }
}
