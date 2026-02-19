package ast;

public record Atom(String name) implements Formula {
    public Atom(String name) {this.name = name;}


    public <R, A> R accept(FormulaVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

    public String name(){
        return name;
    }

}
