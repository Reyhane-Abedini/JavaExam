package Space;

public enum PlanetType {
    ROCK("سنگی"),
    GAS("گازی");

    private final String persianName;

    PlanetType(String persianName) {
        this.persianName = persianName;
    }

    @Override
    public String toString() {
        return persianName;
    }
}
