package pl.edu.uj.kolos;

public class Rectangular extends Shape {
    private double x;
    private double y;
    private double w;
    private double h;

    public Rectangular(double x, double y, double w, double h) throws Exception {
        if (w <= 0 || h <= 0) throw new Exception("Invalid size");
        setName("Rect");
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public double calculateSurfaceArea() { return w * h; }
    public double calculatePerimeter() { return (2 * w) + (2 * h); }
    // public String getName() { return _name; }

    public Shape scale(double scalingFactor) throws ScalingFactorException {
        if (scalingFactor <= 0) throw new ScalingFactorException("Invalid scaling factor");
        w *= scalingFactor;
        h *= scalingFactor;
        return this;
    }
}
