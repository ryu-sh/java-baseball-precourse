package baseball.domain;

public class Position {
    private static final int START_POSITION = 1;
    private static final int END_POSITION = 3;
    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < START_POSITION || position > END_POSITION) {
            throw new IllegalArgumentException("포지션은 1~3 사이의 숫자이어야만 합니다.");
        }
    }

    public int getValue() {
        return this.position;
    }
}
