package datasource;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public void setIsHuman(boolean human) {
        isHuman = human;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setStrength(int strength) {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(",");
        stringBuilder.append(superHeroName);
        stringBuilder.append(",");
        stringBuilder.append(isHuman);
        stringBuilder.append(",");
        stringBuilder.append(creationYear);
        stringBuilder.append(",");
        stringBuilder.append(superpower);
        stringBuilder.append(",");
        stringBuilder.append(strength);
        return stringBuilder.toString();
    }
}
