import java.util.ArrayList;
import java.util.List;

public class Superhero {
    private String name;
    private String superHeroName;
    private boolean isHuman;
    private int creationYear;
    private String strength;

    public Superhero(String name, String superHeroName, boolean isHuman, int creationYear, String strength) {
        this.name = name;
        if (superHeroName != null && !superHeroName.isEmpty()) {
            this.superHeroName = superHeroName;
        } else {
            this.superHeroName = "No Hero name"; // Default value for superhero name
        }
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getStrength() {
        return strength;
    }
}
