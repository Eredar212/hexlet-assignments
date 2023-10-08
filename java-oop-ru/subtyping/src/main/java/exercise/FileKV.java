package exercise;

// BEGIN
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(Path filePath, Map<String, String> map) {
        this.filePath = filePath.toString();
        Utils.writeFile(this.filePath, Utils.serialize(map));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> newMap = new HashMap<>(getMapFromFile());
        newMap.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(newMap));
    }

    @Override
    public void unset(String key) {
        Map<String, String> newMap = new HashMap<>(getMapFromFile());
        newMap.remove(key);
        Utils.writeFile(filePath, Utils.serialize(newMap));
    }

    @Override
    public String get(String key, String defaultValue) {
        return getMapFromFile().getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(getMapFromFile());
    }

    private Map<String, String> getMapFromFile() {
        return Utils.unserialize(Utils.readFile(filePath));
    }
}
// END
