package it.unicam.cs.followme.app;


import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalEnvironment;
import it.unicam.cs.followme.bidimensionalspace.CommandHandler;
import it.unicam.cs.followme.bidimensionalspace.SimpleRobot;
import it.unicam.cs.followme.bidimensionalspace.shapes.BiDimensionalAreaCreator;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleCreator;
import it.unicam.cs.followme.bidimensionalspace.shapes.RectangleCreator;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {
    private static final String environmentFile = "../app/src/main/resources/environment.txt";

    private static final String commandsFile = "../app/src/main/resources/commands.txt";

    private static final Path environmentPath = Paths.get(environmentFile);

    private static final Path commandPath = Paths.get(commandsFile);

    public static void main(String[] args) throws FollowMeParserException, IOException {
        int robotNumber;
        int turns;

        InputChecker checker = new InputChecker();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Robot number:");

        robotNumber = checker.checkInput(scanner);

        System.out.println("Simulation time:");

        turns = checker.checkInput(scanner);

        scanner.close();

        Environment<Double, Double> environment = new BiDimensionalEnvironment();
        FollowMeParserHandler handler = new CommandHandler(environment, turns);
        FollowMeParser parser = new FollowMeParser(handler);

        List<ShapeData> shapesData = parser.parseEnvironment(environmentPath);
        List<Area<Double>> areas = new ArrayList<>();
        AreaCreator<Double> rectangle = new RectangleCreator();
        AreaCreator<Double> circle = new CircleCreator();
        AreaCreator<Double> creator = new BiDimensionalAreaCreator(List.of(rectangle, circle));
        for (ShapeData data : shapesData) {
            Optional<Area<Double>> area = creator.createArea(data);
            if (area.isPresent()) {
                areas.add(area.get());
            } else {
                throw new IllegalArgumentException();
            }
        }

        List<Robot<Double, Double>> robots = new ArrayList<>();
        for (int i = 0; i < robotNumber; i++) {
            robots.add(new SimpleRobot(i, environment));
        }

        environment.addElements(robots, areas);

        parser.parseRobotProgram(commandPath);

    }
}
