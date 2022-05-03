package pl.edu.uj.javaframe;

public class Main {
    public static void main(String[] args) {
        // Sprawdzanie ilości argumentów
        if (args.length < 1) {
            System.out.print("Error: Missing arguments: 'PESEL'");
            return;
        } else if (args.length > 1) {
            System.out.print("Warning: Too many arguments. Ignoring excess arguments");
        }

        PESEL pesel = new PESEL(args[0]);

        // Sprawdzenie długości
        if (pesel.pesel.length() != 11) {
            System.out.println("Invalid PESEL: Incorrect length");
            return;
        }

        // Sprawdzenie, czy składa się z samych liczb
        String regex = "[0-9]+";

        if (!pesel.pesel.matches(regex)) {
            System.out.println("Invalid PESEL: Contains letters");
        }

        // Obliczanie sumy kontrolnej
        int sum = 0;
        byte[] weight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.pesel.charAt(i)) * weight[i];
        }

        sum %= 10;

        if (sum != 0) {
            sum = 10 - sum;
        }

        if (Character.getNumericValue(pesel.pesel.charAt(10)) == sum) {
            System.out.println("PESEL number is correct");
        } else {
            System.out.println("PESEL number is incorrect");
        }
    }
}
