package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.EnvironmentEntity;

import java.util.List;

public class BidimensionalEnvironment implements Environment {

    private List<EnvironmentEntity> entities;

    public BidimensionalEnvironment() {

    }

    @Override
    public List<EnvironmentEntity> getEntities() {
        return this.entities;
    }
}
