package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int number;
    private final Position position;

    public Ball(int number, int position) {
        validateNumber(number);
        this.number = number;
        this.position = new Position(position);
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1 ~ 9 숫자이어야만 합니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public boolean isStrike(Ball anotherBall) {
        if (this.equals(anotherBall)) {
            return true;
        }
        return false;
    }

    public boolean isBall(Ball anotherBall) {
        if (this.number == anotherBall.getNumber()) {
            return true;
        }
        return false;
    }

    public Status count(Ball anotherBall) {
        if (this.isStrike(anotherBall)) {
            return Status.STRIKE;
        }
        if (this.isBall(anotherBall)) {
            return Status.BALL;
        }
        return Status.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return getNumber() == ball.getNumber() && Objects.equals(getPosition(), ball.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getPosition());
    }
}
