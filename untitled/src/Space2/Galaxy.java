package Space2;

import Space2.Planet;

import java.util.*;

public class Galaxy {
    private String galaxyName;
    private List<Planet> planets;

    public Galaxy(String galaxyName, List<Planet> planets) {
        this.galaxyName = galaxyName;
        this.planets = planets;
    }


    public String getGalaxyName() { return galaxyName; }

    public void setGalaxyName(String galaxyName) { this.galaxyName = galaxyName; }

    public List<Planet> getPlanets() { return planets; }

    public void setPlanets(List<Planet> planets) { this.planets = planets; }

    public Planet getPlanetByName(String planetName) {
        for(Planet planet : planets){
            if (planet.getPlanetName().equals(planetName)) {
                return planet;
            }
        }
        return null;
    }

    public void addPlanet(Planet planet) {
        if (Objects.nonNull(planets)) {
            this.getPlanets().add(planet);
        } else {
            this.setPlanets(Collections.singletonList(planet));
        }
    }


    @Override
    public String toString() {
        return getGalaxyName() + "," + getPlanets() + ",";
    }
}
