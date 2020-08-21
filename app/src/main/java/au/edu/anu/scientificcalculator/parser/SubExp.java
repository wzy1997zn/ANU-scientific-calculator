package au.edu.anu.scientificcalculator.parser;

public class SubExp extends Exp {
    Exp exp1;
    Exp exp2;
    public SubExp(Exp exp1, Exp exp2) {
        super();
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public String show() {
        return "(" + exp1.show() + "-" + exp2.show() + ")";
    }

    @Override
    public double evaluate() {
        return exp1.evaluate() - exp2.evaluate();
    }

    @Override
    public boolean checkTrigonometric() {
        return exp1.checkTrigonometric() || exp2.checkTrigonometric();
    }
}