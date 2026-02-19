package expressions;

import java.util.Map;

public class Multiply extends DoubleArgument {

    public Multiply(Expression left, Expression right) {
        super(left, right);
    }
    
    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
    
    @Override
    public double eval(Map<String, Double> env) {
        return left.eval(env) * right.eval(env);
    }
    
    @Override
    public Expression partialEval() {
        Expression l = left.partialEval();
        Expression r = right.partialEval();
        
        Double lConst = l.getConstantValue();
        Double rConst = r.getConstantValue();
        
        if (lConst != null && rConst != null) {
            return new Constant(lConst * rConst);
        }
        if (lConst != null) {
            if (lConst == 0) return new Constant(0);
            if (lConst == 1) return r;
        }
        if (rConst != null) {
            if (rConst == 0) return new Constant(0);
            if (rConst == 1) return l;
        }
        return new Multiply(l, r);
    }
}
