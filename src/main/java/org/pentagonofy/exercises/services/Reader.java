package org.pentagonofy.exercises.services;

import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.exceptions.ReaderException;

import java.nio.file.Path;

public interface Reader {
    void read(Path path) throws ReaderException;

    Log getLog();
}
