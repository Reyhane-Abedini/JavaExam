package Space2;

import java.util.List;

public class Planet  {
    private String planetName;
    private Space2.PlanetType planetType;
    private int numberOfMoons;
    private double distanceFromSun;


    public Planet(String planetName, PlanetType planetType, int numberOfMoons, double distanceFromSun) {
        this.planetName = planetName;
        this.planetType = planetType;
        this.numberOfMoons = numberOfMoons;
        this.distanceFromSun = distanceFromSun;
    }




    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public void setPlanetType(PlanetType planetType) {
        this.planetType = planetType;
    }

    public void setNumberOfMoons(int numberOfMoons) { this.numberOfMoons = numberOfMoons; }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planetName='" + planetName + '\'' +
                ", planetType=" + planetType +
                ", countOfMoon=" + numberOfMoons +
                ", distanceFromSun=" + distanceFromSun +
                '}';
}


    }
