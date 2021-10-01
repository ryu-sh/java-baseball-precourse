package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static List<Integer> stringToIntegerList(String inputString) {
        validateInputString(inputString);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            result.add(Integer.parseInt(inputString.charAt(i) + ""));
        }
        return result;
    }

    private static void validateInputString(String inputString) {
        if (inputString == null || inputString.equals("")) {
            throw new IllegalArgumentException("null 또는 빈값을 입력하면 안됩니다.");
        }
    }
}
