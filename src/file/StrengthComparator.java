package file;

import datasource.Superhero;
import java.util.Comparator;

public class StrengthComparator implements Comparator<Superhero>{
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Integer.compare(o1.getStrength(), o2.getStrength());
    }
}
