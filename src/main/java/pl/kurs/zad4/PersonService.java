package pl.kurs.zad4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
    public PersonService() {
    }

    public Person getOldestWoman(List<Person> personList) throws NoWomenException {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getName()))
                .filter(x -> x.getName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Brak kobiet na liscie"));
    }

    public double getAVGAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getAge()))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public double getAVGWomenAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getAge()))
                .filter(x -> x.getName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));

    }

    public double getAVGMenAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getAge()))
                .filter(x -> !x.getName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public double getAVGAgeBySex(List<Person> personList, Predicate<Person> sex) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getAge()))
                .filter(sex)
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public List<String> getCityWhereIsTheMostPeople(List<Person> personList) {

        Set<Map.Entry<String, Long>> entrySet = Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet();


        long max = entrySet.stream()
                .mapToLong(Map.Entry::getValue)
                .max()
                .orElse(0L);


        return entrySet.stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getDifferentCitiesFromList(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
    }
}
