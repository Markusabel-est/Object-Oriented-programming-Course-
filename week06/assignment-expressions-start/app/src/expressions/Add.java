package expressions;

import java.util.Map;

public class Add extends DoubleArgument  {

    public Add(Expression left, Expression right) {
        super(left, right);
    }
    
    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
    
    @Override
    public double eval(Map<String, Double> env) {
        return left.eval(env) + right.eval(env);
    }
    
    @Override
    public Expression partialEval() {
        Expression l = left.partialEval();
        Expression r = right.partialEval();
        
        Double lConst = l.getConstantValue();
        Double rConst = r.getConstantValue();
        
        if (lConst != null && rConst != null) {
            return new Constant(lConst + rConst);
        }
        if (lConst != null && lConst == 0) {
            return r;
        }
        if (rConst != null && rConst == 0) {
            return l;
        }
        return new Add(l, r);
    }
}
