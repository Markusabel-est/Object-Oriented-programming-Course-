package ast;
import java.util.Map;

public class EvaluateVisitor implements FormulaVisitor<Boolean, Void> {
    private final Map<String, Boolean> env;

    public EvaluateVisitor(Map<String, Boolean> env) {
        this.env = env;
    }

    @Override
    public Boolean visit(Atom var, Void arg) {
        return this.env.get(var.name());
    }

    @Override
    public Boolean visit(Not var, Void arg) {
        return !(var.formula().accept(this, arg));
    }

    @Override
    public Boolean visit(Constant var, Void arg) {
        return var.getValue();
    }

    @Override
    public Boolean visit(BinaryFormula var, Void arg) {
        Boolean left = var.left().accept(this, arg);
        Boolean right = var.right().accept(this, arg);
        return var.operator().apply(left, right);
    }
}
