package geometric;

import java.util.Comparator;

class SortByY implements Comparator<Geometric> {
    public int compare(Geometric o1, Geometric o2){ 
        return Double.compare(o1.getBottom(), o2.getBottom()); 
    }
}
