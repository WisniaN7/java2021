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
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        result.value = (Integer)this.value + Integer.parseInt(v.value.toString());
        result.im = (Int)im.add(other.im);

        return result;
    }

    public String toString() {
        return this.value + "i" + im;
    }
}
