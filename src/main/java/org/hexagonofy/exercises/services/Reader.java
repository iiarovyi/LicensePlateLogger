package org.hexagonofy.exercises.services;

import org.hexagonofy.exercises.entities.Log;
import org.hexagonofy.exercises.exceptions.ReaderException;

import java.nio.file.Path;

public interface Reader {
    void read(Path path) throws ReaderException;

    Log getLog();
}
