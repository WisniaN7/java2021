package pl.edu.uj.javaframe;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Algorithm algorithm;

        if (Objects.equals(args[3], "rot")) {
            algorithm = new ROT11();
        } else if (Objects.equals(args[3], "Polibiusz")) {
            algorithm = new Polibiusz();
        } else {
            throw new IllegalArgumentException("Invalid algorithm argument");
        }

        if (Objects.equals(args[2], "crypt")) {
            Cryptographer.cryptfile(args[0], args[1], algorithm);
        } else if (Objects.equals(args[2], "decrypt")) {
            Cryptographer.decryptfile(args[0], args[1], algorithm);
        } else {
            throw new IllegalArgumentException("Invalid algorithm argument");
        }
    }
}
