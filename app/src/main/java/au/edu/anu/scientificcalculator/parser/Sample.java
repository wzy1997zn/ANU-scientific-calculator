package au.edu.anu.scientificcalculator.parser;

/**
 * A sample for showing how to use Tokenizer, Parser and FunctionParser
 * written by Ziyue Wang
 */
//public class Sample {
//
//    public static void main(String[] args) throws WrongExpressionException {
////        System.out.println("Hello World!");
//
//        /* generate a tokenizer by text */
//        Tokenizer tk = new Tokenizer("1+2-3*5+(6-2)+cos(2)+fac(8)-sin(2)-tan(2)+2^2");
//        /* get all tokens */
//        while (tk.hasNext()) {
//            System.out.println(tk.current().get_token());
//            tk.next();
//        }
//
//        /* tokenizer should be restart before reuse */
//        tk.restart();
//
//        /* to evaluate an expression without varibles */
//        Parser parser = new Parser(tk);                                                             // generate a parser by tokenizer
////        double result = new Parser(new Tokenizer("1+1")).parseExpr().evaluate();
//        Exp test1 = parser.parseExpr();                                                             // use parser to get the expression without variables
//        System.out.print(test1.show() + " = ");                                                     // can use show() to see the expression with the priority brackets
//        System.out.println(test1.evaluate());                                                       // and EVALUATE the expression with evaluate().
//
//        /* function expression parsing*/
//        tk = new Tokenizer("f(x_1) = (sin(x_1))^2 + 1+2-3*5+(6-2)+cos(2)+fac(8)-sin(2)-tan(2)+2^2");                           // function expression like this is accepted by the tokenizer.
//                                                                                                    // also "(sin(x_1))^2 + (cos(x_1))^2" is ok.
//        FunctionParser parser2 = new FunctionParser(tk);                                            // generate the FunctionParser with tokenizer
//        FunctionExp test2 = parser2.parseFuncExpr();                                                // get the function expression.
//        System.out.println(test2.show());                                                           // It can be shown,
//        System.out.println(test2.show() + " = " + test2.evaluate());                                // and evaluate.
//                                                                                                    // But carefully if you have not set values of variables,
//                                                                                                    // the expression will be evaluated with zeros.
//        double[] values = {1};
//        test2.setVaribleValues(values);                                                             // you can set values by passing data in a double[] (with right size).
//        System.out.println(test2.show() + " = " + test2.evaluate());                                // and evaluate it again.
//        double[] vas = test2.getVariableValues();                                                   // you can also get current valuse of variables
//        System.out.println(vas[0]);
//
//    }
//}
