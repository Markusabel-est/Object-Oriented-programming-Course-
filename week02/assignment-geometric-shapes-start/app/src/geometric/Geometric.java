package geometric;

public interface Geometric {
    double getLeft();
    double getRight();
    double getBottom();
    double getTop();
    double getArea();
    void move(double dx, double dy);
}