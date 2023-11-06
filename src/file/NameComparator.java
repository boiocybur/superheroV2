package file;

import datasource.Superhero;

import java.util.Comparator;

public class NameComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
