package geometric;

public class Rectangle implements Geometric{
    private double x, y, width, height;

    public Rectangle(double X, double Y, double W, double H){
        this.x = X;
        this.y = Y;
        this.width = W;
        this.height = H;
    }

    public double getLeft(){
        return x;
    }
    public double getRight(){
        return (x + width);
    }
    public double getBottom(){
        return y;
    }
    public double getTop(){
        return (y + height);
    }
    public double getArea(){
        return (width * height);
    }
    public void move(double dx, double dy){
        x +=  dx;
        y += dy;
    }
    
    @Override
    public String toString() {
        return "Rectangle(" + x + ", " + y + ", " + width + ", " + height + ")" ;
    }
}
