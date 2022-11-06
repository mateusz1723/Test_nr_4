package pl.kurs.zad3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {


        List<Integer> fiveBiggestElements = getFiveBiggestElements(List.of(1, 2, 40, 17));
        System.out.println(fiveBiggestElements);

    }

    public static List<Integer> getFiveBiggestElements(List<Integer> integers) {

        return Optional.ofNullable(integers)
                .orElseGet(Collections::emptyList)
                .stream()
                .takeWhile(integerList -> integers.size() >= 5)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
