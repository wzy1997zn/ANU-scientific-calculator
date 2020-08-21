package au.edu.anu.scientificcalculator;

import android.content.Context;
import android.test.mock.MockContext;
import android.view.View;
import android.widget.EditText;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import au.edu.anu.scientificcalculator.file.FileUtil;
import au.edu.anu.scientificcalculator.parser.CalculateCore;
import au.edu.anu.scientificcalculator.parser.FunctionExp;
import au.edu.anu.scientificcalculator.parser.FunctionParser;
import au.edu.anu.scientificcalculator.parser.Parser;
import au.edu.anu.scientificcalculator.parser.Tokenizer;
import au.edu.anu.scientificcalculator.parser.WrongExpressionException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    //the basic test
    @Test
    public void addition_isCorrect() {
        try {
            assertEquals(4.0, new Parser(new Tokenizer("2+2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void sub_isCorrect() {
        try {
            assertEquals(0.0, new Parser(new Tokenizer("2-2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void multi_isCorrect(){
        try {
            assertEquals(4.0, new Parser(new Tokenizer("2*2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void dev_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("2/2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //test RL and RR parser grammar
    @Test
    public void double_sub_isCorrect(){
        try {
            assertEquals(10.0, new Parser(new Tokenizer("22-2-10")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void double_dev_isCorrect(){
        try {
            assertEquals(11.0, new Parser(new Tokenizer("44/2/2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void dev_sub1_isCorrect(){
        try {
            assertEquals(19.0, new Parser(new Tokenizer("44/2-2-4/2/2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void dev_sub2_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("36/(22-2-2)/2")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //log
    @Test
    public void log1_isCorrect() {
        try {
            assertEquals(1.0, new Parser(new Tokenizer("log(10)(10)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void log3_isCorrect(){
        try {
            assertEquals(true, Double.isInfinite(new Parser(new Tokenizer("log(1)(100)")).parseExpr().evaluate()));
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //sin
    @Test
    public void sin1_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("sin(90)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void sin2_isCorrect(){
        try {
            assertEquals(0.0, new Parser(new Tokenizer("sin(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //cos
    @Test
    public void cos1_isCorrect(){
        try {
            assertEquals(0.0, new Parser(new Tokenizer("cos(90)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cos2_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("cos(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //!
    @Test
    public void fac1_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("fac(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    public void fac2_isCorrect(){
        try {
            assertEquals(120.0, new Parser(new Tokenizer("fac(5)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //exp
    @Test
    public void exp1_isCorrect(){
        try {
            assertEquals(2.0, new Parser(new Tokenizer("4^(1/2)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void exp2_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("4^(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void exp3_isCorrect(){
        try {
            assertEquals(1.0, new Parser(new Tokenizer("0^(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void exp4_isCorrect(){
        try {
            assertEquals(16.0, new Parser(new Tokenizer("4^(2)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    //tan
    @Test
    public void tan1_isCorrect(){
        try {
            assertEquals(0.0, new Parser(new Tokenizer("tan(0)")).parseExpr().evaluate(), 1e-10);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tan2_isCorrect(){
        try {
            assertEquals(true, Double.isInfinite(new Parser(new Tokenizer("tan(90)")).parseExpr().evaluate()));;
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun(){
    FunctionExp fun = null;
        try {
        fun = CalculateCore.getInstance().generateFunction("f(x) = 50 * SIN(x_1)");
    } catch (WrongExpressionException e) {
        e.printStackTrace();
    }
    // then main activity send the function object to plot activity
    // and plot activity set variable values like this
    double[] values = {0};
        fun.setVaribleValues(values);
    // get the value of the function like this
    double resFun =fun.evaluate();

            assertEquals(0.0, resFun, 1e-10);

    }
    //exception checking
    //grammar error
    //too large
    //no sense input log(0)(10),9/0
    @Test
    public void show_isCorrect(){

        try {
            assertEquals("((((((((((1.0+2.0)-(3.0*5.0))+(6.0-2.0))+(cos(2.0)))+(8.0)! )-(sin(2.0)))-(tan(2.0)))+(2.0^(2.0)))+(3.0/2.0))+(log(10.0)(100.0)))", new Parser(new Tokenizer("1+2-3*5+(6-2)+cos(2)+fac(8)-sin(2)-tan(2)+2^2 + 3/2 + log(10)(100)")).parseExpr().show());
            assertEquals("((((((((((1.0+2.0)-(3.0*5.0))+(6.0-2.0))+(cos(2.0)))+(8.0)! )-(sin(2.0)))-(tan(2.0)))+(2.0^(2.0)))+(3.0/2.0))+(log(10.0)(100.0)))", new Parser(new Tokenizer("1+2-3*5+(6-2)+cos(2)+fac(8)-sin(2)-tan(2)+2^2 + 3/2 + log(10)(100)")).parseExpr().toString());
            FunctionExp fe = new FunctionParser(new Tokenizer("f(x) = sin(x_1)")).parseFuncExpr();
            assertEquals("f((x_1[0.0]),)= (sin((x_1[0.0])))", fe.show());
            double[] values = {1};
            fe.setVaribleValues(values);
            assertEquals("f((x_1[1.0]),)= (sin((x_1[1.0])))", fe.show());
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void sinx_isCorrect(){

        try {
            assertEquals(false, new Parser(new Tokenizer("1+2-3*5+(6-2)+cos(2)+fac(8)-sin(2)-tan(2)+2^2 + 3/2 + log(10)(100)")).parseExpr().checkTrigonometric());
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void sinx2_isCorrect(){

        try {
            assertEquals(true, new FunctionParser(new Tokenizer("f(x)=sin(x_1)")).parseFuncExpr().checkTrigonometric());
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getresult_isCorrect(){
        String res = CalculateCore.getInstance().getResultOf("9 + 1");

            assertEquals("10.0", res);

    }
    @Test
    public void check_isCorrect(){
        boolean res = CalculateCore.getInstance().checkExpressionVaild("9 + 1)");
        boolean res2 = CalculateCore.getInstance().checkExpressionVaild("9 + 1");
        assertEquals(false, res);
        assertEquals(true, res2);
    }
    @Test
    public void check2_isCorrect(){
        boolean res = CalculateCore.getInstance().checkFunctionExpressionValid("f(x)=546))");

        assertEquals(false, res);

    }
    @Test
    public void array_isCorrect(){
        try {
            FunctionExp fe = new FunctionParser(new Tokenizer("f(x) = x_1")).parseFuncExpr();
            float[] res = fe.getArrayOfY(1,5)  ;
            float[] exp={1.0f,1.001f,1.002f,1.003f,1.004f};
            assertArrayEquals(exp, res, 1e-10f);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void array2_isCorrect(){
        try {
            FunctionExp fe = new FunctionParser(new Tokenizer("f(x) = x_1")).parseFuncExpr();
            double[] v = {1};
            fe.setVaribleValues(v);
            double[] res = fe.getVariableValues();
            assertArrayEquals(v, res, 1e-10f);
        } catch (WrongExpressionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void sl_iscorrect() {
        Context context = null;
        FileUtil fu = new FileUtil(context);
        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        fu.save(test);
        List<String> res = fu.loadFile();
        assertEquals(res.get(0), "1");
        assertEquals(res.get(1), "2");
        assertEquals(res.get(2), "3");
        assertEquals(res.get(3), "4");
        assertEquals(res.get(4), "5");

    }

}

