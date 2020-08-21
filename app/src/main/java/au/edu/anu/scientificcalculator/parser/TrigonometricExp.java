package au.edu.anu.scientificcalculator.parser;

/**
 * sin cos tan
 */
public abstract class TrigonometricExp extends Exp {
    Token.Type functionType;
    Exp subExp;

    @Override
    public String show() { // the same show method like "sin(EXP)"
        return "(" + functionType.name().toLowerCase() + "(" + subExp.show() + "))";
    }

    @Override
    public boolean checkTrigonometric() {
        String subExpString = subExp.show();
        if (subExpString.contains("x")) {
            return true;
        } else {
            return subExp.checkTrigonometric();
        }
    }

    TrigonometricExp(Token.Type type) {
        this.functionType = type;
    }
}
