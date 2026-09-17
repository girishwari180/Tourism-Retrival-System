import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorithms.EditDistance;
import algorithms.KMP;
import algorithms.RabinKarp;
import data.TourismData;
import model.Destination;
import services.DestinationIndex;
import services.RouteService;
import services.SearchEngine;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Destination> destinations =
                TourismData.getDestinations();

        DestinationIndex index =
                new DestinationIndex(destinations);

        SearchEngine searchEngine =
                new SearchEngine(destinations);

        RouteService routeService =
                new RouteService();

        showWelcome();

        boolean running = true;

        while (running) {

            showMainMenu();

            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {

                System.out.println(
                        "\nInvalid input. Please enter a number."
                );

                continue;
            }

            switch (choice) {

                case 1:
                    searchMenu(searchEngine);
                    break;

                case 2:
                    showAllDestinations(destinations);
                    break;

                case 3:
                    categorySearch(destinations);
                    break;

                case 4:
                    destinationDetails(
                            destinations,
                            index
                    );
                    break;

                case 5:
                    routeOptimization(routeService);
                    break;

                case 6:
                    algorithmInformation();
                    break;

                case 7:
                    systemInformation(
                            destinations,
                            index
                    );
                    break;

                case 8:
                    System.out.println(
                            "\n========================================"
                    );

                    System.out.println(
                            "Thank you for using Tourism Retrieval System!"
                    );

                    System.out.println(
                            "========================================"
                    );

                    running = false;
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please select 1-8."
                    );
            }
        }

        scanner.close();
    }

    // =========================================================
    // WELCOME
    // =========================================================

    private static void showWelcome() {

        System.out.println();
        System.out.println(
                "=============================================="
        );

        System.out.println(
                "        TOURISM RETRIEVAL SYSTEM"
        );

        System.out.println(
                "=============================================="
        );

        System.out.println(
                " Algorithm-Driven Tourism Information System"
        );

        System.out.println(
                " Search | Fuzzy Matching | Ranking | Routing"
        );

        System.out.println(
                "=============================================="
        );

        System.out.println();
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void showMainMenu() {

        System.out.println();
        System.out.println(
                "--------------- MAIN MENU ----------------"
        );

        System.out.println(
                "1. Smart Search"
        );

        System.out.println(
                "2. View All Destinations"
        );

        System.out.println(
                "3. Search by Category"
        );

        System.out.println(
                "4. View Destination Details"
        );

        System.out.println(
                "5. Route Optimization"
        );

        System.out.println(
                "6. Algorithm Information"
        );

        System.out.println(
                "7. System Information"
        );

        System.out.println(
                "8. Exit"
        );

        System.out.println(
                "-------------------------------------------"
        );
    }

    // =========================================================
    // SMART SEARCH MENU
    // =========================================================

    private static void searchMenu(
            SearchEngine searchEngine) {

        boolean back = false;

        while (!back) {

            System.out.println();

            System.out.println(
                    "========== SMART SEARCH =========="
            );

            System.out.println(
                    "1. HashMap Exact Search"
            );

            System.out.println(
                    "2. KMP String Matching"
            );

            System.out.println(
                    "3. Rabin-Karp String Matching"
            );

            System.out.println(
                    "4. Edit Distance / Fuzzy Search"
            );

            System.out.println(
                    "5. Category / Tag Search"
            );

            System.out.println(
                    "6. Combined Smart Search"
            );

            System.out.println(
                    "7. Back"
            );

            System.out.println(
                    "=================================="
            );

            System.out.print(
                    "Enter your choice: "
            );

            String input =
                    scanner.nextLine();

            int choice;

            try {

                choice =
                        Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nInvalid input."
                );

                continue;
            }

            switch (choice) {

                case 1:
                    performHashMapSearch(
                            searchEngine
                    );
                    break;

                case 2:
                    performKMPSearch(
                            searchEngine
                    );
                    break;

                case 3:
                    performRabinKarpSearch(
                            searchEngine
                    );
                    break;

                case 4:
                    performFuzzySearch(
                            searchEngine
                    );
                    break;

                case 5:
                    performTagSearch(
                            searchEngine
                    );
                    break;

                case 6:
                    performSmartSearch(
                            searchEngine
                    );
                    break;

                case 7:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice."
                    );
            }
        }
    }

    // =========================================================
    // HASHMAP SEARCH
    // =========================================================

    private static void performHashMapSearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== HASHMAP EXACT SEARCH =========="
        );

        System.out.print(
                "Enter destination name: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.hashMapSearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "HashMap Exact Search"
        );
    }

    // =========================================================
    // KMP SEARCH
    // =========================================================

    private static void performKMPSearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== KMP STRING MATCHING =========="
        );

        System.out.print(
                "Enter search text: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.kmpSearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "KMP String Matching"
        );
    }

    // =========================================================
    // RABIN-KARP SEARCH
    // =========================================================

    private static void performRabinKarpSearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== RABIN-KARP SEARCH =========="
        );

        System.out.print(
                "Enter search text: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.rabinKarpSearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "Rabin-Karp String Matching"
        );
    }

    // =========================================================
    // FUZZY SEARCH
    // =========================================================

    private static void performFuzzySearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== EDIT DISTANCE / FUZZY SEARCH =========="
        );

        System.out.print(
                "Enter destination name: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.fuzzySearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "Edit Distance / Fuzzy Search"
        );
    }

    // =========================================================
    // TAG SEARCH
    // =========================================================

    private static void performTagSearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== CATEGORY / TAG SEARCH =========="
        );

        System.out.print(
                "Enter category or tag: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.tagSearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "Category / Tag Search"
        );
    }

    // =========================================================
    // COMBINED SMART SEARCH
    // =========================================================

    private static void performSmartSearch(
            SearchEngine searchEngine) {

        System.out.println();

        System.out.println(
                "========== COMBINED SMART SEARCH =========="
        );

        System.out.println(
                "Uses exact matching, KMP, tags,"
        );

        System.out.println(
                "fuzzy matching and ranking."
        );

        System.out.print(
                "\nEnter your query: "
        );

        String query =
                scanner.nextLine();

        long startTime =
                System.nanoTime();

        List<Destination> results =
                searchEngine.smartSearch(query);

        long endTime =
                System.nanoTime();

        displayResults(
                results,
                endTime - startTime,
                "Combined Smart Search"
        );
    }

    // =========================================================
    // DISPLAY SEARCH RESULTS
    // =========================================================

    private static void displayResults(
            List<Destination> results,
            long timeTaken,
            String algorithmName) {

        System.out.println();

        System.out.println(
                "-------------------------------------------"
        );

        System.out.println(
                "Algorithm: " + algorithmName
        );

        System.out.println(
                "-------------------------------------------"
        );

        if (results.isEmpty()) {

            System.out.println(
                    "No matching destinations found."
            );

            System.out.println(
                    "-------------------------------------------"
            );

            System.out.println(
                    "Search Time: "
                    + timeTaken
                    + " ns"
            );

            System.out.println(
                    "-------------------------------------------"
            );

            return;
        }

        System.out.println(
                "Matching Destinations:"
        );

        System.out.println();

        for (int i = 0;
             i < results.size();
             i++) {

            Destination destination =
                    results.get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + destination.getName()
            );

            System.out.println(
                    "   Location: "
                    + destination.getCity()
                    + ", "
                    + destination.getState()
            );

            System.out.println(
                    "   Type: "
                    + destination.getType()
            );

            System.out.println(
                    "   Rating: "
                    + destination.getRating()
            );

            System.out.println();
        }

        System.out.println(
                "Number of Results: "
                + results.size()
        );

        System.out.println(
                "Search Time: "
                + timeTaken
                + " ns"
        );

        System.out.println(
                "-------------------------------------------"
        );
    }

    // =========================================================
    // VIEW ALL DESTINATIONS
    // =========================================================

    private static void showAllDestinations(
            List<Destination> destinations) {

        System.out.println();

        System.out.println(
                "========== ALL TOURISM DESTINATIONS =========="
        );

        for (int i = 0;
             i < destinations.size();
             i++) {

            Destination destination =
                    destinations.get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + destination.getName()
            );

            System.out.println(
                    "   "
                    + destination.getCity()
                    + ", "
                    + destination.getState()
            );

            System.out.println(
                    "   Type: "
                    + destination.getType()
            );

            System.out.println(
                    "   Rating: "
                    + destination.getRating()
            );

            System.out.println();
        }

        System.out.println(
                "Total Destinations: "
                + destinations.size()
        );

        System.out.println(
                "==============================================="
        );
    }

    // =========================================================
    // CATEGORY SEARCH
    // =========================================================

    private static void categorySearch(
            List<Destination> destinations) {

        System.out.println();

        System.out.println(
                "========== CATEGORY SEARCH =========="
        );

        System.out.println(
                "Available Categories:"
        );

        System.out.println(
                "Historical"
        );

        System.out.println(
                "Beach"
        );

        System.out.println(
                "Nature"
        );

        System.out.println(
                "Hill Station"
        );

        System.out.println(
                "Adventure"
        );

        System.out.println(
                "Cultural"
        );

        System.out.print(
                "\nEnter category: "
        );

        String category =
                scanner.nextLine()
                        .trim();

        List<Destination> results =
                new ArrayList<>();

        for (Destination destination :
                destinations) {

            if (destination
                    .getType()
                    .equalsIgnoreCase(category)) {

                results.add(destination);
            }
        }

        System.out.println();

        if (results.isEmpty()) {

            System.out.println(
                    "No destinations found in category: "
                    + category
            );

            return;
        }

        System.out.println(
                "Destinations in "
                + category
                + ":"
        );

        System.out.println();

        for (Destination destination :
                results) {

            System.out.println(
                    "- "
                    + destination.getName()
                    + " | Rating: "
                    + destination.getRating()
            );
        }

        System.out.println();

        System.out.println(
                "Total Results: "
                + results.size()
        );
    }

    // =========================================================
    // DESTINATION DETAILS
    // =========================================================

    private static void destinationDetails(
            List<Destination> destinations,
            DestinationIndex index) {

        System.out.println();

        System.out.println(
                "========== DESTINATION DETAILS =========="
        );

        System.out.print(
                "Enter destination name: "
        );

        String query =
                scanner.nextLine();

        Destination destination =
                index.findExact(query);

        if (destination == null) {

            System.out.println(
                    "\nDestination not found."
            );

            System.out.println(
                    "Try entering the exact destination name."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "-------------------------------------------"
        );

        System.out.println(
                "Name: "
                + destination.getName()
        );

        System.out.println(
                "City: "
                + destination.getCity()
        );

        System.out.println(
                "State: "
                + destination.getState()
        );

        System.out.println(
                "Type: "
                + destination.getType()
        );

        System.out.println(
                "Rating: "
                + destination.getRating()
        );

        System.out.println(
                "Description: "
                + destination.getDescription()
        );

        System.out.println(
                "Tags: "
                + String.join(
                        ", ",
                        destination.getTags()
                )
        );

        System.out.println(
                "-------------------------------------------"
        );
    }

    // =========================================================
    // DIJKSTRA ROUTE OPTIMIZATION
    // =========================================================

    private static void routeOptimization(
            RouteService routeService) {

        System.out.println();

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "           ROUTE OPTIMIZATION"
        );

        System.out.println(
                "        DIJKSTRA SHORTEST PATH"
        );

        System.out.println(
                "=============================================="
        );

        routeService.displayAvailableDestinations();

        System.out.println();

        System.out.print(
                "Enter source destination: "
        );

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter destination: "
        );

        String destination =
                scanner.nextLine();

        // Validate source
        if (!routeService.destinationExists(source)) {

            System.out.println();

            System.out.println(
                    "Source destination not found."
            );

            return;
        }

        // Validate destination
        if (!routeService.destinationExists(destination)) {

            System.out.println();

            System.out.println(
                    "Destination not found."
            );

            return;
        }

        // Same source and destination
        if (source.trim()
                .equalsIgnoreCase(
                        destination.trim()
                )) {

            System.out.println();

            System.out.println(
                    "Source and destination are the same."
            );

            System.out.println(
                    "Minimum Distance: 0 km"
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Calculating shortest route..."
        );

        long startTime =
                System.nanoTime();

        List<String> route =
                routeService.findShortestRoute(
                        source,
                        destination
                );

        long endTime =
                System.nanoTime();

        if (route.isEmpty()) {

            System.out.println();

            System.out.println(
                    "No route found between the "
                    + "selected destinations."
            );

            return;
        }

        int distance =
                routeService.getRouteDistance(
                        source,
                        destination
                );

        System.out.println();

        System.out.println(
                "========== SHORTEST ROUTE =========="
        );

        System.out.println();

        System.out.println(
                "Source: "
                + route.get(0)
        );

        System.out.println(
                "Destination: "
                + route.get(route.size() - 1)
        );

        System.out.println();

        System.out.println(
                "Route:"
        );

        for (int i = 0;
             i < route.size();
             i++) {

            System.out.print(
                    route.get(i)
            );

            if (i < route.size() - 1) {

                System.out.print(
                        " → "
                );
            }
        }

        System.out.println();

        System.out.println();

        System.out.println(
                "Minimum Distance: "
                + distance
                + " km"
        );

        System.out.println(
                "Number of Locations: "
                + route.size()
        );

        System.out.println(
                "Algorithm Used: Dijkstra"
        );

        System.out.println(
                "Time Complexity: O((V + E) log V)"
        );

        System.out.println(
                "Execution Time: "
                + (endTime - startTime)
                + " ns"
        );

        System.out.println(
                "===================================="
        );
    }

    // =========================================================
    // ALGORITHM INFORMATION
    // =========================================================

    private static void algorithmInformation() {

        System.out.println();

        System.out.println(
                "========== ALGORITHM INFORMATION =========="
        );

        System.out.println();

        System.out.println(
                "1. HashMap"
        );

        System.out.println(
                "   Purpose: Exact destination lookup"
        );

        System.out.println(
                "   Average Complexity: O(1)"
        );

        System.out.println();

        System.out.println(
                "2. KMP"
        );

        System.out.println(
                "   Purpose: Exact substring matching"
        );

        System.out.println(
                "   Complexity: O(n + m)"
        );

        System.out.println();

        System.out.println(
                "3. Rabin-Karp"
        );

        System.out.println(
                "   Purpose: Hash-based string matching"
        );

        System.out.println(
                "   Average Complexity: O(n + m)"
        );

        System.out.println();

        System.out.println(
                "4. Edit Distance"
        );

        System.out.println(
                "   Purpose: Fuzzy matching / spelling tolerance"
        );

        System.out.println(
                "   Complexity: O(nm)"
        );

        System.out.println();

        System.out.println(
                "5. Sorting"
        );

        System.out.println(
                "   Purpose: Ranking destinations by rating"
        );

        System.out.println(
                "   Complexity: O(n log n)"
        );

        System.out.println();

        System.out.println(
                "6. Dijkstra"
        );

        System.out.println(
                "   Purpose: Shortest route optimization"
        );

        System.out.println(
                "   Complexity: O((V + E) log V)"
        );

        System.out.println();

        System.out.println(
                "============================================"
        );
    }

    // =========================================================
    // SYSTEM INFORMATION
    // =========================================================

    private static void systemInformation(
            List<Destination> destinations,
            DestinationIndex index) {

        System.out.println();

        System.out.println(
                "========== SYSTEM INFORMATION =========="
        );

        System.out.println();

        System.out.println(
                "Application:"
        );

        System.out.println(
                "Tourism Information Retrieval System"
        );

        System.out.println();

        System.out.println(
                "Programming Language: Java"
        );

        System.out.println(
                "Data Structure: HashMap, List, Graph"
        );

        System.out.println(
                "Search Algorithms: KMP, Rabin-Karp"
        );

        System.out.println(
                "Fuzzy Matching: Edit Distance"
        );

        System.out.println(
                "Ranking: Sorting"
        );

        System.out.println(
                "Route Optimization: Dijkstra"
        );

        System.out.println();

        System.out.println(
                "Total Destinations: "
                + destinations.size()
        );

        System.out.println(
                "HashMap Index Size: "
                + index.size()
        );

        System.out.println();

        System.out.println(
                "Main Pipeline:"
        );

        System.out.println(
                "Input Query"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Preprocessing"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Exact / Fuzzy Matching"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Retrieve"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Rank"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Shortest Route"
        );

        System.out.println(
                "    ↓"
        );

        System.out.println(
                "Display Results"
        );

        System.out.println();

        System.out.println(
                "========================================"
        );
    }
}