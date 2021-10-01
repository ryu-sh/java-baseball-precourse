package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Status;
import baseball.utils.StringUtils;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
    private static final String CONTINUE_CONDITION = "1";
    private static final String END_CONDITION = "2";
    private static final String THREE_STRIKE = "3스트라이크";

    public static void play(CreateNumberStrategy createNumberStrategy) {
        String condition = CONTINUE_CONDITION;

        while (!condition.equals(END_CONDITION)) {
            Balls computerBalls = new Balls(createNumberStrategy.createNumbers());
            condition = playGame(computerBalls);
        }
    }

    private static String playGame(Balls computerBalls) {
        String result = Status.NOTHING.value();

        while (!result.equals(THREE_STRIKE)) {
            String inputString = InputView.inputNumber();
            Balls myBalls;

            try {
                myBalls = new Balls(StringUtils.stringToIntegerList(inputString));
            } catch (IllegalArgumentException illegalArgumentException) {
                ResultView.printError(illegalArgumentException.getLocalizedMessage());
                continue;
            }

            result = computerBalls.calculate(myBalls);
            ResultView.printResult(result);
        }

        ResultView.printEndGame();
        return InputView.inputEndGame();
    }
}
