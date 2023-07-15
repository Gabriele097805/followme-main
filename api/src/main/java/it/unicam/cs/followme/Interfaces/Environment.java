package it.unicam.cs.followme.Interfaces;

import java.util.List;

public interface Environment<E extends EnvironmentEntity> {
    List<EnvironmentEntity> getEntities();
}
