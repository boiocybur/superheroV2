package file;

import datasource.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private File file = new File("superhero.csv");
    private ArrayList<Superhero> herofiles = new ArrayList<>();


    public ArrayList<Superhero> load() throws IOException {
        ArrayList<Superhero> temp = new ArrayList<>();
        try(Scanner myReader = new Scanner(file, StandardCharsets.ISO_8859_1)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] superhelteData = data.split(",");
                if (superhelteData.length == 6) {
                    String name = superhelteData[0];
                    String superheroName = superhelteData[1];
                    boolean isHuman = Boolean.parseBoolean(superhelteData[2]);
                    int creationYear = Integer.parseInt(superhelteData[3]);
                    String superpower = superhelteData[4];
                    int strength = Integer.parseInt(superhelteData[5]);

                    Superhero hero = new Superhero(name, superheroName, isHuman, creationYear, superpower, strength);
                    temp.add(hero);
                }
            }
        }
        this.herofiles.addAll(temp); // Add all loaded superheroes
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
    public ArrayList<Superhero> getHerofiles(){
        return herofiles;
    }
}

