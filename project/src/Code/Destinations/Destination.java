package Code.Destinations;
import java.io.Serializable;

public abstract class Destination implements Serializable {
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