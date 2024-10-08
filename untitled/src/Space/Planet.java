package Space;

public class Planet {
    private String name;
    private PlanetType type;
    private int numberOfMoons;
    private double distanceFromSun;

    public Planet(String name, PlanetType type, int numberOfMoons, double distanceFromSun) {
        this.name = name;
        this.type = type;
        this.numberOfMoons = numberOfMoons;
        this.distanceFromSun = distanceFromSun;
    }

    // Getter ها و Setter ها
    public String getName() {
        return name;
    }

    public PlanetType getType() {
        return type;
    }

    public void setType(PlanetType type) {
        this.type = type;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }


    public void addMoon() {
        this.numberOfMoons++;
    }

    @Override
    public String toString() {
        return "نام: " + name +
                ", نوع: " + type +
                ", تعداد قمرها: " + numberOfMoons +
                ", فاصله از خورشید: " + distanceFromSun + " میلیون کیلومتر";
    }
}
