package pl.edu.uj.javaframe;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Delay {
    public static void delay(String in, String out, int delay, int fps) throws Exception {
        File input = new File(in);
        FileWriter output = new FileWriter(out);
        Scanner myReader = new Scanner(input);

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] components = line.split("}");

            int framesDelay = delay / fps;

            if (!Pattern.matches("[0-9]+", components[0].substring(1)) || !Pattern.matches("[0-9]+", components[1].substring(1))) throw new DelayExeption("Invalid frame format");
            int timeShow = Integer.parseInt(components[0].substring(1)) + framesDelay;
            int timeHide = Integer.parseInt(components[1].substring(1)) + framesDelay;

            if (timeShow > timeHide) throw new DelayExeption("Incorrect frame sequence");
            output.write("{" + timeShow + "}" + "{" + timeHide + "}" + components[2] + "\n");
        }

        myReader.close();
        output.close();
    }
}
