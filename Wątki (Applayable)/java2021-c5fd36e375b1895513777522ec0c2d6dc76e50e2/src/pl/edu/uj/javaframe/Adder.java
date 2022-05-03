package pl.edu.uj.javaframe;

public class Adder implements Applayable {
    private final String toAdd;
    public Adder(String toAdd){
        this.toAdd = toAdd;
    }

    @Override
    public void apply(Series s) {
        for (int i = 0; i < s.values.size(); i++) {
            s.values.set(i, s.values.get(i).add(new Int().create(toAdd)));
        }
    }
}
