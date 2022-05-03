package pl.edu.uj.javaframe;

public class Main {
    public static void main(String[] args) {
        DataFrame df = new DataFrame(new Class[] {Int.class, MyDouble.class}, new String[] {"Int","Double"});

        for (int i = 0; i < 20; i++) {
            int a = i + 1;
            double b = i + 1;
            df.addRow(new String[]{String.valueOf(a), String.valueOf(b)});
        }

        df.head();

        Adder add = new Adder("10");
        df.apply(add, "Int", 5);
        df.head();
    }
}