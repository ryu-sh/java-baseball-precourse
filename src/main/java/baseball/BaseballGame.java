package baseball;

import baseball.domain.Balls;
import baseball.domain.Status;
import baseball.utils.StringUtils;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
    private static final String END_CONDITION = "2";
    private static final String THREE_STRIKE = "3스트라이크";

    public static void play(CreateNumberStrategy createNumberStrategy) {
        String condition = "1";

        while (!condition.equals(END_CONDITION)) {
            Balls computerBalls = new Balls(createNumberStrategy.createNumbers());
            condition = playGame(computerBalls);
        }
    }

    private static String playGame(Balls computerBalls) {
        String result = Status.NOTHING.value();

        while (!result.equals(THREE_STRIKE)) {
            String inputString = InputView.inputNumber();
            Balls myBalls = new Balls(StringUtils.stringToIntegerList(inputString));
            result = computerBalls.calculate(myBalls);
            ResultView.printResult(result);
        }

        ResultView.printEndGame();
        return InputView.inputEndGame();
    }
}
