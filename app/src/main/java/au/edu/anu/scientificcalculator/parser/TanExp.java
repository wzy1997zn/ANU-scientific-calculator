package au.edu.anu.scientificcalculator.parser;

public class TanExp extends TrigonometricExp { // see comments in TrigonometricExp
    TanExp(Exp subExp) {
        super(Token.Type.TAN);
        this.subExp = subExp;
    }

    @Override
    public double evaluate() {
        if (subExp.evaluate() % 180 == 90) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.tan(Math.toRadians(subExp.evaluate()));
    }
}
