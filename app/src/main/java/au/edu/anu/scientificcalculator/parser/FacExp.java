package au.edu.anu.scientificcalculator.parser;

class FacExp extends Exp {
    Exp subExp;
    public FacExp(Exp subExp) {
        super();
        this.subExp = subExp;
    }

    @Override
    public String show() {
        return "(" + subExp.show() + ")! ";
    }

    @Override
    public double evaluate() {
        double res = gamma(subExp.evaluate() + 1);
        long roundRes = Math.round(res);
        if (res - roundRes < 1e-10) {
            return roundRes;
        } else {
            return res;
        }


    }

    @Override
    public boolean checkTrigonometric() {
        return subExp.checkTrigonometric();
    }


    /**
     * to calculate factorial of decimal
     * the solution is referenced from https://blog.csdn.net/microchenhong/article/details/6259700
     * actually I have no idea about those bullshit
     * @param z
     * @return
     */
    static double gamma(double z)
    {

        double ret = 0.0;
        ret = (1.000000000190015 + 76.18009172947146/(z+1) + -86.50532032941677/(z+2) +
                24.01409824083091/(z+3) + -1.231739572450155/(z+4) +
                1.208650973866179e-3/(z+5) + -5.395239384953e-6/(z+6))*(Math.sqrt(2*Math.PI)/z)*
                Math.pow(z+5.5, z+.5) //(z+5.5)^(z+.5)
                *Math.exp(-(z+5.5));
        return ret;
    }


}
