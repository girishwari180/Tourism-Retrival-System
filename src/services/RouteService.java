package services;

import java.util.List;
import java.util.Map;

import algorithms.Dijkstra;
import algorithms.Dijkstra.Edge;
import data.GraphData;

public class RouteService {

    private Map<String, List<Edge>> graph;
    private Dijkstra dijkstra;

    public RouteService() {

        graph = GraphData.getGraph();

        dijkstra = new Dijkstra();
    }

    public List<String> findShortestRoute(
            String source,
            String destination) {

        if (source == null ||
                destination == null ||
                source.trim().isEmpty() ||
                destination.trim().isEmpty()) {

            return List.of();
        }

        source = findDestinationName(source);
        destination = findDestinationName(destination);

        if (source == null || destination == null) {
            return List.of();
        }

        return dijkstra.findShortestPath(
                graph,
                source,
                destination
        );
    }

    public int getRouteDistance(
            String source,
            String destination) {

        List<String> route =
                findShortestRoute(
                        source,
                        destination
                );

        if (route.isEmpty()) {
            return -1;
        }

        return dijkstra.getShortestDistance(
                route.get(route.size() - 1)
        );
    }

    public boolean destinationExists(
            String destination) {

        return findDestinationName(
                destination
        ) != null;
    }

    private String findDestinationName(
            String input) {

        if (input == null) {
            return null;
        }

        String search =
                input.trim().toLowerCase();

        for (String destination :
                graph.keySet()) {

            if (destination
                    .toLowerCase()
                    .equals(search)) {

                return destination;
            }
        }

        return null;
    }

    public void displayAvailableDestinations() {

        System.out.println(
                "\nAvailable Tourism Locations:"
        );

        for (String destination :
                graph.keySet()) {

            System.out.println(
                    "- " + destination
            );
        }
    }
}