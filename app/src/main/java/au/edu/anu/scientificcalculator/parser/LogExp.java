package au.edu.anu.scientificcalculator.parser;

/**
 * log(sub1)(sub2)
 */
public class LogExp extends Exp {
    Exp subExp1;
    Exp subExp2;
    public LogExp(Exp subExp1, Exp subExp2) {
        super();
        this.subExp1 = subExp1;
        this.subExp2 = subExp2;
    }

    @Override
    public String show() {
        return "(log(" + subExp1.show() + ")(" + subExp2.show() + "))";
    }

    @Override
    public double evaluate() {
        return Math.log(subExp2.evaluate()) / Math.log(subExp1.evaluate());
    }

    @Override
    public boolean checkTrigonometric() {
        return subExp1.checkTrigonometric() || subExp2.checkTrigonometric();
    }
}
