package au.edu.anu.scientificcalculator.parser;

/**
 * Tokenizer
 * supporting expressions with and without variables
 */
public class Tokenizer {
    private String _text; // save the whole text
    private String _buffer; // dealing buffer
    private Token currentToken;

    public Tokenizer(String text) {

        _text = preprocessing(text);
        _buffer = _text;
        next();
        // for ignoring left side of function because currently we only have function with = in the exp
        // and the left side is meaningless
        toRealExp();
    }

    private String preprocessing(String text) {
        text = text.toLowerCase();
        text = text.trim();
        text = text.replace(" ","");
        if (text.equals("")) {
            return text;
        }
        // things like "(-1)" -> "(0-1)"
        StringBuilder editingText = new StringBuilder(text);
        for (int index = 0; index != -1; index = editingText.indexOf("-", index+1)) {
            if (index - 1 >= 0 && editingText.charAt(index-1) == '(') { // (-1) -> (0-1)
                editingText.insert(index, '0');
            } else if (index == 0 && editingText.charAt(0) == '-') { // -1 -> 0-1
                editingText.insert(index, '0');
            }
        }
        text = editingText.toString();


        // e,pi etc. should be processed.

        return text;
    }

    /**
     * ask the tokenizer to next token.
     * just so many cases, nothing to explain
     */
    public void next() {
        _buffer = _buffer.trim();
        currentToken = null;
        if (_buffer.isEmpty()) {
            return;
        }
        char firstChar = _buffer.charAt(0);
        if (Character.isDigit(firstChar)) {
            int end = 1;
            while (end < _buffer.length() && (Character.isDigit(_buffer.charAt(end)) || _buffer.charAt(end) == '.')) {
                end++;
            }
            String numString = _buffer.substring(0,end);
            currentToken = new Token(numString, Token.Type.NUM);
        }
        if(firstChar=='+') {
            currentToken = new Token("+", Token.Type.ADD);
        }
        if(firstChar=='-') {
            currentToken = new Token("-", Token.Type.SUB);
        }
        if (firstChar == '*') {
            currentToken = new Token("*", Token.Type.MUL);
        }
        if (firstChar == '/') {
            currentToken = new Token("/", Token.Type.DIV);
        }
        if (firstChar == '(') {
            currentToken = new Token("(", Token.Type.LBRA);
        }
        if (firstChar == ')') {
            currentToken = new Token(")", Token.Type.RBRA);
        }
        if (firstChar == '=') {
            currentToken = new Token("=", Token.Type.EQU);
        }
        if (firstChar == '^') {
            currentToken = new Token("^", Token.Type.EXP);
        }
        if (firstChar == 's') {
            if (_buffer.charAt(1) == 'i' && _buffer.charAt(2) == 'n') {
                currentToken = new Token("sin", Token.Type.SIN);
            }
        }
        if (firstChar == 'c') {
            if (_buffer.charAt(1) == 'o' && _buffer.charAt(2) == 's') {
                currentToken = new Token("cos", Token.Type.COS);
            }
        }
        if (firstChar == 't') {
            if (_buffer.charAt(1) == 'a' && _buffer.charAt(2) == 'n') {
                currentToken = new Token("tan", Token.Type.TAN);
            }
        }
        if (firstChar == 'l') {
            if (_buffer.charAt(1) == 'o' && _buffer.charAt(2) == 'g') {
                currentToken = new Token("log", Token.Type.LOG);
            }
        }
        if (firstChar == 'f') {
            if (_buffer.charAt(1) == 'a' && _buffer.charAt(2) == 'c') {
                currentToken = new Token("fac", Token.Type.FAC);
            }
            if (_buffer.charAt(1) == '(') {
                currentToken = new Token("f", Token.Type.FUN);
            }
        }
        if (firstChar == 'x') {
            if (_buffer.charAt(1) == '_' && Character.isDigit(_buffer.charAt(2))) {
                int indexBegin = 2;
                int indexEnd = 3;
                while (indexEnd < _buffer.length() && Character.isDigit(_buffer.charAt(indexEnd))) {
                    indexEnd++;
                }
                int index = Integer.parseInt(_buffer.substring(indexBegin,indexEnd));
                currentToken = new VarToken(index);
            }
        }
        if (currentToken == null) {
            System.out.println("WRONG EXPRESSION: " + _buffer);
        }
        int tokenLen = currentToken.get_token().length();
        _buffer = _buffer.substring(tokenLen);
    }

    public Token current() {
        return currentToken;
    }

    public boolean hasNext() {
        return currentToken != null;
    }

    public void restart() {
        _buffer = _text;
        next();
    }

    /**
     * currently we just use f() = ... to express functions.
     * f() is the only thing will be shown on the left side of =
     * so ignore the left side if the first token is FUN
     */
    private void toRealExp() {
        if (currentToken == null) {
            return;
        }
        if (currentToken.get_type().equals(Token.Type.FUN)) {
            _buffer = _buffer.substring(_buffer.indexOf("=")+1);
//            while (!currentToken.get_type().equals(Token.Type.EQU)) {
//                next();
//            }
            next(); // =
        }
    }
}
