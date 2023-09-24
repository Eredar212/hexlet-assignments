package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());
        return keySet.stream()
                .collect(Collectors.toMap(k -> k, v -> getDiff(data1, data2, v), (v1, v2) -> v1, LinkedHashMap::new));
    }
    public static String getDiff(Map<String, Object> data1, Map<String, Object> data2, String key) {
        if (data1.containsKey(key) && data2.containsKey(key)) {
            if (data1.get(key).equals(data2.get(key))) {
                return "unchanged";
            } else {
                return "changed";
            }
        } else {
            return data1.containsKey(key) ? "deleted" : "added";
        }
    }
}
//END
