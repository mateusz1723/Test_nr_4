package pl.kurs.zad5;

import java.time.Duration;
import java.time.LocalDate;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InvalidBirthDateException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj date w formacie YYYY-MM-dd");

        LocalDate today = LocalDate.now();
        LocalDate dayOfBorn = LocalDate.parse(sc.nextLine());

        if (dayOfBorn.isAfter(today))
            throw new InvalidBirthDateException("Data nie moze byc pozniejsza niz dzis");
        else {
            Duration days = Duration.between(dayOfBorn.atStartOfDay(), today.atStartOfDay());
            double months = (days.toDays() / 7) / 4.348_048_941_798_9;
            int years = (int) (months / 12);

            System.out.println("Zyjesz : " + days.toDays() + " dni");
            System.out.println("Zyjesz : " + months + " miesiecy");
            System.out.println("Zyjesz : " + years + " lat");
            System.out.println("Urodziles sie w " + dayOfBorn.getDayOfWeek().getValue() + " dzien tygodnia");

        }
        sc.close();
    }
}
