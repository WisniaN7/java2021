package pl.edu.uj.kolos;

import java.util.ArrayList;

public class BagOfShapes extends Shape {
    ArrayList<Shape> shapes = new ArrayList<>(); // Nie było sprecyzowane, czy publiczna, czy prywatna, więc zostawią pakietową, dla łatwości dostępu

    public BagOfShapes() {
        setName("Bag");
    }

    public double calculateSurfaceArea() {
        double sum = 0;

        for (Shape shape : shapes)
            sum += shape.calculateSurfaceArea();

        return sum;
    }

    public double calculatePerimeter() {
        double sum = 0;

        for (Shape shape : shapes)
            sum += shape.calculatePerimeter();

        return sum;
    }

    public String getName() {
        StringBuilder names = new StringBuilder();

        for (Shape shape : shapes)
            names.append(shape.getName()).append("\n");

        return names.toString();
    }

    public Shape scale(double scalingFactor) throws ScalingFactorException {
        for (Shape shape : shapes)
            shape.scale(scalingFactor);

        return this;
    }
}
