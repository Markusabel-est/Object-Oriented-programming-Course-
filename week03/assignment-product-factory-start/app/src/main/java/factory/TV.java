package factory;

public class TV implements Product, Display, EnergyConsumer{
    
    private final String brand;
    private final String model;
    private final String displayTech;
    private final int horizontalResolution;
    private final int verticalResolution;
    private final int refreshRate;
    private final String[] connectors;
    private final int bitsPerPixel;
    private double price;
    private int voltage;
    private int current;

    private TV(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.connectors = builder.connectors;
        this.horizontalResolution = builder.horizontalResolution;
        this.verticalResolution = builder.verticalResolution;
        this.refreshRate = builder.refreshRate;
        this.bitsPerPixel = builder.bitsPerPixel;
        this.price = builder.price;
        this.displayTech = builder.displayTech;
        this.voltage = 240;
        this.current = 2;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public double getCurrent() {
        return current;
    }

    @Override
    public int getHorizontalResolution() {
        return horizontalResolution;
    }

    @Override
    public int getVerticalResolution() {
        return verticalResolution;
    }

    @Override
    public int getRefreshRate() {
        return refreshRate;
    }

    @Override
    public int getBitsPerPixel() {
        return bitsPerPixel;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
       return model;
    }

    @Override
    public String getDisplayTechnology() {
       return displayTech;
    }

    @Override
    public int getConnectorCount(String type) {
        return connectors.length;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TV: " + brand + " " + model + " " + displayTech + " " + horizontalResolution + "x" + verticalResolution + "@" + refreshRate + "Hz " + "Price: " + price + " Connectors: " + String.join(", ", connectors);
    }


    public static class Builder{
        private final int horizontalResolution;
        private final int verticalResolution;
        private String brand;
        private String model;
        private String displayTech;
        private String[] connectors;
        private int refreshRate;
        private int bitsPerPixel;
        private double price;

        public Builder(int horizontalResolution, int verticalResolution) {
            this.horizontalResolution = horizontalResolution;
            this.verticalResolution = verticalResolution;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder refreshRate(int refreshRate) {
            this.refreshRate = refreshRate;
            return this;
        }

        public Builder displayTechnology(String displayTech) {
            this.displayTech = displayTech;
            return this;
        }

        public Builder connectors (String[] connectors ) {
            this.connectors = connectors;
            return this;
        }

        public Builder bitsPerPixel(int bits) {
            this.bitsPerPixel = bits;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public TV build() {
            return new TV(this);
        }
    }


    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }
}
