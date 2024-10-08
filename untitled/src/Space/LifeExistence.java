package Space;

public class LifeExistence extends Planet {
    private boolean hasLife;

    public void LifeSupportingPlanet(String name, PlanetType type, int numberOfMoons, double distanceFromSun, boolean hasLife) {

        this.hasLife = hasLife;
    }

    public LifeExistence(String name, PlanetType type, int numberOfMoons, double distanceFromSun, boolean b) {
        super(name, type, numberOfMoons, distanceFromSun);
    }

    public boolean hasLife() {
        return hasLife;
    }

    @Override
    public String toString() {
        return super.toString() + ", وضعیت حیات: " + (hasLife ? "دارد" : "ندارد");
    }
}