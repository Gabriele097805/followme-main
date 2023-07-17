package it.unicam.cs.followme.app;


import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalEnvironment;
import it.unicam.cs.followme.bidimensionalspace.ParserHandler;
import it.unicam.cs.followme.bidimensionalspace.SimpleRobot;
import it.unicam.cs.followme.bidimensionalspace.shapes.BiDimensionalAreaCreator;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleCreator;
import it.unicam.cs.followme.bidimensionalspace.shapes.RectangleCreator;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {

    private static String environmentFile = "C:/Users/Gavriel/Documents/GitHub/other/followme-main/app/src/main/resources/environment.txt";

    private static String commandsFile = "C:/Users/Gavriel/Documents/GitHub/other/followme-main/app/src/main/resources/commands.txt";

    private static Path environmentPath = Paths.get(environmentFile);

    private static Path commandPath = Paths.get(commandsFile);

    public static void main(String[] args) throws FollowMeParserException, IOException {

        Scanner scanner = new Scanner(System.in);

        int input = 4;

        System.out.println("Simulation started");
        System.out.println("Robot number:");

        /*try {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                scanner.next();
            }
        } catch (InputMismatchException e) {
            scanner.next();
        }*/

        Environment environment = new BiDimensionalEnvironment();
        ParserHandler handler = new ParserHandler(environment);
        FollowMeParser parser = new FollowMeParser(handler);

        List<ShapeData> shapesData = parser.parseEnvironment(environmentPath);
        List<Area> areas = new ArrayList<>();
        AreaCreator rectangle = new RectangleCreator();
        AreaCreator circle = new CircleCreator();
        AreaCreator creator = new BiDimensionalAreaCreator(List.of(rectangle, circle));
        for (ShapeData data : shapesData) {
            Optional<Area> area = creator.createArea(data);
            if (area.isPresent()) {
                areas.add(area.get());
            } else {
                throw new IllegalArgumentException();
            }
        }

        scanner.close();

        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            robots.add(new SimpleRobot(i));
        }

        environment.addElements(robots, areas);

        parser.parseRobotProgram(commandPath);

    }
}
