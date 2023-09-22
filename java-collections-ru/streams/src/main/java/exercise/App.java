package exercise;

import java.util.List;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List<String> domens = List.of("@gmail.com", "@yandex.ru", "@hotmail.com");
        int freeEmailsCount = (int) emails.stream()
                .filter(email -> findAny(email, domens))
                .count();
        return freeEmailsCount;
    }
    public static boolean findAny(String email, List<String> domens) {
        return domens.stream()
                .filter(dom -> email.contains(dom))
                .count() > 0;

    }
}
// END
