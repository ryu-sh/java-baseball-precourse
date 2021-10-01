package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int BALLS_SIZE = 3;
    private static final int START_POSITION = 1;
    private static final int NONE = 0;
    private static final int PLUS = 1;

    private List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> balls) {
        validateBalls(balls);
        inputBalls(balls);
    }

    private void inputBalls(List<Integer> balls) {
        for (int i = START_POSITION; i <= BALLS_SIZE; i++) {
            this.balls.add(new Ball(balls.get(i-1), i));
        }
    }

    private void validateBalls(List<Integer> balls) {
        if (balls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    public boolean isContainBall(Ball ball) {
        return balls.contains(ball);
    }

    public String calculate(Balls myBalls) {
        int strike = 0;
        int ball = 0;
        for (Ball computerBall : balls) {
            Status status = myBalls.count(computerBall);
            strike += checkStrike(status);
            ball += checkBall(status);
        }

        return Status.createResultStatusString(strike,ball);
    }

    private int checkBall(Status status) {
        if (status.equals(Status.BALL)) {
            return PLUS;
        }
        return NONE;
    }

    private int checkStrike(Status status) {
        if (status.equals(Status.STRIKE)) {
            return PLUS;
        }
        return NONE;
    }

    private Status count(Ball ball) {
        Status status = Status.NOTHING;
        int index = 0;
        while (status.equals(Status.NOTHING) && index < BALLS_SIZE) {
            Ball myBall = balls.get(index);
            status = myBall.count(ball);
            index++;
        }
        return status;
    }
}
