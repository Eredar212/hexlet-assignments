package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        assertThat(App.take(numbers1, 2)).isEqualTo(expect); // => [1, 2]

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> expect2 = new ArrayList<>();
        expect2.add(7);
        expect2.add(3);
        expect2.add(10);
        assertThat(App.take(numbers2, 3)).isEqualTo(expect2); // => [7, 3, 10]

        List<Integer> numbers3 = new ArrayList<>();
        assertThat(App.take(numbers3, 3)).isEmpty(); // => []

        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> expect4 = new ArrayList<>();
        expect4.add(1);
        expect4.add(2);
        assertThat(App.take(numbers4, 3)).isEqualTo(expect4); // => [1, 2]

        List<Integer> numbers5 = new ArrayList<>(Arrays.asList(10));
        assertThat(App.take(numbers5, 0)).isEmpty(); // => []
        // END
    }
}
