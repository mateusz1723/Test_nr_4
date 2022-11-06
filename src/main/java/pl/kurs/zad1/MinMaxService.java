package pl.kurs.zad1;

import java.util.Collections;
import java.util.List;

public class MinMaxService {

    static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {

        T min = Collections.min(elements);
        T max = Collections.max(elements);

        return new MinMax<>(min, max);
    }
}
