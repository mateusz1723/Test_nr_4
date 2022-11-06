package pl.kurs.zad1;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        int result = name.compareTo(o.name);
        if (result == 0)
            result = surname.compareTo(o.surname);
        return result;
    }

}
