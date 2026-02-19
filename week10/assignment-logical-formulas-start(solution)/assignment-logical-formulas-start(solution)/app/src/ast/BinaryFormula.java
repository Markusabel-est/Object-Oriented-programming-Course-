package ast;

public record BinaryFormula(Formula left, Formula right, BinOp operator) implements Formula{

    public BinaryFormula(Formula left, Formula right, BinOp operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public <R, A> R accept(FormulaVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

    public Formula getLeft() {
        return left;
    }
    public Formula getRight() {
        return right;
    }
    public BinOp getOperator() {
        return operator;
    }

}
