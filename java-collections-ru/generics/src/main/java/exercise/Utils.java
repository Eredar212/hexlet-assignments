package exercise;

import java.util.Map;

public class Utils {
    public static boolean find(Map<String, String> where, Map<String, String> what) {
        for (String key: what.keySet()) {
            if (!where.get(key).equals(what.get(key))) {
                return false;
            }
        }
        return true;
    }
}
