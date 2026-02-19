package geometric;

public class FilterByX implements GeometricPredicate {
    private double threshold;
    public FilterByX(double threshold) { 
        this.threshold = threshold; 
    }
    public boolean predicate(Geometric shape) { 
        return shape.getLeft() < threshold; 
    }
}
