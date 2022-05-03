package pl.edu.uj.javaframe;

public class Possition {
    private double x;
    private double y;

    public Possition(double x , double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
    public void print() { System.out.println("(" + x + ", " + y + ")"); }
}
