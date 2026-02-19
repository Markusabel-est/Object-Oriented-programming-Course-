package ast;

public record Constant(boolean value) implements Formula {
    public Constant {
        // record canonical constructor
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

    public String getString() {
        return this.value ? "True" : "False";
    }

    public boolean getValue() {
        return this.value;
    }
}