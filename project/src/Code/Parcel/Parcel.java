package Code.Parcel;
import java.io.Serializable;

public class Parcel implements Serializable {
    private double weight;
    private boolean fragile;
// poistenie
    public Parcel(double weight, boolean fragile) {
        this.weight = weight;
        this.fragile = fragile;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return fragile;
    }
}