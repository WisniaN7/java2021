package pl.edu.uj.javaframe;

public class Int extends Value {
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        Int other = (Int)v;

        Int result  = new Int();
        result.value = (Integer)this.value + (Integer)other.value;

        return result;
    }

    @Override
    public Value sub(Value v) {
        Int other = (Int)v;

        Int result  = new Int();
        result.value = (Integer)this.value - (Integer)other.value;

        return result;
    }

    @Override
    public Value mul(Value v) {
        Int other = (Int)v;

        Int result  = new Int();
        result.value = (Integer)this.value * (Integer)other.value;

        return result;
    }

    @Override
    public Value div(Value v) {
        Int other = (Int)v;
        Int result  = new Int();

        if ((Integer)other.value != 0) {
            result.value = (Integer)this.value / (Integer)other.value;
        } else {
            throw new ArithmeticException("Division by 0");
        }

        return result;
    }

    @Override
    public Value pow(Value v) {
        this.value = Math.pow((Integer)this.value, (Integer)v.value);
        return this;
    }

    @Override
    public boolean eq(Value v) {
        return this.value == v.value;
    }

    @Override
    public boolean lte(Value v) {
        return (Integer)this.value < (Integer)v.value;
    }

    @Override
    public boolean gte(Value v) {
        return (Integer)this.value > (Integer)v.value;
    }

    @Override
    public boolean neq(Value v) {
        return this.value != v.value;
    }

    @Override
    public boolean equals(Object other) {
        return this.value.equals(((Int)other).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
