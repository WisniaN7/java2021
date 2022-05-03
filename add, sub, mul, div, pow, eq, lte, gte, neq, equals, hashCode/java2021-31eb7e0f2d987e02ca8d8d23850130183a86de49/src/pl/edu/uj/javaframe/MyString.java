package pl.edu.uj.javaframe;

public class MyString extends Value {
    @Override
    public Value create(String val) {
        MyString v = new MyString();
        v.value = val;
        return v;
    }

    @Override
    public Value add(Value v) {
        MyString other = (MyString)v;

        MyString result  = new MyString();
        result.value = (String)this.value + (String)other.value;

        return result;
    }

    @Override
    public Value sub(Value v) { return null; }

    @Override
    public Value mul(Value v) { return null; }

    @Override
    public Value div(Value v) { return null; }

    @Override
    public Value pow(Value v) { return null; }

    @Override
    public boolean eq(Value v) { return this.value.equals(((MyString)v).value); }

    @Override
    public boolean lte(Value v) { return false; }

    @Override
    public boolean gte(Value v) { return false; }

    @Override
    public boolean neq(Value v) { return !this.value.equals(((MyString)v).value); }

    @Override
    public boolean equals(Object other) {
        return this.value.equals(((MyString)other).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
