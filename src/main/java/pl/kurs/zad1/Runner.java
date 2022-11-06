package pl.kurs.zad1;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        MinMax<Integer> minAndMax = MinMaxService.getMinAndMax(List.of(2, 1, 3, 4, 5, 9, 8));

        System.out.println("minAndMax.getMin() = " + minAndMax.getMin());
        System.out.println("minAndMax.getMax() = " + minAndMax.getMax());

        Student st1 = new Student("Ala", "Nowak");
        Student st2 = new Student("Ela", "Nowak");
        Student st3 = new Student("Ela", "Zab");
        Student st4 = new Student("Adam", "Nowak");

        List<Student> students = List.of(st1, st2, st3, st4);

        MinMax<Student> minAndMax1 = MinMaxService.getMinAndMax(students);

        System.out.println("minAndMax1.getMax() = " + minAndMax1.getMax());
        System.out.println("minAndMax1.getMin() = " + minAndMax1.getMin());

        MinMax<String> minAndMax2 = MinMaxService.getMinAndMax(List.of("Deadpool", "Superman", "Batman", "Thor", "Spiderman"));

        System.out.println("minAndMax2.getMin() = " + minAndMax2.getMin());
        System.out.println("minAndMax2.getMax() = " + minAndMax2.getMax());

    }
}
