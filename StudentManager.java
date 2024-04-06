import java.util.Scanner;
import java.util.Arrays;

public class StudentManager {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        double sredniaMatematyka = 0.0;
        double sredniaChemia = 0.0;
        double sredniaFizyka = 0.0;
        double sredniaInformatyka = 0.0;

        double medianaMatematyka = 0.0;
        double medianaChemia = 0.0;
        double medianaFizyka = 0.0;
        double medianaInformatyka = 0.0;

        // Tablica nazw przedmiotów
        String[] przedmioty = {"matematyki", "chemii", "fizyki", "informatyki"};

        // Pętla dla każdego przedmiotu
        for (String przedmiot : przedmioty) 
        {
            if (czyWprowadzicOceny(scanner, przedmiot)) 
            {
                System.out.println("Podaj oceny z " + przedmiot + ":");
                double[] oceny = wprowadzOceny(scanner);
                wyswietlOcenyISrednia(oceny);
                
                // Obliczanie średniej dla danego przedmiotu
                switch (przedmiot) 
                {
                    case "matematyki":
                        sredniaMatematyka = obliczSrednia(oceny);
                        medianaMatematyka = ObliczMediane(oceny);
                        break;
                    case "chemii":
                        sredniaChemia = obliczSrednia(oceny);
                        medianaChemia = ObliczMediane(oceny);
                        break;
                    case "fizyki":
                        sredniaFizyka = obliczSrednia(oceny);
                        medianaFizyka = ObliczMediane(oceny);
                        break;
                    case "informatyki":
                        sredniaInformatyka = obliczSrednia(oceny);
                        medianaInformatyka = ObliczMediane(oceny);
                        break;
                }
            }
        }

        // Wyświetl średnie ocen
        if (sredniaMatematyka != 0.0) {
            System.out.println("Średnia ocen z matematyki: " + sredniaMatematyka);
            System.out.println("Mediana ocen z matematyki: " + medianaMatematyka);
        }
        if (sredniaChemia != 0.0) {
            System.out.println("Średnia ocen z chemii: " + sredniaChemia);
            System.out.println("Mediana ocen z chemii: " + medianaChemia);
        }
        if (sredniaFizyka != 0.0) {
            System.out.println("Średnia ocen z fizyki: " + sredniaFizyka);
            System.out.println("Mediana ocen z fizyki: " + medianaFizyka);
        }
        if (sredniaInformatyka != 0.0) {
            System.out.println("Średnia ocen z informatyki: " + sredniaInformatyka);
            System.out.println("Mediana ocen z informatyki: " + medianaInformatyka);
        }

        scanner.close();
    }

    // Metoda do wprowadzania ocen i zapisywania ich w tablicy
    public static double[] wprowadzOceny(Scanner scanner) {
        System.out.println("Ile ocen chcesz wprowadzić?");
        int liczbaOcen = scanner.nextInt();

        double[] oceny = new double[liczbaOcen];

        for (int i = 0; i < liczbaOcen; i++) 
        {
            boolean poprawnaOcena = false;
            while (!poprawnaOcena) 
            {
                System.out.println("Podaj ocenę " + (i + 1) + ":");
                double ocena = scanner.nextDouble();
                if (ocena >= 1 && ocena <= 6)
                {
                    oceny[i] = ocena;
                    poprawnaOcena = true;
                } 
                else 
                {
                    System.out.println("Ocena musi być z zakresu od 1 do 6. Podaj ocenę ponownie.");
                }
            }
        }

        return oceny;
    }

    // Metoda do obliczania średniej z tablicy ocen
    public static double obliczSrednia(double[] oceny) 
    {
        double suma = 0;

        for (double ocena : oceny) 
        {
            suma += ocena;
        }

        return suma / oceny.length;
    }

    public static double ObliczMediane(double[] oceny) 
    {
        Arrays.sort(oceny);

        int length = oceny.length;

         // Sprawdzenie, czy liczba elementów w tablicy jest parzysta czy nieparzysta
         if (length % 2 == 0) {
            // Jeśli liczba elementów jest parzysta, mediana to średnia arytmetyczna dwóch środkowych wartości
            return (oceny[length / 2 - 1] + oceny[length / 2]) / 2.0;
        } else {
            // Jeśli liczba elementów jest nieparzysta, mediana to wartość środkowego elementu
            return oceny[length / 2];
        }
    }

    // Metoda do wyświetlania ocen oraz ich sumy
    public static void wyswietlOcenyISrednia(double[] oceny) 
    {
        System.out.println("Oceny:");
        double srednia = obliczSrednia(oceny);
        double suma = 0;
        double mediana = ObliczMediane(oceny);

        for (int i = 0; i < oceny.length; i++) 
        {
            System.out.println("Ocena " + (i + 1) + ": " + oceny[i]);
            suma += oceny[i];
        }

        System.out.println("Suma ocen: " + suma);
        System.out.println("Średnia ocen: " + srednia);
        System.out.println("Mediana ocen: " + mediana);

    }

    public static boolean czyWprowadzicOceny(Scanner scanner, String przedmiot) 
    {
        System.out.println("Czy chcesz wprowadzić oceny z przedmiotu " + przedmiot + "? (tak/nie)");
        String odpowiedz = scanner.next();
        return odpowiedz.equalsIgnoreCase("tak");
    }
}
