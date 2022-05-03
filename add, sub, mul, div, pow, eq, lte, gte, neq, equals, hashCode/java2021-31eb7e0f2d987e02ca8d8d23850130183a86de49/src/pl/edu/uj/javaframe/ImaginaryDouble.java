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
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        result.value = (Double)this.value + Double.parseDouble(v.value.toString());
        result.im = (MyDouble) im.add(other.im);

        return result;
    }

    @Override
    public Value sub(Value v) {
        ImaginaryDouble result  = new ImaginaryDouble();
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        result.value = (Double)this.value - Double.parseDouble(v.value.toString());
        result.im = (MyDouble) im.sub(other.im);

        return result;
    }

    @Override
    public Value mul(Value v) {
        ImaginaryDouble result  = new ImaginaryDouble();
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        result.value = ((Double)this.value * (Double)other.value) - (Double.parseDouble(this.im.toString()) * Double.parseDouble(other.im.toString()));
        MyDouble thisDouble = (MyDouble) new MyDouble().create(String.valueOf(this.value));
        MyDouble otherDouble = (MyDouble) new MyDouble().create(String.valueOf(other.value));
        result.im = (MyDouble)thisDouble.mul((MyDouble)other.im).add((MyDouble)otherDouble.mul((MyDouble)this.im));

        return result;
    }

    @Override
    public Value div(Value v) { // Wiem, że bałagan, ale inaczej byłem w stanie sobie tego zwizualizować
        ImaginaryDouble result  = new ImaginaryDouble();
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double numeratorReal = ((Double)this.value * (Double)other.value) + (Double.parseDouble(this.im.toString()) * Double.parseDouble(other.im.toString()));
        MyDouble thisInt = (MyDouble) new MyDouble().create(String.valueOf(this.value));
        MyDouble otherInt = (MyDouble) new MyDouble().create(String.valueOf(other.value));
        MyDouble numeratorImaginary = (MyDouble)thisInt.mul((MyDouble)other.im).sub((MyDouble)otherInt.mul((MyDouble)this.im));

        double denominatorReal = (Double)other.value * (Double)other.value + Double.parseDouble(other.im.toString()) * Double.parseDouble(other.im.toString());
        MyDouble power = (MyDouble) new MyDouble().create(String.valueOf(other.value));
        MyDouble power2 = (MyDouble) new MyDouble().create(String.valueOf(other.value));
        MyDouble denominatorImaginary = (MyDouble)power.mul(power2).add((MyDouble)other.im.mul(other.im));

        result.value = numeratorReal / denominatorReal;
        result.im = (MyDouble)numeratorImaginary.div(denominatorImaginary);

        return result;
    }

    @Override
    public Value pow(Value v) {
        return this;
    }

    @Override
    public boolean eq(Value v) {
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        return this.value == v.value && Double.parseDouble(this.im.toString()) == Double.parseDouble(other.im.toString());
    }

    @Override
    public boolean lte(Value v) {
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double module1 = Math.sqrt( (Double)this.value * (Double)this.value + Double.parseDouble(this.im.toString()) * Double.parseDouble(this.im.toString()) );
        double module2 = Math.sqrt( (Double)other.value * (Double)other.value + Double.parseDouble(other.im.toString()) * Double.parseDouble(other.im.toString()) );

        return module1 < module2;
    }

    @Override
    public boolean gte(Value v) {
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double module1 = Math.sqrt( (Double)this.value * (Double)this.value + Double.parseDouble(this.im.toString()) * Double.parseDouble(this.im.toString()) );
        double module2 = Math.sqrt( (Double)other.value * (Double)other.value + Double.parseDouble(other.im.toString()) * Double.parseDouble(other.im.toString()) );

        return module1 > module2;
    }

    @Override
    public boolean neq(Value v) {
        ImaginaryDouble other = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        return this.value != v.value || Double.parseDouble(this.im.toString()) != Double.parseDouble(other.im.toString());
    }

    @Override
    public boolean equals(Object other) { return this.value.equals(((ImaginaryDouble)other).value) && this.im.equals(((ImaginaryDouble)other).im); }

    @Override
    public int hashCode() { return this.value.hashCode() + this.value.hashCode(); }

    public String toString() {
        return this.value + "i" + im;
    }
}
