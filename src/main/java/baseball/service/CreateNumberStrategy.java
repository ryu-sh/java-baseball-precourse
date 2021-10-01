package baseball.service;

import java.util.List;

@FunctionalInterface
public interface CreateNumberStrategy {
    List<Integer> createNumbers();
}
