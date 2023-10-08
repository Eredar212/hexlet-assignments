package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        if (!map.isEmpty()) {
            this.map.putAll(map);
        }
    }

    @Override
    public void set(String key, String value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
        } else {
            map.put(key, value);
        }
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
