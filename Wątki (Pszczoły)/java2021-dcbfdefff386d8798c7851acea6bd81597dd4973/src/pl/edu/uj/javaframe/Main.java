package pl.edu.uj.javaframe;

public class Main {
    public static void main(String[] args) {
        Bee [] bees = new Bee[3];
        Beehive hive = new Beehive();

        for (int i = 0; i < bees.length; i++) {
            bees[i] = new Bee(i + 1, hive);
            bees[i].start();
        }
    }
}
