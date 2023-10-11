package exercise;

import java.util.Map;
import java.util.stream.Collectors;


// BEGIN
public class Tag {
    private String name;
    private Map<String, String> attributes;


    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String toString() {
        //<img class="v-10" id="wop">
        return "<" + name + attributes.entrySet().stream()
                .map(e -> " " + e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining("")) + ">";
    }
}
// END
