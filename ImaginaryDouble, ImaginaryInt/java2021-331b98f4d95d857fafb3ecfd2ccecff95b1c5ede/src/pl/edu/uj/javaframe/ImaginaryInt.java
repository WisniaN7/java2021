package pl.edu.uj.javaframe;

public class ImaginaryInt extends Int {
    private Int im;

    @Override
    public Value create(String val) {
        String[] num = val.split("i");

        ImaginaryInt v = new ImaginaryInt();
        v.value = super.create(num[0]).value;

        if (num.length > 1) {
            v.im = (Int) new Int().create(num[1]);
        } else {
            v.im = (Int) new Int().create("0");
        }

        return v;
    }

    @Override
    public Value add(Value v) {
        ImaginaryInt result  = new ImaginaryInt();
        ImaginaryInt other = (ImaginaryInt)v;

        result.value = (Integer)this.value + (Integer) v.value;
        result.im = (Int)im.add(other.im);

        return result;
    }

    public String toString() {
        return this.value + "i" + im;
    }
}
