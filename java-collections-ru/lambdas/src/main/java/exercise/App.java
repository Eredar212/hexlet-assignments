package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] matrix) {
        int size = matrix.length;
        if (size == 0) {
            return new String[0][0];
        }
        return Arrays.asList(matrix).stream()
                .map(s -> Arrays.asList(s))
                .map(s -> s.stream()
                        .map(s1 -> List.of(s1, s1))
                        .flatMap(s2 -> s2.stream())
                        .toArray(String[]::new))
                .map(s -> List.of(s, s))
                .flatMap(s -> s.stream())
                .toArray(String[][]::new);
    }
}
// END
