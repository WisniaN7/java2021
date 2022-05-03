package pl.edu.uj.javaframe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        World world;

        try {
            world = new World(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        } catch (BoundaryException e) {
            e.printStackTrace();
            return;
        }

        Robot robot = new Robot(new Possition(0, 0), world);

        int action;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. moveTo");
            System.out.println("2. moveBack");
            System.out.println("3. Print robot location");
            System.out.println("4. Exit");

            do {
                action = Integer.parseInt(reader.readLine());
            } while (action < 0 || action > 4);

            switch (action) {
                case 1 -> {
                    System.out.println("Input x possition: ");
                    double x = Integer.parseInt(reader.readLine());

                    System.out.println("Input y possition: ");
                    double y = Integer.parseInt(reader.readLine());

                    robot.MoveTo(new Possition(x, y), world);
                }
                case 2 -> {
                    System.out.println("Moving robot back");

                    try {
                        robot.MoveBack();
                    } catch (OutsideTheWorldException e) {
                        e.printStackTrace();
                        System.err.println("Of course TVA prevented that");
                    }
                }
                case 3 -> robot.getPossition().print();
            }

        } while (action != 4);
    }
}
