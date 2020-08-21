package au.edu.anu.scientificcalculator.parser;

/**
 * ExponentExp
 * 2 sub Expressions represent to (base)^(exponent)
 */
public class ExpExp extends Exp {
    Exp base;
    Exp exponent;
    public ExpExp(Exp base, Exp exponent) {
        super();
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public String show() {
        return "(" + base.show() + "^" + "(" + exponent.show() + "))";//base^exponent
    }

    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), exponent.evaluate());
    }

    @Override
    public boolean checkTrigonometric() {
        return base.checkTrigonometric() || exponent.checkTrigonometric();
    }
}
