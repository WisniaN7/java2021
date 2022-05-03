package pl.edu.uj.kolos;

public abstract class Shape {
    private String name;

    public abstract double calculateSurfaceArea();
    public abstract double calculatePerimeter();
    public String getName() { return name; }; // Taka sama dla każdego z dzieci, więc nie ma potrzeby by była abstakcyjna
    // public abstract String getName();
    public void setName(String name) { this.name = name; };
    public abstract Shape scale(double scalingFactor) throws ScalingFactorException;
}
