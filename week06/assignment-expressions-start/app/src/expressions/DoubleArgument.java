package expressions;

public abstract class DoubleArgument implements Expression {
    protected Expression left;
    protected Expression right;
    
    public DoubleArgument(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
