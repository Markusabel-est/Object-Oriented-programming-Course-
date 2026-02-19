package expressions;

public abstract class SingleArgument implements Expression {
    protected Expression operand;
    
    public SingleArgument(Expression operand) {
        this.operand = operand;
    }
}



