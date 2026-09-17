package services;

import java.util.ArrayList;
import java.util.List;

import algorithms.EditDistance;
import algorithms.KMP;
import algorithms.RabinKarp;
import algorithms.Ranking;
import model.Destination;

public class SearchEngine {

    private List<Destination> destinations;
    private DestinationIndex index;

    public SearchEngine(List<Destination> destinations) {

        this.destinations = destinations;
        this.index = new DestinationIndex(destinations);
    }


    // ==================================================
    // 1. HASHMAP EXACT SEARCH
    // ==================================================

    public List<Destination> hashMapSearch(String query) {

        List<Destination> results = new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        Destination destination =
                index.findExact(query);

        if (destination != null) {
            results.add(destination);
        }

        return results;
    }


    // ==================================================
    // 2. KMP SEARCH
    // ==================================================

    public List<Destination> kmpSearch(String query) {

        List<Destination> results =
                new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        for (Destination destination : destinations) {

            String name =
                    destination.getName();

            int position =
                    KMP.search(name, query);

            if (position != -1) {

                results.add(destination);
            }
        }

        return results;
    }


    // ==================================================
    // 3. RABIN-KARP SEARCH
    // ==================================================

    public List<Destination> rabinKarpSearch(
            String query) {

        List<Destination> results =
                new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        for (Destination destination : destinations) {

            String name =
                    destination.getName();

            int position =
                    RabinKarp.search(name, query);

            if (position != -1) {

                results.add(destination);
            }
        }

        return results;
    }


    // ==================================================
    // 4. FUZZY SEARCH USING EDIT DISTANCE
    // ==================================================

    public List<Destination> fuzzySearch(
            String query) {

        List<Destination> results =
                new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        for (Destination destination :
                destinations) {

            int distance =
                    EditDistance.calculate(
                            destination.getName(),
                            query
                    );

            if (distance <= 3) {

                results.add(destination);
            }
        }

        return Ranking.rankByRating(results);
    }


    // ==================================================
    // 5. CATEGORY / TAG SEARCH
    // ==================================================

    public List<Destination> tagSearch(
            String query) {

        List<Destination> results =
                new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        for (Destination destination :
                destinations) {

            for (String tag :
                    destination.getTags()) {

                if (KMP.search(tag, query) != -1) {

                    if (!results.contains(destination)) {

                        results.add(destination);
                    }

                    break;
                }
            }
        }

        return Ranking.rankByRating(results);
    }


    // ==================================================
    // 6. COMBINED SMART SEARCH
    // ==================================================

    public List<Destination> smartSearch(
            String query) {

        List<Destination> results =
                new ArrayList<>();

        if (query == null ||
                query.trim().isEmpty()) {

            return results;
        }

        // ----------------------------------------------
        // HashMap Exact Search
        // ----------------------------------------------

        Destination exact =
                index.findExact(query);

        if (exact != null) {

            results.add(exact);

            return results;
        }


        // ----------------------------------------------
        // KMP Search
        // ----------------------------------------------

        List<Destination> kmpResults =
                kmpSearch(query);

        for (Destination destination :
                kmpResults) {

            if (!results.contains(destination)) {

                results.add(destination);
            }
        }


        // ----------------------------------------------
        // Tag Search
        // ----------------------------------------------

        List<Destination> tagResults =
                tagSearch(query);

        for (Destination destination :
                tagResults) {

            if (!results.contains(destination)) {

                results.add(destination);
            }
        }


        // ----------------------------------------------
        // Edit Distance
        // ----------------------------------------------

        List<Destination> fuzzyResults =
                fuzzySearch(query);

        for (Destination destination :
                fuzzyResults) {

            if (!results.contains(destination)) {

                results.add(destination);
            }
        }


        // ----------------------------------------------
        // Final Ranking
        // ----------------------------------------------

        return Ranking.rankByRating(results);
    }


    // ==================================================
    // GET NUMBER OF DESTINATIONS
    // ==================================================

    public int getDestinationCount() {

        return destinations.size();
    }
}