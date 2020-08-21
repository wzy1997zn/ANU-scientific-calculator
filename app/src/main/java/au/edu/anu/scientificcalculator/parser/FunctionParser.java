package au.edu.anu.scientificcalculator.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of common parser for especially function parsing
 */
public class FunctionParser extends Parser {

    List<VarExp> vars; // record var expressions during parsing

    public FunctionParser(Tokenizer tokenizer) {
        super(tokenizer);
        vars = new ArrayList<>();
    }

    /**
     * The adding action from parent class is
     * when finding varExp, record it.
     * @param curToken current token
     * @return the varExp like x_1
     */
    @Override
    VarExp generateVarExp(VarToken curToken) {
        VarExp factorExp = new VarExp(curToken.get_index());
        vars.add(factorExp);
        return factorExp;
    }

    /**
     * main outside API for parse a function expression
     * use the method parseExpr() of parent class to parse the real expression
     * and generate the functionExp object to manage it.
     * @return a function expression object
     */
    public FunctionExp parseFuncExpr() throws WrongExpressionException {

        Exp exp = super.parseExpr();
        FunctionExp functionExp = new FunctionExp(vars, exp);
        return functionExp;

    }
}
