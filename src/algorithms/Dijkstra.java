package algorithms;

import java.util.*;

public class Dijkstra {

    private Map<String, Integer> distances;
    private Map<String, String> previous;

    public Dijkstra() {
        distances = new HashMap<>();
        previous = new HashMap<>();
    }

    public List<String> findShortestPath(
            Map<String, List<Edge>> graph,
            String source,
            String destination) {

        distances.clear();
        previous.clear();

        // Initialize distances
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(source, 0);

        // Priority Queue
        PriorityQueue<Node> priorityQueue =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                node -> node.distance
                        )
                );

        priorityQueue.add(
                new Node(source, 0)
        );

        while (!priorityQueue.isEmpty()) {

            Node current =
                    priorityQueue.poll();

            String currentNode =
                    current.name;

            int currentDistance =
                    current.distance;

            // Ignore outdated queue entries
            if (currentDistance >
                    distances.get(currentNode)) {
                continue;
            }

            // Destination reached
            if (currentNode.equals(destination)) {
                break;
            }

            for (Edge edge :
                    graph.getOrDefault(
                            currentNode,
                            new ArrayList<>())) {

                String neighbor =
                        edge.destination;

                int newDistance =
                        currentDistance
                        + edge.weight;

                if (newDistance <
                        distances.getOrDefault(
                                neighbor,
                                Integer.MAX_VALUE)) {

                    distances.put(
                            neighbor,
                            newDistance
                    );

                    previous.put(
                            neighbor,
                            currentNode
                    );

                    priorityQueue.add(
                            new Node(
                                    neighbor,
                                    newDistance
                            )
                    );
                }
            }
        }

        // No route found
        if (!distances.containsKey(destination)
                || distances.get(destination)
                == Integer.MAX_VALUE) {

            return new ArrayList<>();
        }

        // Construct shortest path
        List<String> path =
                new ArrayList<>();

        String current =
                destination;

        while (current != null) {

            path.add(current);

            current =
                    previous.get(current);
        }

        Collections.reverse(path);

        return path;
    }

    public int getShortestDistance(
            String destination) {

        return distances.getOrDefault(
                destination,
                Integer.MAX_VALUE
        );
    }

    // Edge represents a connection between
    // two tourism locations
    public static class Edge {

        String destination;
        int weight;

        public Edge(
                String destination,
                int weight) {

            this.destination = destination;
            this.weight = weight;
        }
    }

    // Node used by PriorityQueue
    private static class Node {

        String name;
        int distance;

        Node(
                String name,
                int distance) {

            this.name = name;
            this.distance = distance;
        }
    }
}