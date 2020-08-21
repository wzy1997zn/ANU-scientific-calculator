package au.edu.anu.scientificcalculator.parser;

/**
 * cos
 * with 1 subExp
 */
public class CosExp extends TrigonometricExp {
    CosExp(Exp subExp) {
        super(Token.Type.COS);
        this.subExp = subExp;
    }

    @Override
    public double evaluate() {
        return Math.cos(Math.toRadians(subExp.evaluate()));
    }
}
