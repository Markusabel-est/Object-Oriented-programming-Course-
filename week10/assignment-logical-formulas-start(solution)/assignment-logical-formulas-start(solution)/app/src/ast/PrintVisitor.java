package ast;

public class PrintVisitor implements FormulaVisitor<Void, Integer> {
    private final StringBuilder result = new StringBuilder();

    @Override
    public Void visit(Atom var, Integer arg) {
        result.append(var.name());
        return null;
    }

    @Override
    public Void visit(Not var, Integer arg) {
        int thisPrec = 3;
        boolean parensNeeded = thisPrec <= arg;
        result.append("!");
        if (parensNeeded) {
            result.append("(");
        }
        var.formula().accept(this, thisPrec);
        if (parensNeeded) {
            result.append(")");
        }
        return null;
    }

    @Override
    public Void visit(Constant var, Integer arg) {
        result.append(var.getString());
        return null;
    }

    @Override
    public Void visit(BinaryFormula var, Integer arg) {
        int thisPrec = var.operator().getPrecedence();
        boolean parensNeeded = thisPrec <= arg;
        if (parensNeeded) {
            result.append("(");
        }
        var.left().accept(this, thisPrec);
        result.append(var.operator().getString());
        var.right().accept(this, thisPrec);
        if (parensNeeded) {
            result.append(")");
        }
        return null;
    }

    public String prettyPrint(Formula formula) {
        result.setLength(0);
        formula.accept(this, -1);
        return result.toString();
    }
}
