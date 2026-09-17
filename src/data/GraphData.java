package data;

import java.util.*;

import algorithms.Dijkstra.Edge;

public class GraphData {

    public static Map<String, List<Edge>> getGraph() {

        Map<String, List<Edge>> graph =
                new HashMap<>();

        // Initialize all destinations
        String[] destinations = {
            "Taj Mahal",
            "Mysore Palace",
            "Goa Beach",
            "Charminar",
            "Kerala Backwaters",
            "Red Fort",
            "Ooty",
            "Jaipur City Palace",
            "Manali",
            "Rishikesh",
            "Hampi",
            "Darjeeling",
            "Varanasi Ghats",
            "Andaman Islands",
            "Udaipur City Palace"
        };

        for (String destination : destinations) {
            graph.put(
                    destination,
                    new ArrayList<>()
            );
        }

        /*
         * Tourism route connections
         * Weight = approximate route distance
         * represented in kilometres.
         */

        addEdge(graph, "Taj Mahal",
                "Red Fort", 200);

        addEdge(graph, "Taj Mahal",
                "Jaipur City Palace", 240);

        addEdge(graph, "Taj Mahal",
                "Varanasi Ghats", 600);

        addEdge(graph, "Red Fort",
                "Charminar", 1_550);

        addEdge(graph, "Red Fort",
                "Jaipur City Palace", 280);

        addEdge(graph, "Red Fort",
                "Udaipur City Palace", 660);

        addEdge(graph, "Jaipur City Palace",
                "Udaipur City Palace", 400);

        addEdge(graph, "Jaipur City Palace",
                "Manali", 700);

        addEdge(graph, "Udaipur City Palace",
                "Goa Beach", 1_100);

        addEdge(graph, "Charminar",
                "Hampi", 370);

        addEdge(graph, "Charminar",
                "Goa Beach", 660);

        addEdge(graph, "Hampi",
                "Goa Beach", 330);

        addEdge(graph, "Hampi",
                "Mysore Palace", 450);

        addEdge(graph, "Mysore Palace",
                "Ooty", 125);

        addEdge(graph, "Mysore Palace",
                "Kerala Backwaters", 380);

        addEdge(graph, "Goa Beach",
                "Kerala Backwaters", 600);

        addEdge(graph, "Kerala Backwaters",
                "Rishikesh", 2_800);

        addEdge(graph, "Manali",
                "Rishikesh", 470);

        addEdge(graph, "Manali",
                "Darjeeling", 1_900);

        addEdge(graph, "Rishikesh",
                "Varanasi Ghats", 850);

        addEdge(graph, "Darjeeling",
                "Varanasi Ghats", 700);

        addEdge(graph, "Varanasi Ghats",
                "Andaman Islands", 1_300);

        addEdge(graph, "Goa Beach",
                "Andaman Islands", 1_000);

        return graph;
    }

    private static void addEdge(
            Map<String, List<Edge>> graph,
            String source,
            String destination,
            int distance) {

        // Undirected graph:
        // both locations can be travelled between.

        graph.get(source).add(
                new Edge(destination, distance)
        );

        graph.get(destination).add(
                new Edge(source, distance)
        );
    }
}