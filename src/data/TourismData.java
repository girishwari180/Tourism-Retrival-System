package data;

import java.util.ArrayList;
import java.util.List;

import model.Destination;

public class TourismData {

    public static List<Destination> getDestinations() {

        List<Destination> destinations = new ArrayList<>();

        // A - Taj Mahal
        destinations.add(new Destination(
                "A",
                "Taj Mahal",
                "Agra",
                "Uttar Pradesh",
                "Historical",
                "A famous historical monument known for its architecture and heritage.",
                new String[]{
                        "history",
                        "monument",
                        "heritage",
                        "architecture"
                },
                4.9
        ));

        // B - Mysore Palace
        destinations.add(new Destination(
                "B",
                "Mysore Palace",
                "Mysore",
                "Karnataka",
                "Historical",
                "A magnificent palace known for royal heritage and architecture.",
                new String[]{
                        "history",
                        "palace",
                        "heritage",
                        "architecture"
                },
                4.8
        ));

        // C - Goa Beach
        destinations.add(new Destination(
                "C",
                "Goa Beach",
                "Panaji",
                "Goa",
                "Beach",
                "Popular beaches offering scenic views, relaxation and water activities.",
                new String[]{
                        "beach",
                        "sea",
                        "water",
                        "relaxation"
                },
                4.7
        ));

        // D - Charminar
        destinations.add(new Destination(
                "D",
                "Charminar",
                "Hyderabad",
                "Telangana",
                "Historical",
                "An iconic monument known for its historic architecture.",
                new String[]{
                        "history",
                        "monument",
                        "architecture",
                        "heritage"
                },
                4.6
        ));

        // E - Kerala Backwaters
        destinations.add(new Destination(
                "E",
                "Kerala Backwaters",
                "Alappuzha",
                "Kerala",
                "Nature",
                "Beautiful interconnected waterways surrounded by greenery.",
                new String[]{
                        "nature",
                        "water",
                        "backwaters",
                        "relaxation"
                },
                4.8
        ));

        // F - Red Fort
        destinations.add(new Destination(
                "F",
                "Red Fort",
                "Delhi",
                "Delhi",
                "Historical",
                "A historic fort representing Mughal architecture and Indian heritage.",
                new String[]{
                        "history",
                        "fort",
                        "monument",
                        "heritage"
                },
                4.7
        ));

        // G - Ooty
        destinations.add(new Destination(
                "G",
                "Ooty",
                "Ooty",
                "Tamil Nadu",
                "Hill Station",
                "A scenic hill station famous for mountains, gardens and pleasant weather.",
                new String[]{
                        "nature",
                        "hill",
                        "mountains",
                        "relaxation"
                },
                4.6
        ));

        // H - Jaipur City Palace
        destinations.add(new Destination(
                "H",
                "Jaipur City Palace",
                "Jaipur",
                "Rajasthan",
                "Historical",
                "A royal palace complex showcasing Rajasthan's heritage and architecture.",
                new String[]{
                        "history",
                        "palace",
                        "heritage",
                        "architecture"
                },
                4.7
        ));

        // I - Manali
        destinations.add(new Destination(
                "I",
                "Manali",
                "Manali",
                "Himachal Pradesh",
                "Hill Station",
                "A popular mountain destination known for valleys and adventure activities.",
                new String[]{
                        "nature",
                        "mountains",
                        "adventure",
                        "hill"
                },
                4.7
        ));

        // J - Rishikesh
        destinations.add(new Destination(
                "J",
                "Rishikesh",
                "Rishikesh",
                "Uttarakhand",
                "Adventure",
                "A destination known for river activities, rafting and adventure tourism.",
                new String[]{
                        "adventure",
                        "river",
                        "nature",
                        "rafting"
                },
                4.6
        ));

        // K - Hampi
        destinations.add(new Destination(
                "K",
                "Hampi",
                "Vijayanagara",
                "Karnataka",
                "Historical",
                "A historical destination famous for ancient temples and ruins.",
                new String[]{
                        "history",
                        "temples",
                        "ruins",
                        "heritage"
                },
                4.8
        ));

        // L - Darjeeling
        destinations.add(new Destination(
                "L",
                "Darjeeling",
                "Darjeeling",
                "West Bengal",
                "Hill Station",
                "A mountain destination famous for tea gardens and scenic landscapes.",
                new String[]{
                        "nature",
                        "mountains",
                        "tea",
                        "hill"
                },
                4.7
        ));

        // M - Varanasi
        destinations.add(new Destination(
                "M",
                "Varanasi Ghats",
                "Varanasi",
                "Uttar Pradesh",
                "Cultural",
                "Historic riverfront ghats known for cultural and heritage significance.",
                new String[]{
                        "culture",
                        "heritage",
                        "river",
                        "history"
                },
                4.7
        ));

        // N - Andaman Islands
        destinations.add(new Destination(
                "N",
                "Andaman Islands",
                "Port Blair",
                "Andaman and Nicobar Islands",
                "Beach",
                "Island destination known for beaches, marine life and water activities.",
                new String[]{
                        "beach",
                        "island",
                        "sea",
                        "water"
                },
                4.8
        ));

        // O - Udaipur City Palace
        destinations.add(new Destination(
                "O",
                "Udaipur City Palace",
                "Udaipur",
                "Rajasthan",
                "Historical",
                "A large palace complex overlooking Lake Pichola.",
                new String[]{
                        "history",
                        "palace",
                        "heritage",
                        "lake"
                },
                4.7
        ));

        return destinations;
    }
}