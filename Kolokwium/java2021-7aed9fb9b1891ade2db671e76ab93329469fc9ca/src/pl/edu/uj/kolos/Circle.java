package pl.edu.uj.kolos;

public class Circle extends Shape {
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) throws Exception {
        if (r <= 0) throw new Exception("Invalid radius");
        setName("Circle");
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double calculateSurfaceArea() { return Math.PI * r * r; }
    public double calculatePerimeter() { return 2 * Math.PI * r; }
    // public String getName() { return _name; }

    public Shape scale(double scalingFactor) throws ScalingFactorException {
        if (scalingFactor <= 0) throw new ScalingFactorException("Invalid scaling factor");
        r *= scalingFactor;
        return this;
    }
}
