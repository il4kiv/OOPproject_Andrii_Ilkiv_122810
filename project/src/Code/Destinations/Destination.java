package Code.Destinations;
public abstract class Destination {
    private final String name;
    private final double baseCost;

    public Destination(String name, double baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public String getName() {
        return name;
    }
}