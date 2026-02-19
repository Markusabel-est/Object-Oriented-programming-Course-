package ast;


import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {

    AND("/\\", 2){

        public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
            return aBoolean && aBoolean2;
        }
    },
    OR("\\/", 1){
        public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
            return aBoolean || aBoolean2;
        }
    },
    IMPLIES("=>", 0){
        public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
            return !aBoolean || aBoolean2;
        }
    };

    private final String s;
    private final int i;

    BinOp(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public String getString() {
        return this.s;
    }
    public int getPrecedence() {
        return this.i;
    }
}
