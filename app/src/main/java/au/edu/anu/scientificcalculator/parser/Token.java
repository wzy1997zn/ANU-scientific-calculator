package au.edu.anu.scientificcalculator.parser;

/**
 *
 * NUM: double
 *
 * operators:
 * ADD: +
 * SUB: -
 * MUL: *
 * DIV: /
 * LBRA: (
 * RBRA: )
 * EXP(ONENT)：^
 * EQU: =
 *
 * functions1:
 * SIN: sin
 * COS: cos
 * TAN: tan
 * FAC(TORIAL)：fac
 *
 * functions2:
 * LOG: log
 *
 * functions:

 * FUN(CTION): f // maybe useful
 * VAR(IABLE): x_1,x_2...
 * const：changed to NUM auto (e,pi)
 */
public class Token {
    public enum Type{UNKNOWN, NUM, ADD, SUB, MUL, DIV, LBRA, RBRA, EQU, EXP, SIN, COS, TAN, LOG, FAC, FUN, VAR}
    private String _token = "";
    private Type _type = Type.UNKNOWN;

    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }

    public String get_token() {
        return _token;
    }

    public Type get_type() {
        return _type;
    }

    @Override
    public String toString() {
        return get_token();
    }
}

/**
 * var token have one more field index to represent which var this is.
 */
class VarToken extends Token {
    private int _index;
    public VarToken(int index) {
        super("x_" + index, Type.VAR);
        _index = index;
    }

    public int get_index() {
        return _index;
    }
}
