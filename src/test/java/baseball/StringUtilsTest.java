package baseball;

import baseball.utils.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


public class StringUtilsTest {
    @Test
    void 입력값_null_체크() {
        String nullString = null;
        Assertions.assertThatThrownBy(() ->
                StringUtils.stringToIntegerList(nullString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_빈값_체크() {
        String emptyString = "";
        Assertions.assertThatThrownBy(() ->
                StringUtils.stringToIntegerList(emptyString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_숫자_아닌경우_체크() {
        String notNumberString = "ryu";
        Assertions.assertThatThrownBy(() ->
                StringUtils.stringToIntegerList(notNumberString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_같은숫자__체크() {
        String dupleString = "111";
        Assertions.assertThatThrownBy(() ->
                StringUtils.stringToIntegerList(dupleString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1","2","3"})
    void 입력값_리스트_반환(int containValue) {
        String inputString = "123";
        List<Integer> result = StringUtils.stringToIntegerList(inputString);
        Assertions.assertThat(result.contains(containValue)).isTrue();
    }
}
