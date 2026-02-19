package factory;

public interface Display{
   
    int getHorizontalResolution();
    int getVerticalResolution();
    int getRefreshRate();
    int getBitsPerPixel();
    String getBrand();
    String getModel();
    String getDisplayTechnology();
    int getConnectorCount(String type);
}