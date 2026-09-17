package model;

public class Destination {

    private String id;
    private String name;
    private String city;
    private String state;
    private String type;
    private String description;
    private String[] tags;
    private double rating;

    public Destination(
            String id,
            String name,
            String city,
            String state,
            String type,
            String description,
            String[] tags,
            double rating) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.type = type;
        this.description = description;
        this.tags = tags;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String[] getTags() {
        return tags;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " - " + city + ", " + state;
    }
}