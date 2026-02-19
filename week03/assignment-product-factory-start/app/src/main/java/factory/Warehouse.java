package factory;

import java.util.List;
import java.util.ArrayList;

public class Warehouse {
    private String name;
    private List<Product> products;

    public Warehouse(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public static Warehouse createMyWarehouse() {
        List<Product> products = new ArrayList<>();


        products.add(new Chair("wooden", 50.00));
        products.add(new Chair("metal", 100.00));
        
        products.add(Fridge.createFreezer("Bosch", 60, 400.00));
        products.add(Fridge.createFridge("Samsung", 100, 600.00));
        
        products.add(new TV.Builder(1920, 1080)
            .brand("LG")
            .model("L27LCD+")
            .displayTechnology("LCD")
            .connectors(new String[]{"HDMI", "HDMI", "DP"})
            .refreshRate(60)
            .bitsPerPixel(24)
            .price(300.00)
            .build());
        
        products.add(new TV.Builder(1920, 1080)
            .brand("Sony")
            .model("S33IPS++")
            .displayTechnology("IPS")
            .connectors(new String[]{"HDMI", "HDMI", "DP", "DP"})
            .refreshRate(90)
            .bitsPerPixel(24)
            .price(500.00)
            .build());
    

        return new Warehouse("My warehouse", products);
    }

    public void procedure1() {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i) instanceof TV){
                TV tv = (TV) products.get(i);
                if(tv.getDisplayTechnology().equals("LCD")){
                   products.get(i).multiplyPrice(0.9);
                }
            }
        }
        for(int i = 0; i < products.size(); i++){
            if(products.get(i) instanceof Fridge){
                Fridge f = (Fridge) products.get(i);
                if(f.hasFreezer()){
                   products.get(i).multiplyPrice(1.2);
                }
            }
        }
    }

    public void procedure2() {
        ProductVisitor visitor = new ProcedureOneVisitor();
        for(int i = 0; i < products.size(); i++){
            products.get(i).accept(visitor);
        }
    }

    @Override
    public String toString() {
        String result = "Warehouse '" + name + "'\nProducts:\n";
        for (int i = 0; i < products.size(); i++) {
            result += i + ": " + products.get(i) + "\n";
        }
        return result;
    }
}
