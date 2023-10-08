package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> storageMap = storage.toMap();
        Set<Entry<String, String>> entrySet = storageMap.entrySet();
        //Set<String> newKeySet = (Set<String>) storageMap.values();
        for (Entry<String, String> entry: entrySet) {
            if (storageMap.containsValue(entry.getKey())) {
                storage.set(entry.getValue(), entry.getKey());
            } else {
                storage.unset(entry.getKey());
                storage.set(entry.getValue(), entry.getKey());
            }
        }
    }
}
// END
