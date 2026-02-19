package geometric;

class FilterByY implements GeometricPredicate {
    private double threshold;
    public FilterByY(double threshold) { 
        this.threshold = threshold; 
    }
    public boolean predicate(Geometric shape) { 
        return shape.getBottom()< threshold; 
    }
}
