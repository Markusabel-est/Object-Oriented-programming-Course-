package factory;

public class Chair implements Product{
    private String material;
    private double price;
   
    public Chair(String material, double price){
        this.material = material;
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial(){
        return material;
    }

    @Override
    public String toString(){
        return "Chair:      Material-" +material+ ";      Price-"+price;
    }
   
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }
   
    
    
    
}