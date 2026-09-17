package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Destination;

public class Ranking {

    public static List<Destination> rankByRating(
            List<Destination> destinations) {

        // Create a copy so original list is not changed
        List<Destination> rankedList =
                new ArrayList<>(destinations);

        // Sort from highest rating to lowest rating
        rankedList.sort(
                Comparator.comparingDouble(
                        Destination::getRating
                ).reversed()
        );

        return rankedList;
    }
}