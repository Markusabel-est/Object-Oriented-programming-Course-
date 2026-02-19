package factory;

public class Fridge implements Product, EnergyConsumer{
    private boolean hasFreezer;
    private int capacity;
    private String brand;
    private double voltage;
    private double current;
    private double price;

    public Fridge(String brand,double price, double voltage, double current, boolean hasFreezer, int capacity ){
        this.brand = brand;
        this.price = price;
        this.voltage = voltage;
        this.current = current;
        this.hasFreezer = hasFreezer;
        this.capacity = capacity;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    
    public String getBrand() {
        return brand;
    }

    @Override
    public double getCurrent() {
        return current;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasFreezer() {
        return hasFreezer;
    }

    static Fridge createFreezer(String brand,  int volume, double price){
        return new Fridge(brand, price, 240, 2, true, volume);
    }

    static Fridge createFridge(String brand, int volume, double price){
        return new Fridge(brand, price, 240, 2, false, volume);
    }

    @Override
    public String toString(){
        return "Fridge: "+brand+"    Price: "+price+"     Capacity: "+capacity+"L     Freezer: " +hasFreezer+"      Voltage: "+voltage+"    Current:"+current;
    }

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }

    
}