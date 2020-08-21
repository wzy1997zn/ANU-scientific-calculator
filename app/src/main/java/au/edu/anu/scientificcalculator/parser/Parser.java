package au.edu.anu.scientificcalculator.parser;

/**
 * Expr      ->    Term ExprTail
 * ExprTail  ->    + Term ExprTail
 *           |     - Term ExprTail
 *           |     null
 *
 * Term      ->    Exponent TermTail
 * TermTail  ->    * Exponent TermTail
 *           |     / Exponent TermTail
 *           |     null
 *
 * Expo  ->    Factor ExpoTail
 * Expo      |     ^ Factor ExpoTail
 *           |     null
 *
 * Factor    ->    (Expr)
 *           |     Functions1(Expr)
 *           |     Functions2(Expr)(Expr)
 *           |     NUM
 *           |     VAR
 *
 * Functions1: SIN, COS, TAN
 * Functions2: LOG
 * (referenced from https://zhuanlan.zhihu.com/p/24035780)
 *
 * NOTE: Tails are not good designs but currently I have to do it like this to
 *       ensure calculate from left to right. Tails can not give out a evaluable
 *       expression so I have to pass heads down to calculate.
 *       Another design is to generate some new expressions like "TermTailExp",
 *       but it still can not solve the problem that tail is not able to evaluate
 *       unless we pass the "head" to it.
 */
public class Parser {
    Tokenizer _tokenizer;

    public Parser(Tokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /**
     * + or - is this level
     */
    public Exp parseExpr() throws WrongExpressionException {
        Exp expr;
        Exp termExp = parseTerm();
        expr = parseExprTail(termExp);
//        if (_tokenizer.hasNext()) {
//            throw new WrongExpressionException();
//        }
        return expr;
    }

    public Exp parseExprTail(Exp firstTermExp) throws WrongExpressionException {
        Token curToken = _tokenizer.current();
        Exp calculatedExp = null;
        if (curToken == null) { // case null
            return firstTermExp;
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.ADD)) { // case +
            _tokenizer.next();                      // +
            Exp secondTermExp = parseTerm();        // EXP
            Exp termExp = new AddExp(firstTermExp, secondTermExp); // calculate before get next +-
            calculatedExp = parseExprTail(termExp); // more tails
//            return calculatedExp;
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.SUB)) { // case -
            _tokenizer.next();                      // -
            Exp secondTermExp = parseTerm();        // EXP
            Exp termExp = new SubExp(firstTermExp, secondTermExp); // calculate before get next +-
            calculatedExp = parseExprTail(termExp); // more tails
//            return calculatedExp;
        } else if (_tokenizer.hasNext()) {
            return firstTermExp;
        } else {
            System.out.println("SHOULD NOT REACH HRER\n WRONG TOKEN");
            throw new WrongExpressionException();
        }
        return calculatedExp;
    }

    /**
     * * or / level
     */
    public Exp parseTerm() throws WrongExpressionException {
        Exp termExp;
        Exp exponentExp = parseExpo();
        termExp = parseTermTail(exponentExp);
        return termExp;
    }

    public Exp parseTermTail(Exp firstExpoExp) throws WrongExpressionException {
        Token curToken = _tokenizer.current();
        Exp calculatedExp = null;
        if (curToken == null) { // case null
            return firstExpoExp;
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.MUL)) { // case *
            _tokenizer.next();                      // *
            Exp secondExpoExp = parseExpo();        // EXP
            Exp termExp = new MulExp(firstExpoExp, secondExpoExp); // calculate before get next */
            calculatedExp = parseTermTail(termExp); // more tails
//            return calculatedExp;
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.DIV)) { // case /
            _tokenizer.next();                      // /
            Exp secondExpoExp = parseExpo();        // EXP
            Exp termExp = new DivExp(firstExpoExp, secondExpoExp); // calculate before get next */
            calculatedExp = parseTermTail(termExp); // more tails
//            return calculatedExp;
        } else if (_tokenizer.hasNext()) {
            return firstExpoExp;
        } else {
            System.out.println("SHOULD NOT REACH HRER\n WRONG TOKEN");
            throw new WrongExpressionException();
        }
        return calculatedExp;
    }

    /**
     * ^ level
     */
    public Exp parseExpo() throws WrongExpressionException {
        Exp exponentExp;
        Exp factorExp = parseFactor();
        exponentExp = parseExpoTail(factorExp);
        return exponentExp;
    }

    public Exp parseExpoTail(Exp baseFactorExp) throws WrongExpressionException {
        Token curToken = _tokenizer.current();
        Exp exponentedExp = null;
        if (_tokenizer.current() == null) { // case null
            return baseFactorExp;
        } else{
            if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.EXP)) { // case ^ Factor ExponentTail
                _tokenizer.next();                          //^
                Exp exponentFactorExp = parseFactor();      //EXP
                Exp exponentExp = new ExpExp(baseFactorExp, exponentFactorExp);//calculate exponent
                exponentedExp = parseExpoTail(exponentExp); //more tails
            } else if (_tokenizer.hasNext() && !curToken.get_type().equals(Token.Type.EXP)) {
                return baseFactorExp;
            } else{
                System.out.println("SHOULD NOT REACH HRER\n WRONG TOKEN");
                throw new WrongExpressionException();
            }
        }
        return exponentedExp;
    }

    /**
     * trigonometric, factorial, log, (EXP), NUM, VAR level
     */
    public Exp parseFactor() throws WrongExpressionException {
        Token curToken = _tokenizer.current();
        Exp factorExp = null;
        if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.SIN)) {
            _tokenizer.next();          //function_name(sin)
            _tokenizer.next();          //(
            Exp subExp = parseExpr();    //EXP
            _tokenizer.next();          //)
            factorExp = new SinExp(subExp);
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.COS)) {
            _tokenizer.next();          //function name(cos)
            _tokenizer.next();          //(
            Exp subExp = parseExpr();    //EXP
            _tokenizer.next();          //)
            factorExp = new CosExp(subExp);
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.TAN)) {
            _tokenizer.next();          //function name(tan)
            _tokenizer.next();          //(
            Exp subExp = parseExpr();    //EXP
            _tokenizer.next();          //)
            factorExp = new TanExp(subExp);
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.FAC)) {
            _tokenizer.next();          //function name(fac)
            _tokenizer.next();          //(
            Exp subExp = parseExpr();    //EXP
            _tokenizer.next();          //)
            factorExp = new FacExp(subExp);
        }  else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.LOG)) {
            _tokenizer.next();          //function name(log)
            _tokenizer.next();          //(
            Exp subExp1 = parseExpr();   //EXP1
            _tokenizer.next();          //)
            _tokenizer.next();          //(
            Exp subExp2 = parseExpr();   //Exp2
            _tokenizer.next();          //)
            factorExp = new LogExp(subExp1, subExp2);
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.NUM)) {
            factorExp = new NumExp(Double.parseDouble(curToken.get_token()));
            _tokenizer.next();          //NUM
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.VAR)) {
            factorExp = generateVarExp((VarToken)curToken);
            _tokenizer.next();          //VAR
        } else if (_tokenizer.hasNext() && curToken.get_type().equals(Token.Type.LBRA)) {
            _tokenizer.next();          //(
            factorExp = parseExpr();     //EXP
            _tokenizer.next();          //)
        } else {
            System.out.println("SHOULD NOT REACH HRER\nWRONG TOKEN");
            throw new WrongExpressionException();
        }
        return  factorExp;
    }

    VarExp generateVarExp(VarToken curToken) {
        System.out.println("SHOULD NOT REACH HRER\nWRONG TOKEN:" + _tokenizer.current().get_token());
        System.out.println("USE FUNCTIONPARSER");
        VarExp factorExp = null;
        //VarExp factorExp = new VarExp(curToken.get_index());
        // can do this, but common parser should not deal with variables
        return factorExp;
    }
}
