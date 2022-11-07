package pl.kurs.zad2;

import java.util.Optional;
import java.util.Scanner;

public class OptionalRunner {
    public static void main(String[] args) throws InvalidPeselException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj swoje imie");
        String name = sc.nextLine();

        Optional<String> opt1 = Optional.of(name);

        opt1.ifPresentOrElse(x -> System.out.println("Dlugosc imienia: " + x.length()), () -> System.out.println(0));

        System.out.println("Podaj pesel");
        String pesel = sc.nextLine();
        System.out.println(getDateOfBirth(pesel));


        sc.close();
    }

    public static String getDateOfBirth(String pesel) throws InvalidPeselException {
        pesel = Optional.ofNullable(pesel)
                .filter(x -> x.matches("\\d{11}"))
                .orElseThrow(() -> new InvalidPeselException("Pesel musi miec 11 znakow badz nie moze byc pusty/nullem"));
        return getYear(pesel);
    }

    private static String getYear(String pesel) {
        String date = pesel.substring(0, 2) + "-" + pesel.substring(2, 4) + "-" + pesel.substring(4, 6);

        char month = pesel.charAt(2);
        return switch (month) {
            case '0', '1' -> "Urodziles sie w: 19" + date;
            case '2', '3' -> "Urodziles sie w: 20" + date;
            case '4', '5' -> "Urodziles sie w: 21" + date;
            case '6', '7' -> "Urodziles sie w: 22" + date;
            case '8', '9' -> "Urodziels sie w: 18" + date;
            default -> null;
        };

    }
}
