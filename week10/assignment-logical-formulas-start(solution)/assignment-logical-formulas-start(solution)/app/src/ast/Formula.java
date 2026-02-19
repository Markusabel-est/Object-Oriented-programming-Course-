package ast;

public interface Formula {
    <R, A> R accept(FormulaVisitor<R, A> visitor, A arg);
}
