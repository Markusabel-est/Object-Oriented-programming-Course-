package ast;

public interface FormulaVisitor<R, A> {
    R visit(Atom var, A arg);
    R visit(Not var, A arg);
    R visit(Constant var, A arg);
    R visit(BinaryFormula var, A arg);
}
