package au.edu.anu.scientificcalculator.parser;

public class DivExp extends Exp{
    Exp exp1;
    Exp exp2;
    public DivExp(Exp firstExpoExp, Exp secondExpoExp) {
        super();
        exp1 = firstExpoExp;
        exp2 = secondExpoExp;
    }

    @Override
    public String show() {
        return "(" + exp1.show() + "/" + exp2.show() + ")";
    }

    @Override
    public double evaluate() {
        return exp1.evaluate() / exp2.evaluate();
    }

    @Override
    public boolean checkTrigonometric() {
        return exp1.checkTrigonometric() || exp2.checkTrigonometric();
    }
}