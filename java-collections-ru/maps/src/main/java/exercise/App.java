package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String text) {
        if (text == "") {
            return new HashMap<>();
        }
        String[] words = text.split(" ");
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word: words) {
            if (dictionary.containsKey(word)) {
                dictionary.replace(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }
        return dictionary;
    }
    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sp = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            sp.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sp.append("}");
        return sp.toString();
    }
}
//END
