package geometric;

public class Circle implements Geometric{
    private double x, y, radius; 

    public Circle(double X, double Y, double R){
        this.x = X;
        this.y = Y;
        this.radius = R;
    }

    public double getLeft(){
        return (x-radius);
    }
    public double getRight(){
        return (x + radius);
    }
    public double getBottom(){
        return (y - radius);
    }
    public double getTop(){
        return (y + radius);
    }
    public double getArea(){
        return (2 * Math.PI * radius);
    }
    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "Circle(" + x + ", " + y + ", " + radius + ")";
    }


}
