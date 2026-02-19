package ast;

public record Not(Formula formula) implements Formula{
    public Not(Formula formula) {
        this.formula = formula;
    }


    public <R, A> R accept(FormulaVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

    public Formula formula() {
        return this.formula;
    }

}



