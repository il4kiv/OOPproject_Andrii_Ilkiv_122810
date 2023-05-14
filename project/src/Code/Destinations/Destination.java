package Code.Destinations;

/**
 Represents a destination.
 */
public class Destination {
    private final String name;
    private final double baseCost;

    /**
     * Constructs a Destination object with the specified name and base cost.
     *
     * @param name      the name of the destination
     * @param baseCost  the base cost of shipping to the destination
     */

    public Destination(String name, double baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    /**
     * Retrieves the base cost of shipping to the destination.
     *
     * @return the base cost of shipping
     */

    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Retrieves the name of the destination.
     *
     * @return the name of the destination
     */

    public String getName() {
        return name;
    }
}