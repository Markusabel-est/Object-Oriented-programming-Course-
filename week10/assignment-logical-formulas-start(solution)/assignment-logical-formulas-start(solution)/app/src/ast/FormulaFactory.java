package ast;

import java.util.Map;

public class FormulaFactory {

	public static Formula atom(String atomId) {
		return new Atom(atomId);
	}

	public static Formula and(Formula leftOp, Formula rightOp) {
		return new BinaryFormula(leftOp, rightOp, BinOp.AND);
	}

	public static Formula or(Formula leftOp, Formula rightOp) {
		return new BinaryFormula(leftOp, rightOp, BinOp.OR);
	}

	public static Formula implies(Formula leftOp, Formula rightOp) {
		return new BinaryFormula(leftOp, rightOp, BinOp.IMPLIES);
	}

	public static Formula not(Formula notOp) {
		return new Not(notOp);
	}

	public static final Formula TRUE = new Constant(true);
	public static final Formula FALSE = new Constant(false);

	public static String prettyPrint(Formula f) {
		PrintVisitor visitor = new PrintVisitor();
		return visitor.prettyPrint(f);
	}

	public static Boolean evaluate(Formula f, Map<String, Boolean> env) {
		EvaluateVisitor visitor = new EvaluateVisitor(env);
		return f.accept(visitor, null);
	}
}
