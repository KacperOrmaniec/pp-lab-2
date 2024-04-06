import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sredniaMatematyka = 0.0;
        double sredniaChemia = 0.0;
        double sredniaFizyka = 0.0;
        double sredniaInformatyka = 0.0;

        // Tablica nazw przedmiotów
        String[] przedmioty = {"matematyki", "chemii", "fizyki", "informatyki"};

        // Pętla dla każdego przedmiotu
        for (String przedmiot : przedmioty) {
            if (czyWprowadzicOceny(scanner, przedmiot)) {
                System.out.println("Podaj oceny z " + przedmiot + ":");
                double[] oceny = wprowadzOceny(scanner);
                wyswietlOcenyISrednia(oceny);
                
                // Obliczanie średniej dla danego przedmiotu
                switch (przedmiot) {
                    case "matematyki":
                        sredniaMatematyka = obliczSrednia(oceny);
                        break;
                    case "chemii":
                        sredniaChemia = obliczSrednia(oceny);
                        break;
                    case "fizyki":
                        sredniaFizyka = obliczSrednia(oceny);
                        break;
                    case "informatyki":
                        sredniaInformatyka = obliczSrednia(oceny);
                        break;
                }
            }
        }

        // Wyświetl średnie ocen
        if (sredniaMatematyka != 0.0) {
            System.out.println("Średnia ocen z matematyki: " + sredniaMatematyka);
        }
        if (sredniaChemia != 0.0) {
            System.out.println("Średnia ocen z chemii: " + sredniaChemia);
        }
        if (sredniaFizyka != 0.0) {
            System.out.println("Średnia ocen z fizyki: " + sredniaFizyka);
        }
        if (sredniaInformatyka != 0.0) {
            System.out.println("Średnia ocen z informatyki: " + sredniaInformatyka);
        }

        scanner.close();
    }

    // Metoda do wprowadzania ocen i zapisywania ich w tablicy
    public static double[] wprowadzOceny(Scanner scanner) {
        System.out.println("Ile ocen chcesz wprowadzić?");
        int liczbaOcen = scanner.nextInt();

        double[] oceny = new double[liczbaOcen];

        for (int i = 0; i < liczbaOcen; i++) {
            System.out.println("Podaj ocenę " + (i + 1) + ":");
            oceny[i] = scanner.nextDouble();
        }

        return oceny;
    }

    // Metoda do obliczania średniej z tablicy ocen
    public static double obliczSrednia(double[] oceny) {
        double suma = 0;

        for (double ocena : oceny) {
            suma += ocena;
        }

        return suma / oceny.length;
    }

    // Metoda do wyświetlania ocen oraz ich sumy
    public static void wyswietlOcenyISrednia(double[] oceny) {
        System.out.println("Oceny:");
        double suma = 0;

        for (int i = 0; i < oceny.length; i++) {
            System.out.println("Ocena " + (i + 1) + ": " + oceny[i]);
            suma += oceny[i];
        }

        System.out.println("Suma ocen: " + suma);
        System.out.println("Średnia ocen: " + (suma / oceny.length));
    }

    public static boolean czyWprowadzicOceny(Scanner scanner, String przedmiot) {
        System.out.println("Czy chcesz wprowadzić oceny z przedmiotu " + przedmiot + "? (tak/nie)");
        String odpowiedz = scanner.next();
        return odpowiedz.equalsIgnoreCase("tak");
    }
}
