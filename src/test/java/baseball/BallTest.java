package baseball;

import baseball.domain.Ball;
import baseball.domain.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BallTest {
    Ball ball;

    @BeforeEach
    void init() {
        ball = new Ball(1,1);
    }

    @Test
    void 볼_생성() {
        assertAll(
                () -> assertThat(ball.getNumber()).isEqualTo(1),
                () -> assertThat(ball.getPosition()).isEqualTo(1));
    }

    @Test
    void 볼_생성_에러() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new Ball(1,4))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() ->
                        new Ball(0,1))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 스트라이크() {
        Ball anotherBall = new Ball(1,1);
        assertThat(ball.isStrike(anotherBall)).isTrue();
    }

    @Test
    void 볼() {
        Ball anotherBall = new Ball(1,2);
        assertThat(ball.isBall(anotherBall)).isTrue();
    }

    @Test
    void 카운트() {
        Ball strikeBall = new Ball(1,1);
        Ball ballBall = new Ball(1,2);
        Ball nothingBall = new Ball(5,2);

        assertAll(
                () -> assertThat(ball.count(strikeBall)).isEqualTo(Status.STRIKE),
                () -> assertThat(ball.count(ballBall)).isEqualTo(Status.BALL),
                () -> assertThat(ball.count(nothingBall)).isEqualTo(Status.NOTHING));
    }
}
