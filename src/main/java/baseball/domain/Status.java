package baseball.domain;

public enum Status {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String statusString;

    Status(String statusString) {
        this.statusString = statusString;
    }

    public static String createResultStatusString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING.value();
        }
        if (strike != 0 && ball == 0) {
            return strike + STRIKE.value();
        }
        if (strike == 0 && ball != 0) {
            return ball + BALL.value();
        }
        return strike + STRIKE.value() + " " + ball + BALL.value();
    }

    public String value() {
        return statusString;
    }
}
