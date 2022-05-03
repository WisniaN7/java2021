package pl.edu.uj.javaframe;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Delay.delay(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } catch (DelayExeption | ArithmeticException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unhandled exception");
            e.printStackTrace();
        }
    }
}
