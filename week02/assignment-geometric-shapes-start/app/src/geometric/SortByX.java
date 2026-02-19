package geometric;

import java.util.Comparator;

class SortByX implements Comparator<Geometric> {
    public int compare(Geometric o1, Geometric o2){ 
        return Double.compare(o1.getLeft(), o2.getLeft()); 
    }
}
