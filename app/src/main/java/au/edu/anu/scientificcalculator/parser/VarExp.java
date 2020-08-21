package au.edu.anu.scientificcalculator.parser;

/**
 * Variable Expression
 * represent to things like x_1
 */
public class VarExp extends Exp{
    private int _index;
    private double value;

    public VarExp(int index) {
        _index = index;
    }

    @Override
    public String show() { // show the current value of variable
        return "(x_" + _index + "[" + value + "])";
    }

    @Override
    public double evaluate() {
        // As a variable, value should be set before evaluate
        return value;
    }

    @Override
    public boolean checkTrigonometric() {
        return false;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int get_index() {
        return _index;
    }

}
