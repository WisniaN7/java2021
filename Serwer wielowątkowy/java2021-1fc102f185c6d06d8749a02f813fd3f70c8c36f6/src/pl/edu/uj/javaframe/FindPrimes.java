package pl.edu.uj.javaframe;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

// Java program to find the prime numbers
// between a given interval
public class FindPrimes extends Thread {
    PrintWriter out;
    BufferedReader in;

    public FindPrimes(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    // driver code
    public void run() {
        while (true) {
            String inputLine = null;

            try {
                inputLine = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (inputLine == null) break;

            String[] range = inputLine.split("\\s+");

            if (range.length != 2) {
                out.println("Invalid format (a b)");
                continue;
            }

            StringBuilder result = new StringBuilder();
            int a = Integer.parseInt(range[0]);
            int b = Integer.parseInt(range[1]);

            if (a > b) {
                out.println("Invalid format (a b): a cannot be greater than b");
                continue;
            }

            for (int i = a; i <= b; i++) {
                if (i == 1 || i == 0) continue;

                boolean flag = true;

                for (int j = 2; j <= i / 2; ++j) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) result.append(i).append(", ");
            }

            out.println("Primes in range " + a + " - " + b + ": " + result);
        }
    }
}