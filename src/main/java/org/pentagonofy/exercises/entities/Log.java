package org.pentagonofy.exercises.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a log that tracks a collection of records.
 * This class is designed to store, manage, and provide access to a list
 * of {@code Record} objects. Each record encapsulates detailed data
 * about a single vehicle's interaction with a toll system.
 * The main functions of this class include:
 * - Adding a new record to the log.
 * - Retrieving the complete list of records.
 * - Determining the number of records stored in the log.
 */
public class Log {
    private final List<Record> records = new ArrayList<>();

    public Log() {
    }

    public List<Record> records() {
        return Collections.unmodifiableList(records);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public int size() {
        return records.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Record record : records) {
            sb.append(record.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
