package au.edu.anu.scientificcalculator.parser;

/**
 * Expressions
 * abstract class defining the methods that a Expression should have
 */
public abstract class Exp {
    public abstract String show();
    public abstract double evaluate();
    public abstract boolean checkTrigonometric();
    @Override
    public String toString() {
        return show();
    }
}
