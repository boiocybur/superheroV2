package file;

import datasource.Superhero;

import java.util.Comparator;

public class CreationYearComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Integer.compare(o1.getCreationYear(), o2.getCreationYear());
    }
}
