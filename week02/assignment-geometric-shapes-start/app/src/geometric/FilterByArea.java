package geometric;

public class FilterByArea implements GeometricPredicate{
    private double threshold;
    public FilterByArea(double threshold) { 
        this.threshold = threshold; 
    }
    public boolean predicate(Geometric shape) { 
        return shape.getArea() < threshold; 
    }
}