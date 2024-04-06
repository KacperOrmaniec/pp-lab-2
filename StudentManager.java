import java.util.Scanner;

public class StudentManager{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        double sredniaMatematyka = 0.0;
        double sredniaChemia = 0.0;
        double sredniaFizyka  = 0.0;
        double sredniaInformatyka = 0.0;
        

        //Oceny z matematyki
        if (czyWprowadzicOceny(scanner, "matematyki"))
        {
            System.out.println("Podaj oceny z matematyki:");
            double[] ocenyMatematyka = wprowadzOceny(scanner);
            sredniaMatematyka = obliczSrednia(ocenyMatematyka);
        }
        
        //Oceny z chemii
        if (czyWprowadzicOceny(scanner, "chemii"))
        {
            System.out.println("Podaj oceny z chemii:");
            double[] ocenyChemia = wprowadzOceny(scanner);
            sredniaChemia = obliczSrednia(ocenyChemia);
        }
        
        //Oceny z fizyki
        if (czyWprowadzicOceny(scanner, "fizyki"))
        {
            System.out.println("Podaj oceny z fizyki:");
            double[] ocenyFizyka = wprowadzOceny(scanner);
            sredniaFizyka = obliczSrednia(ocenyFizyka);
        }
        
        //Oceny z informatyki
        if (czyWprowadzicOceny(scanner, "informatyki"))
        {
            System.out.println("Podaj oceny z informatyki:");
            double[] ocenyInformatyka = wprowadzOceny(scanner);
            sredniaInformatyka = obliczSrednia(ocenyInformatyka);
        }
        
        // Wyświetl średnie ocen
        if (sredniaMatematyka != 0.0)
        {
            System.out.println("Średnia ocen z matematyki: " + sredniaMatematyka);
        }
        if (sredniaChemia != 0.0)
        {
        System.out.println("Średnia ocen z chemii: " + sredniaChemia);
        }
        if (sredniaFizyka != 0.0)
        {
        System.out.println("Średnia ocen z fizyki: " + sredniaFizyka);
        }
        if (sredniaInformatyka != 0.0)
        {
        System.out.println("Średnia ocen z Informatyki: " + sredniaInformatyka);
        }
        
        scanner.close();
    }

     // Metoda do wprowadzania ocen i zapisywania ich w tablicy
     public static double[] wprowadzOceny(Scanner scanner) 
     {
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
    public static double obliczSrednia(double[] oceny) 
    {
        double suma = 0;
        
        for (double ocena : oceny) {
            suma += ocena;
        }
        
        return suma / oceny.length;
    }

    public static boolean czyWprowadzicOceny(Scanner scanner, String przedmiot) 
    {
        System.out.println("Czy chcesz wprowadzić oceny z przedmiotu " + przedmiot + "? (tak/nie)");
        String odpowiedz = scanner.next();
        return odpowiedz.equalsIgnoreCase("tak");
    }
}