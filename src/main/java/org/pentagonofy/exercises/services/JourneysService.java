package org.pentagonofy.exercises.services;

import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.entities.Record;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service provides utility methods to manage journeys. A journey is a car travel from the ENTRY to the EXIT.
 */
public class JourneysService {

    private JourneysService() {
        // prevent creation of instances for this class, since all methods are static
    }

    /**
     * Runs through all the records in a given log and calculates the number of EXITs. Each exit indicates a completed journey.
     * @param log - Log object containing entries
     * @return long value of total journeys completed by all cars
     */
    public static long countTotalJourneys(Log log) {
        return log
                .records()
                .stream()
                .filter((r) -> Record.BoothType.EXIT.equals(r.boothType())).count();
    }

    /**
     * Runs through all the records in a given log and calcilates the number of EXITs per licensePlate value.
     * @param log - Log object containing entries
     * @return Map of LicensePlate:String, journeysCount:long as a result.
     */
    public static Map<String, Long> countJourneysPerLicensePlate(Log log) {
        return log
                .records()
                .stream()
                .filter(r -> Record.BoothType.EXIT.equals(r.boothType()))
                .collect(Collectors.groupingBy(Record::licensePlate, Collectors.counting()));
    }
}
