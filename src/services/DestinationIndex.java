package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Destination;

public class DestinationIndex {

    // HashMap used for fast destination lookup
    private Map<String, Destination> destinationMap;

    // Constructor
    public DestinationIndex(List<Destination> destinations) {

        destinationMap = new HashMap<>();

        buildIndex(destinations);
    }

    // Build HashMap index
    private void buildIndex(List<Destination> destinations) {

        for (Destination destination : destinations) {

            String key = normalize(destination.getName());

            destinationMap.put(key, destination);
        }
    }

    // Normalize search text
    private String normalize(String text) {

        return text
                .toLowerCase()
                .trim()
                .replaceAll("\\s+", " ");
    }

    // Exact destination search using HashMap
    public Destination findExact(String query) {

        String key = normalize(query);

        return destinationMap.get(key);
    }

    // Check whether destination exists
    public boolean contains(String query) {

        String key = normalize(query);

        return destinationMap.containsKey(key);
    }

    // Number of indexed destinations
    public int size() {

        return destinationMap.size();
    }
}