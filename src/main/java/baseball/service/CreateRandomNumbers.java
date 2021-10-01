package baseball.service;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CreateRandomNumbers implements CreateNumberStrategy{
    private static final int NUMBERS_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    @Override
    public List<Integer> createNumbers() {
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() < NUMBERS_LENGTH) {
            computerNumbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
        return new ArrayList<>(computerNumbers);
    }
}
