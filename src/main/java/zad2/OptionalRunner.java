package zad2;

import java.time.LocalDateTime;
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

        if (pesel.charAt(2) == '8' || pesel.charAt(2) == '9')
            return "Urodziles sie w: 18" + date;
        if (pesel.charAt(2) == '0' || pesel.charAt(2) == '1')
            return "Urodziles sie w: 19" + date;
        if (pesel.charAt(2) == '2' || pesel.charAt(2) == '3')
            return "Urodziles sie w: 20" + date;
        if (pesel.charAt(2) == '4' || pesel.charAt(2) == '5')
            return "Urodziles sie w: 21" + date;
        if (pesel.charAt(2) == '6' || pesel.charAt(2) == '7')
            return "Urodziles sie w: 22" + date;
        else return "";
    }
}
