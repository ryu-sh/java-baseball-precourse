package baseball;

import baseball.service.BaseballGame;
import baseball.service.CreateRandomNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseballGame.play(new CreateRandomNumbers());
    }
}
