package Space;

import Space.Planet;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Galaxy {
    private String name;
    private Map<String, Planet> planets;

    public Galaxy(String name) {
        this.name = name;
        this.planets = new HashMap<>(); }

    public String getName() { return name; }

    public Collection<Planet> getPlanets() { return planets.values(); }

    public void addPlanet(Planet planet) { planets.put(planet.getName().toLowerCase(), planet); }

    public Planet getPlanetByName(String name) { return planets.get(name.toLowerCase()); }

    public boolean hasPlanet(String name) { return planets.containsKey(name.toLowerCase()); }
}