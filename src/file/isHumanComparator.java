package file;

import datasource.Superhero;

import java.util.Comparator;

public class isHumanComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2){
        return Boolean.compare(o1.isHuman(), o2.isHuman());
    }
}

