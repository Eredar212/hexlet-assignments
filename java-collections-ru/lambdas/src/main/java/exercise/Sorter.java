package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        Function<Map<String, String>, LocalDate> getBD = (user) -> LocalDate.parse(user.get("birthday"));
        Predicate<Map<String, String>> isMale = (user) -> user.get("gender").equals("male");
        Function<Map<String, String>, String> getName = user -> user.get("name");
        return users.stream()
                .filter(isMale)
                .sorted(Comparator.comparing(getBD))
                .map(getName)
                .collect(Collectors.toList());
    }
}
// END
