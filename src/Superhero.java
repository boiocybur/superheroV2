public class Superhero {
    private String name;
    private String superHeroName;
    private boolean isHuman;
    private int creationYear;
    private String superpower;
    private int strength;

    public Superhero(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
        this.name = name;
        if (superHeroName != null && !superHeroName.isEmpty()) {
            this.superHeroName = superHeroName;
        } else {
            this.superHeroName = "No Hero name"; // Default value for superhero name
        }
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.superpower = superpower;
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

    public int getStrength() {
        return strength;
    }

    public String getSuperpower() {
        return superpower;
    }

    public boolean isEmpty() {
        return false;
    }
}
