package pl.edu.uj.javaframe;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value sub(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value - Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value mul(Value v) {
        MyDouble result  = new MyDouble();

        if (Double.valueOf(v.value.toString()) != 0) {
           result.value = (Double)this.value * Double.valueOf(v.value.toString());
        } else {
            throw new ArithmeticException("Division by 0");
        }

        return result;
    }

    @Override
    public Value div(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value / Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value pow(Value v) {
        MyDouble result = new MyDouble();
        result.value = Math.pow((Double)this.value, (Double)v.value);

        return result;
    }

    @Override
    public boolean eq(Value v) {
        return this.value == v.value;
    }

    @Override
    public boolean lte(Value v) {
        return (Double)this.value < (Double)v.value;
    }

    @Override
    public boolean gte(Value v) {
        return (Double)this.value > (Double)v.value;
    }

    @Override
    public boolean neq(Value v) {
        return this.value != v.value;
    }

    @Override
    public boolean equals(Object other) {
        return this.value.equals(((MyDouble)other).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
