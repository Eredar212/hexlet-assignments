package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static String getForwardedVariables(String config) {
        return Arrays.stream(config.split("\n"))
                .filter(string -> string.startsWith("environment="))
                .map(env -> env.split("\"")[1])
                .map(str -> str.split(","))
                .flatMap(s -> Arrays.stream(s))
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(env -> env.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
