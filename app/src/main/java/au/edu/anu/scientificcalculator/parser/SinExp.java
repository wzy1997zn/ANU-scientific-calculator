package au.edu.anu.scientificcalculator.parser;

public class SinExp extends TrigonometricExp { // see comments in TrigonometricExp
    public SinExp(Exp subExp) {
        super(Token.Type.SIN);
        this.subExp = subExp;
    }

    @Override
    public double evaluate() {
        return Math.sin(Math.toRadians(subExp.evaluate()));
    }
}
