package pl.edu.uj.kolos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BagOfShapes bag = new BagOfShapes();

        int action;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. Dodaj prostokąt");
            System.out.println("2. Dodaj okrąg");
            System.out.println("3. Wyświetl pole powierzchni");
            System.out.println("4. Wyświetl obwód");
            System.out.println("5. Skaluj obiekty");
            System.out.println("6. Print names");
            System.out.println("7. Remove object of index");
            System.out.println("8. Exit");

            do {
                action = Integer.parseInt(reader.readLine());
            } while (action < 0 || action > 8);

            switch (action) {
                case 1 -> {
                    System.out.println("Enter x center coordinate: ");
                    double x = Double.parseDouble(reader.readLine());

                    System.out.println("Enter y center coordinate: ");
                    double y = Double.parseDouble(reader.readLine());

                    System.out.println("Enter width: ");
                    double w = Double.parseDouble(reader.readLine());

                    System.out.println("Enter height: ");
                    double h = Double.parseDouble(reader.readLine());

                    try {
                        bag.shapes.add(new Rectangular(x, y, w, h));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Enter x center coordinate: ");
                    double x = Double.parseDouble(reader.readLine());

                    System.out.println("Enter y center coordinate: ");
                    double y = Double.parseDouble(reader.readLine());

                    System.out.println("Enter radius: ");
                    double r = Double.parseDouble(reader.readLine());

                    try {
                        bag.shapes.add(new Circle(x, y, r));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> System.out.println(bag.calculateSurfaceArea());
                case 4 -> System.out.println(bag.calculatePerimeter());
                case 5 -> {
                    System.out.println("Enter scaling factor: ");
                    double sf = Double.parseDouble(reader.readLine());

                    try {
                        bag.scale(sf);
                    } catch (ScalingFactorException e) {
                        e.printStackTrace();
                    }
                }
                case 6 -> System.out.println(bag.getName());
                case 7 -> {
                    System.out.println("Enter index that you wish to remove: ");
                    int n = Integer.parseInt(reader.readLine());

                    bag.shapes.remove(n);
                }
            }

        } while (action != 8);
    }
}
