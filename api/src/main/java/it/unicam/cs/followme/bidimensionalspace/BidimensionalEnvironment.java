package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.EnvironmentEntity;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.List;
import java.util.stream.Collectors;

public class BidimensionalEnvironment<EnvironmentEntity> implements Environment {

    private List<EnvironmentEntity> entities;

    public void addEnvironmentEntities(List entities) {
        this.entities.addAll(entities);
    }

    @Override
    public List<EnvironmentEntity> getEntities() {
        return this.entities;
    }

    @Override
    public List<Robot> getRobots() {
        return this.entities.stream()
                .filter(Robot.class::isInstance)
                .map(Robot.class::cast)
                .collect(Collectors.toList());
    }

    @Override
    public List<Area> getAreas() {
        return this.entities.stream()
                .filter(Area.class::isInstance)
                .map (Area.class::cast)
                .collect(Collectors.toList());
    }
}
