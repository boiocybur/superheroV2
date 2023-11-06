package file;

import datasource.Database;
import datasource.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Filehandler {
    private File file = new File("superhero.csv");
    private ArrayList<Superhero> superheroes = new ArrayList<>();
    NameComparator nameComparator = new NameComparator();
    SuperheroNameComparator superheroNameComparator = new SuperheroNameComparator();
    isHumanComparator isHumanComparator = new isHumanComparator();
    CreationYearComparator creationYearComparator = new CreationYearComparator();
    StrengthComparator strengthComparator = new StrengthComparator();

    public ArrayList<Superhero> load() throws FileNotFoundException {
        ArrayList<Superhero> temp = new ArrayList<>();
        try(Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] superhelteData = data.split(",");
                if (superhelteData.length == 6) {
                    String name = superhelteData[0];
                    String superheroName = superhelteData[1];
                    Boolean isHuman = Boolean.parseBoolean(superhelteData[2]);
                    int creationYear = Integer.parseInt(superhelteData[3]);
                    String superpower = superhelteData[4];
                    int strength = Integer.parseInt(superhelteData[5]);

                    Superhero hero = new Superhero(name, superheroName, isHuman, creationYear, superpower, strength);
                    temp.add(hero);
                }
            }
        }
        return temp;
    }

    public void save(ArrayList<Superhero> superheroes) {
        try (PrintStream out = new PrintStream(file)) {
            for (Superhero superhero : superheroes) {
                out.println(superhero.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void sortBySuperheroName(){
        Collections.sort(superheroes, new SuperheroNameComparator());
    }
    public void sortByCreationYear(){
        Collections.sort(superheroes, new CreationYearComparator());
    }
    public void sortByIsHuman(){
        Collections.sort(superheroes, new isHumanComparator());
    }
    public void sortByName(){
        Collections.sort(superheroes, new NameComparator());
    }
    public void sortbyStrength(){
        Collections.sort(superheroes, new StrengthComparator());
    }
}