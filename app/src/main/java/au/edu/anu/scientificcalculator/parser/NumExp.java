package au.edu.anu.scientificcalculator.parser;

/**
 * simple number use double to store.
 * So this is the accuracy limitation.
 */
public class NumExp extends Exp {
    double num;
    public NumExp(double v) {
        this.num = v;
    }

    @Override
    public String show() {
        return "" + num;
    }

    @Override
    public double evaluate() {
        return num;
    }

    @Override
    public boolean checkTrigonometric() {
        return false;
    }
}
