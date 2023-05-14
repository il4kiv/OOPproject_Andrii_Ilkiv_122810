package Code.Parcel;
import java.io.Serializable;

/**
 The Parcel class represents a generic parcel. It implements the Serializable interface.
 */
public class Parcel implements Serializable {
    private double weight;
    private boolean fragile;

    /**
     Constructs a Parcel object with the specified weight and fragility.
     @param weight The weight of the parcel in kilograms.
     @param fragile A boolean indicating whether the parcel is fragile or not.
     */
    public Parcel(double weight, boolean fragile) {
        this.weight = weight;
        this.fragile = fragile;
    }
    /**
     Returns the weight of the parcel.
     @return The weight of the parcel.
     */
    public double getWeight() {
        return weight;
    }
    /**
     Checks if the parcel is fragile.
     @return true if the parcel is fragile, false otherwise.
     */
    public boolean isFragile() {
        return fragile;
    }
}