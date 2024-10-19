package Space2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static List<Galaxy> loadedGalaxy = new ArrayList<>();

    public static void main(String[] args) {
//        Galaxy galaxy = defineGalaxy(scanner);
        loadedGalaxy = loadPlanetFromFile();
        System.out.println("به سیستم مدیریت کهکشانی خوش آمدید!");
        System.out.println(".1 نمایش کهکشانها\n" +
                ".2 اضافه کردن سیاره جدید\n" +
                ".3 تغییر تعداد قمر سیاره\n" +
                ".4 نمایش اطالعات سیاره\n" +
                "انتخاب شما:");


        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                displayGalaxies();
                break;
            case 2:
                addNewPlanet();
                break;
            case 3:
                changeMoonCount();
                break;
            case 4:
                displayPlanetInfo();
                break;
            default:
                System.out.println("انتخاب نامعتبر. لطفاً دوباره تلاش کنید.");
        }} while (choice != 5) ;
    }


    private static Galaxy defineGalaxy(Scanner scanner, List<Planet> planets) {
        while (true) {
            try {
                System.out.println("Enter Galaxy name:");
                String galaxyname = scanner.nextLine();
                if (galaxyname.trim().equals("")) {
                    throw new Exception("Invalid name");
                }
                Galaxy galaxy = new Galaxy(galaxyname, planets);
                return galaxy;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }


    private static void changeMoonCount() {
        System.out.print("نام سیاره: ");
        Scanner scanner = new Scanner(System.in);
        String planetName = scanner.nextLine();

        Planet planet = findPlanetByName(planetName);
        if (planet != null) {
            System.out.print("تعداد جدید قمرها: ");
            int newMoons = Integer.parseInt(scanner.nextLine());
            planet.setNumberOfMoons(newMoons);
            System.out.println("تعداد قمرهای سیاره \"" + planetName + "\" با موفقیت تغییر کرد.\n");
        } else {
            System.out.println("سیاره‌ای با این نام یافت نشد.\n");
        }
    }


    private static void displayGalaxies() {
        System.out.println("-------------displayGalaxies----------------");
        for (Galaxy galaxy : loadedGalaxy) {
            System.out.println("کهکشان: " + galaxy.getGalaxyName());
            System.out.println("سیارات:");
            for (Planet planet : galaxy.getPlanets()) {
                System.out.println(planet);
            }
            System.out.println("-----------------------------");
        }
        System.out.println("-----------------------------");
    }


    private static void addNewPlanet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("نام سیاره: ");
        String name = scanner.nextLine();

        if (findPlanetByName(name) != null) {
            System.out.println("نام سیاره تکراری است. لطفاً نام دیگری انتخاب کنید.\n");
            return;
        }

        System.out.print("نام کهکشان: ");
        String galaxyName = scanner.nextLine();

        System.out.print("نوع سیاره (سنگی/گازی): ");
        String typeInput = scanner.nextLine();

        PlanetType type;
        if (typeInput.equalsIgnoreCase("سنگی") || typeInput.equalsIgnoreCase("Rock")) {
            type = PlanetType.Rock;
        } else if (typeInput.equalsIgnoreCase("گازی") || typeInput.equalsIgnoreCase("Gas")) {
            type = PlanetType.Gas;
        } else {
            System.out.println("نوع سیاره نامعتبر است. باید 'سنگی' یا 'گازی' باشد.");
            return;
        }

        System.out.print("تعداد قمرها: ");
        int moons = Integer.parseInt(scanner.nextLine());

        System.out.print("فاصله از خورشید: ");
        double distance = Double.parseDouble(scanner.nextLine());

        System.out.print("آیا دارای حیات است؟ (بله/خیر): ");
        String hasLifeInput = scanner.nextLine();
        boolean hasLife = hasLifeInput.equalsIgnoreCase("بله");

        System.out.print("منابع طبیعی: ");
        String resourcesInput = scanner.nextLine();
        ArrayList<String> resources = new ArrayList<>();
        if (!resourcesInput.isEmpty()) {
            String[] resourcesArray = resourcesInput.split(",");
            for (String res : resourcesArray) {
                resources.add(res.trim());
            }
        }

        Planet newPlanet;
        if (hasLife) {
            newPlanet = new LifeSupportingPlanet(name, type, moons, distance, true);
        } else if (!resources.isEmpty()) {
            newPlanet = new ResourceRichPlanet(name, type, moons, distance, resources);
        } else {
            newPlanet = new Planet(name, type, moons, distance);
        }

        Galaxy galaxy = findGalaxyByName(galaxyName);
        if (galaxy == null) {
            List<Planet> planets = new ArrayList<>();
            planets.add(newPlanet);
            galaxy = new Galaxy(galaxyName, planets);
            loadedGalaxy.add(galaxy);
        }

        galaxy.addPlanet(newPlanet);
        System.out.println("سیاره جدید با نام \"" + name + "\" اضافه شد.\n");
    }


    private static void displayPlanetInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("نام سیاره: ");
        String planetName = scanner.nextLine();

        Space2.Planet planet = findPlanetByName(planetName);
        if (planet != null) {
            System.out.println(planet);
            if (planet instanceof Space2.LifeSupportingPlanet) {
                LifeSupportingPlanet lifePlanet = (Space2.LifeSupportingPlanet) planet;
                if (lifePlanet.isSupportLife()) {
                    System.out.println("این سیاره دارای حیات است.");
                } else {
                    System.out.println("این سیاره دارای حیات نیست.");
                }
            }
            if (planet instanceof Space2.ResourceRichPlanet) {
                Space2.ResourceRichPlanet resourcePlanet = (Space2.ResourceRichPlanet) planet;
                System.out.println("منابع طبیعی: " + String.join(", ", resourcePlanet.getResources()));
            }
            System.out.println();
        } else {
            System.out.println("سیاره‌ای با این نام یافت نشد.\n");
        }
    }


    private static List<Galaxy> loadPlanetFromFile() {
        File planetFile = new File("C:\\Users\\DoostanSystem\\Desktop\\JavaDotin\\JavaExam\\untitled\\src\\planets.txt");
        try {
            Map<String, List<Planet>> galaxyPlanetsMap = new HashMap<>();

            try{
                Scanner scanner = new Scanner(planetFile);

                while ( scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] planetData = line.split(",");
                    String planetName = planetData[0];
                    String galaxyName = planetData[1];
                    PlanetType planetType = PlanetType.valueOf(planetData[2]);
                    int numberOfMoon = Integer.parseInt(planetData[3]);
                    int distanceFromSun = Integer.parseInt(planetData[4]);
                    String lifeStatus = planetData[5];
                    boolean isSupportLife = lifeStatus.equalsIgnoreCase("has life");
                    List<String> resources = new ArrayList<>();
                    if (planetData.length > 6) {
                        String resourcesInput = planetData[6].trim();
                        if (!resourcesInput.equalsIgnoreCase("nothing")) {
                            resources = Arrays.asList(resourcesInput.split("،|,"));
                        }
                    }


                    if (!galaxyPlanetsMap.containsKey(galaxyName)) {
                        List<Planet> planets = new ArrayList<>();
                        if (isSupportLife && !resources.isEmpty()){
                            planets.add(new LifeSupportingPlanet(planetName, planetType, numberOfMoon, distanceFromSun, isSupportLife));
                        } else  if (isSupportLife && resources.isEmpty()){
                            planets.add(new ResourceRichPlanet(planetName, planetType, numberOfMoon, distanceFromSun, resources));
                        } else {
                            if (resources.isEmpty()){
                                planets.add(new Planet(planetName, planetType, numberOfMoon, distanceFromSun));

                            }
                        }
                        galaxyPlanetsMap.put(galaxyName, planets);
                    } else {

                        List<Planet> planets = galaxyPlanetsMap.get(galaxyName);
                        planets.add(new Planet(planetName, planetType, numberOfMoon, distanceFromSun));
                    }
                }
                scanner.close();

                List<Galaxy> galaxies = new ArrayList<>();
                for (String galaxyName : galaxyPlanetsMap.keySet()) {
                    Galaxy galaxy = new Galaxy(galaxyName, galaxyPlanetsMap.get(galaxyName));
                    galaxies.add(galaxy);
                }
                return galaxies;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Space2.Planet findPlanetByName(String name) {
        for (Space2.Galaxy galaxy : loadedGalaxy) {
            Space2.Planet planet = galaxy.getPlanetByName(name);
            if (planet != null) {
                return planet;
            }
        }
        return null;
    }


    private static Space2.Galaxy findGalaxyByName(String name) {
        for (Space2.Galaxy galaxy : loadedGalaxy) {
            if (galaxy.getGalaxyName().equalsIgnoreCase(name)) {
                return galaxy;
            }
        }
        return null;
    }


}



