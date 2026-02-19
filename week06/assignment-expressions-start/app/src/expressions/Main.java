package expressions;

import java.util.HashMap;
import java.util.Map;
import static expressions.ExpressionFactory.*;

public class Main {
    public static void main(String[] args) {
        Expression expr = add(mul(con(2.0), con(3.0)), var("x"));
        System.out.println("Expression: " + expr.toString());
        
        Map<String, Double> env = new HashMap<>();
        env.put("x", 5.0);
        System.out.println("Evaluated: " + expr.eval(env));
        
        Expression simplified = expr.partialEval();
        System.out.println("Simplified expression: " + simplified.toString());
        System.out.println("Simplified evaluated: " + simplified.eval(env));
    }
}
