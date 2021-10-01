package baseball.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StringUtils {
    private static final int BALL_SIZE = 3;

    public static List<Integer> stringToIntegerList(String inputString) {
        validateInputString(inputString);
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            result.add(characterToNumber(inputString.charAt(i)));
        }
        validateDupleNumber(result);
        return new ArrayList<>(result);
    }

    private static void validateInputString(String inputString) {
        if (inputString == null || inputString.equals("")) {
            throw new IllegalArgumentException("null 또는 빈값을 입력하면 안됩니다.");
        }
        if (inputString.length() != BALL_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private static int characterToNumber(Character inputStringCharacter) {
        if (Character.isDigit(inputStringCharacter)) {
            return Integer.parseInt(inputStringCharacter + "");
        }
        throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }

    private static void validateDupleNumber(Set<Integer> result) {
        if (result.size() != BALL_SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }
}
