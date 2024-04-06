import java.util.Scanner;

public class StudentManager{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        //Oceny z matematyki
        System.out.println("Podaj oceny z matematyki:");
        double[] ocenyMatematyka = wprowadzOceny(scanner);
        
        //Oceny z chemii
        System.out.println("Podaj oceny z chemii:");
        double[] ocenyChemia = wprowadzOceny(scanner);
        
        //Oceny z fizyki
        System.out.println("Podaj oceny z fizyki:");
        double[] ocenyFizyka = wprowadzOceny(scanner);
        
        //Oceny z informatyki
        System.out.println("Podaj oceny z informatyki:");
        double[] ocenyInformatyka = wprowadzOceny(scanner);
        
        // Oblicz średnią ocen z każdego przedmiotu
        double sredniaMatematyka = obliczSrednia(ocenyMatematyka);
        double sredniaChemia = obliczSrednia(ocenyChemia);
        double sredniaFizyka = obliczSrednia(ocenyFizyka);
        double sredniaInformatyka = obliczSrednia(ocenyInformatyka);
        
        // Wyświetl średnie ocen
        System.out.println("Średnia ocen z matematyki: " + sredniaMatematyka);
        System.out.println("Średnia ocen z chemii: " + sredniaChemia);
        System.out.println("Średnia ocen z fizyki: " + sredniaFizyka);
        System.out.println("Średnia ocen z Informatyki: " + sredniaInformatyka);
        
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
}