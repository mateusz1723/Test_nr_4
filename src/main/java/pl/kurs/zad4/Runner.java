package pl.kurs.zad4;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws NoWomenException {

        PersonService personService = new PersonService();

        List<Person> people = List.of(
                new Person("Adam", "Nowak", "Warsaw", 24),
                new Person("Ewa", "Brzoza", "Warsaw", 27),
                new Person("Pawel", "Sularz", "Krakow", 35),
                new Person("Iwona", "Puszcz", "Gdansk", 17),
                new Person("Bartlomiej", "Bryza", "Szczecin", 40),
                new Person("Wioleta", "Kowalska", "Gdynia", 22),
                new Person("Damian", "Dab", "Gdansk", 28)
        );


        Person oldestWoman = personService.getOldestWoman(people);
        System.out.println("Najstarsza kobieta: " + oldestWoman);

        double avgAge = personService.getAVGAge(people);
        System.out.println("Sredni wiek wszystkich ludzi: " + avgAge);

        double avgWomenAge = personService.getAVGWomenAge(people);
        System.out.println("Sredni wiek wszystkich kobiet: " + avgWomenAge);

        double avgMenAge = personService.getAVGMenAge(people);
        System.out.println("Sredni wiek wszystkich mezczyzn: " + avgMenAge);

        List<String> cityWhereIsTheMostPeople = personService.getCityWhereIsTheMostPeople(people);
        System.out.println("Najwiecej ludzi jest w: " + cityWhereIsTheMostPeople);

        List<String> differentCitiesFromList = personService.getDifferentCitiesFromList(people);
        System.out.println("Miasta z listy osob:" + differentCitiesFromList);

        double avgBySex = personService.getAVGAgeBySex(people, x -> !x.getName().endsWith("a"));
        System.out.println("Sredni wiek kobiet badz mezczyzn: " + avgBySex);
    }
}
