package baseball;

import baseball.domain.Ball;
import baseball.domain.Balls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,3"})
    void 볼_컬렉션_생성(int number, int position) {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        assertThat(balls.isContainBall(new Ball(number, position))).isTrue();
    }

    @Test
    void 볼_컬렉션_생성_체크() {
        assertThatThrownBy(() ->
                new Balls(Arrays.asList(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,1스트라이크 1볼", "1,4,5,1볼", "6,7,1,2볼", "2,1,6,1스트라이크", "7,1,3,3스트라이크"})
    void 숫자_계산(int number1, int number2, int number3, String expectedResult) {
        Balls myBalls = new Balls(Arrays.asList(7,1,3));
        Balls computerBalls = new Balls(Arrays.asList(number1,number2,number3));

        assertThat(computerBalls.calculate(myBalls)).isEqualTo(expectedResult);
    }

}
