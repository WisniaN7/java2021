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

    @Override
    public Value sub(Value v) {
        ImaginaryInt result  = new ImaginaryInt();
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        result.value = (Integer)this.value - Integer.parseInt(v.value.toString());
        result.im = (Int)im.sub(other.im);

        return result;
    }

    @Override
    public Value mul(Value v) {
        ImaginaryInt result  = new ImaginaryInt();
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        result.value = ((Integer)this.value * (Integer)other.value) - (Integer.parseInt(this.im.toString()) * Integer.parseInt(other.im.toString()));
        Int thisInt = (Int) new Int().create(String.valueOf(this.value));
        Int otherInt = (Int) new Int().create(String.valueOf(other.value));
        result.im = (Int)thisInt.mul((Int)other.im).add((Int)otherInt.mul((Int)this.im));

        return result;
    }

    @Override
    public Value div(Value v) { // Wiem, że bałagan, ale inaczej byłem w stanie sobie tego zwizualizować
        ImaginaryInt result  = new ImaginaryInt();
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        int numeratorReal = ((Integer)this.value * (Integer)other.value) + (Integer.parseInt(this.im.toString()) * Integer.parseInt(other.im.toString()));
        Int thisInt = (Int) new Int().create(String.valueOf(this.value));
        Int otherInt = (Int) new Int().create(String.valueOf(other.value));
        Int numeratorImaginary = (Int)thisInt.mul((Int)other.im).sub((Int)otherInt.mul((Int)this.im));

        int denominatorReal = (Integer)other.value * (Integer)other.value + Integer.parseInt(other.im.toString()) * Integer.parseInt(other.im.toString());
        Int power = (Int) new Int().create(String.valueOf(other.value));
        Int power2 = (Int) new Int().create(String.valueOf(other.value));
        Int denominatorImaginary = (Int)power.mul(power2).add((Int)other.im.mul(other.im));

        result.value = numeratorReal / denominatorReal;
        result.im = (Int)numeratorImaginary.div(denominatorImaginary);

        return result;
    }

    @Override
    public Value pow(Value v) {
        return this;
    }

    @Override
    public boolean eq(Value v) {
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        return this.value == v.value && Integer.parseInt(this.im.toString()) == Integer.parseInt(other.im.toString());
    }

    @Override
    public boolean lte(Value v) {
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        double module1 = Math.sqrt( (Integer)this.value * (Integer)this.value + Integer.parseInt(this.im.toString()) * Integer.parseInt(this.im.toString()) );
        double module2 = Math.sqrt( (Integer)other.value * (Integer)other.value + Integer.parseInt(other.im.toString()) * Integer.parseInt(other.im.toString()) );

        return module1 < module2;
    }

    @Override
    public boolean gte(Value v) {
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        double module1 = Math.sqrt( (Integer)this.value * (Integer)this.value + Integer.parseInt(this.im.toString()) * Integer.parseInt(this.im.toString()) );
        double module2 = Math.sqrt( (Integer)other.value * (Integer)other.value + Integer.parseInt(other.im.toString()) * Integer.parseInt(other.im.toString()) );

        return module1 > module2;
    }

    @Override
    public boolean neq(Value v) {
        ImaginaryInt other = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        return this.value != v.value || Integer.parseInt(this.im.toString()) != Integer.parseInt(other.im.toString());
    }

    @Override
    public boolean equals(Object other) { return this.value.equals(((ImaginaryInt)other).value) && this.im.equals(((ImaginaryInt)other).im); }

    @Override
    public int hashCode() { return this.value.hashCode() + this.im.hashCode(); }

    public String toString() {
        return this.value + "i" + im;
    }
}
