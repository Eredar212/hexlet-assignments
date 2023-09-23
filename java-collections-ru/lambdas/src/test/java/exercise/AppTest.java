package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
public class AppTest {
    @Test
    void test() {
        String[][] image = {
                {"*", "*"},
                {"*", " "}
        };
        String[][] expected = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", " ", " "},
                {"*", "*", " ", " "},
        };
        String[][] actual = App.enlargeArrayImage(image);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSize1() {
        String[][] image = {
                {"*"}
        };
        String[][] expected = {
                {"*", "*"},
                {"*", "*"}
        };
        String[][] actual = App.enlargeArrayImage(image);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEmpty() {
        String[][] image = new String[0][0];
        String[][] actual = App.enlargeArrayImage(image);
        assertThat(actual).isEqualTo(image);
    }

    @Test
    void testNotSquare() {
        String[][] image = {
                {"*", "*", "*"},
                {"*", " ", "*"}
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
        };
        String[][] actual = App.enlargeArrayImage(image);
        assertThat(actual).isEqualTo(expected);
    }
}
// END
