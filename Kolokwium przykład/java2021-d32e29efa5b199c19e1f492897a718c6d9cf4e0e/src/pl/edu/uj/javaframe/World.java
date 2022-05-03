package pl.edu.uj.javaframe;

public class World {
    private final double sizeX;
    private final double sizeY;

    public  World(double x, double y) throws BoundaryException {
        if (x <= 0 || y <= 0) throw new BoundaryException("World size cannot be negative");
        this.sizeX = x;
        this.sizeY = y;
    }

    public double getSizeX() { return sizeX; }
    public double getSizeY() { return sizeY; }
}
