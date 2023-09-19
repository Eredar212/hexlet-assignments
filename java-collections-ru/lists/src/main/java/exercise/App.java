package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        String lowerCaseWord = word.toLowerCase(Locale.ROOT);
        char[] lettArr = letters.toCharArray();
        List<Character> lettList = new ArrayList<>();
        for (char c: lettArr) {
            lettList.add(c);
        }
        char[] wordArr = lowerCaseWord.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            if (!lettList.remove((Character) wordArr[i])) {
                return false;
            }
        }
        return true;
    }
}
//END
