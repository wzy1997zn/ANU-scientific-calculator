package au.edu.anu.scientificcalculator.parser;

/**
 * An API for front side
 * designed with Singleton Pattern
 * coded by Ziyue Wang
 */
public class CalculateCore {

    // single pattern
    private static CalculateCore instance = new CalculateCore();
    private CalculateCore(){}
    public static CalculateCore getInstance() {
        return instance;
    }

    public String getResultOf(String expression) {


        String result = "";
        Tokenizer tk = new Tokenizer(expression);
        Parser parser = new Parser(tk);

        Exp expr = null;
        try {
            expr = parser.parseExpr();
            if (parser._tokenizer.hasNext()) {
                throw new WrongExpressionException();
            }
            result = expr.evaluate() + "";
        } catch (WrongExpressionException e) {
//            e.printStackTrace();
            result = "ERROR, WRONG EXPRESSION";
        }

        return result + "";
    }

    public boolean checkExpressionVaild(String expression) {
        boolean valid = true;
        Tokenizer tk = new Tokenizer(expression);
        Parser parser = new Parser(tk);

        Exp expr = null;
        try {
            expr = parser.parseExpr();
            if (parser._tokenizer.hasNext()) {
                throw new WrongExpressionException();
            }
        } catch (WrongExpressionException e) {
//            e.printStackTrace();
            valid = false;
        }

        return valid;
    }

    public boolean checkFunctionExpressionValid(String expression) {
        boolean valid = true;
        Tokenizer tk = new Tokenizer(expression);
        FunctionParser parser = new FunctionParser(tk);

        Exp expr = null;
        try {
            expr = parser.parseFuncExpr();
            if (parser._tokenizer.hasNext()) {
                throw new WrongExpressionException();
            }
        } catch (WrongExpressionException e) {
//            e.printStackTrace();
            valid = false;
        }

        return valid;
    }

    public FunctionExp generateFunction(String expression) throws WrongExpressionException {
        if (!checkFunctionExpressionValid(expression)) {
            throw new WrongExpressionException();
        }
        Tokenizer tk = new Tokenizer(expression);
        FunctionParser parser = new FunctionParser(tk);
        FunctionExp function = parser.parseFuncExpr();
        return function;
    }

    /**
     * examples to use calculateCore
     * @param args
     */
//    public static void main(String[] args) {
//        /* to calculate a expression*/
//        String res = getResultOf("9 + 1");
//        System.out.println(res);
//
//        /* to generate function */
//        // main activity call like this to check valid
//        FunctionExp fun = null;
//        try {
//            fun = generateFunction("f(x) = 50 * tan(x_1)");
//        } catch (WrongExpressionException e) {
//            e.printStackTrace();
//        }
//        // then main activity send the function object to plot activity
//        // and plot activity set variable values like this
//        double[] values = {-5};
//        fun.setVaribleValues(values);
//        // get the value of the function like this
//        double resFun =fun.evaluate();
//        System.out.println(resFun);
//
//        // to get an array of x,y just like this
////        for (int i = 0; i < 100; i++) {
////            values[0] = values[0] + 0.01;
////            fun.setVaribleValues(values);
////            resFun = fun.evaluate();
////            System.out.println(resFun);
////        }
//
//        // the easiest way to get Ys
////        float[] yArray = fun.getArrayOfY(-1.6393442,3279);
////        for (int i = 0; i < yArray.length; i++) {
////            System.out.println(yArray[i]);
////        }
//    }
}

