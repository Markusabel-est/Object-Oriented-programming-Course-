package factory;

public interface Product {
    double getPrice();

    void setPrice(double price);

    default void multiplyPrice(double factor){
        setPrice((getPrice() * factor));
    }

    void accept(ProductVisitor visitor);

}
