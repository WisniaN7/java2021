package pl.edu.uj.javaframe;

public class ImaginaryDouble extends MyDouble {
    private MyDouble im;

    @Override
    public Value create(String val) {
        String[] num = val.split("i");

        ImaginaryDouble v = new ImaginaryDouble();
        v.value = super.create(num[0]).value;

        if (num.length > 1) {
            v.im = (MyDouble) new MyDouble().create(num[1]);
        } else {
            v.im = (MyDouble) new MyDouble().create("0");
        }

        return v;
    }

    @Override
    public Value add(Value v) {
        ImaginaryDouble result  = new ImaginaryDouble();
        ImaginaryDouble other = (ImaginaryDouble)v;

        result.value = (Double)this.value + (Double)v.value;
        result.im = (MyDouble)im.add(other.im);

        return result;
    }

    public String toString() {
        return this.value + "i" + im;
    }
}
