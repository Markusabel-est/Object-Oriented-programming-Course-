package factory;

public class ProcedureOneVisitor implements ProductVisitor {
    public void visit(Chair chair) {
        if (chair.getMaterial().equals("wooden")) {
            chair.multiplyPrice(0.85);
        } else if (chair.getMaterial().equals("metal")) {
            chair.multiplyPrice(1.12);
        }
    }
   
    public void visit(Fridge fridge) {
        if (fridge.getBrand().equals("Samsung")) {
            fridge.multiplyPrice(0.95);
        }
    }
  
    public void visit(TV tv) {
        if (tv.getConnectorCount("DP") >= 2) {
            tv.multiplyPrice(0.70);
        }
    }

}