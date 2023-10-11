package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        // "<p id="abc">Text paragraph</p>"
        //<div class="y-5"><br id="s"><hr class="a-5"></div>
        return super.toString() + body + children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining())
                + "</" + getName() + ">";
    }
}
// END
