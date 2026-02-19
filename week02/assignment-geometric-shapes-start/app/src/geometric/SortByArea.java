package geometric;

import java.util.Comparator;

class SortByArea implements Comparator<Geometric> {
    public int compare(Geometric o1, Geometric o2){ 
        return Double.compare(o1.getArea(), o2.getArea()); 
    }
}
