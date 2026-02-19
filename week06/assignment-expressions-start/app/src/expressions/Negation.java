package expressions;

import java.util.Map;

public class Negation extends SingleArgument {

    public Negation(Expression operand) {
        super(operand);
    }
    
    @Override
    public String toString() {
        return "(-" + operand.toString() + ")";
    }
    
    @Override
    public double eval(Map<String, Double> env) {
        return -operand.eval(env);
    }
    
    @Override
    public Expression partialEval() {
        Expression evalOperand = operand.partialEval();
        Double constVal = evalOperand.getConstantValue();
        if (constVal != null) {
            return new Constant(-constVal);
        }
        return new Negation(evalOperand);
    }
}
