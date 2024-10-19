package Space2;

import java.util.List;

public class LifeSupportingPlanet extends Planet {

    private boolean isSupportLife;

    public LifeSupportingPlanet(String planetName, PlanetType planetType, int numberOfMoons, double distanceFromSun, boolean isSupportLife) {
        super(planetName, planetType, numberOfMoons, distanceFromSun);
        this.isSupportLife = isSupportLife;
    }

    public boolean isSupportLife() { return isSupportLife; }

    @Override
    public String toString() {
        return super.toString() + ", isSupportLife: " + (isSupportLife ? "has life" : "no life");
    }
}
