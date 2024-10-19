package Space2;


import java.util.ArrayList;
import java.util.List;

public class ResourceRichPlanet extends Planet{

    private List<String> resources = new ArrayList<>();

    public ResourceRichPlanet(String planetName, PlanetType planetType, int numberOfMoons, double distanceFromSun, List<String> resources) {
        super(planetName, planetType, numberOfMoons, distanceFromSun);
        this.resources = resources;
    }

    public List<String> getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return super.toString() + ", ResourceRichPlanet: " + String.join(", ", resources);
    }
}
