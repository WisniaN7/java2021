package pl.edu.uj.javaframe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cryptographer {
    static void cryptfile(String pathInput, String pathOutput, Algorithm algorithm) {
        try {
            File input = new File(pathInput);
            FileWriter output = new FileWriter(pathOutput);
            Scanner myReader = new Scanner(input);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split(" ");

                for (String word : words)
                    output.write(algorithm.crypt(word) + ' ');

                output.write('\n');
            }

            myReader.close();
            output.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void decryptfile(String pathInput, String pathOutput, Algorithm algorithm) {
        try {
            File input = new File(pathInput);
            FileWriter output = new FileWriter(pathOutput);
            Scanner myReader = new Scanner(input);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split(" ");

                for (String word : words)
                    output.write(algorithm.decrypt(word) + ' ');

                output.write('\n');
            }


            myReader.close();
            output.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
