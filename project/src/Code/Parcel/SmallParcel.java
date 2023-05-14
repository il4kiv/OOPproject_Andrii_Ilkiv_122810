package Code.Parcel;
import java.io.Serializable;

/**

 Represents a small parcel that extends the Parcel class and implements Serializable.
 */
public class SmallParcel extends Parcel implements Serializable {
    /**
     * Constructs a SmallParcel object with the specified weight and fragility.
     *
     * @param weight   the weight of the small parcel
     * @param fragile  the fragility of the small parcel
     */
    public SmallParcel(double weight, boolean fragile) {
        super(weight, fragile);
    }

    /**
     * Retrieves the weight of the small parcel.
     *
     * @return the weight of the small parcel
     */
    @Override
    public double getWeight() {
        return super.getWeight();
    }

    /**
     * Checks if the small parcel is fragile.
     *
     * @return true if the small parcel is fragile, false otherwise
     */
    @Override
    public boolean isFragile() {
        return super.isFragile() || true;
    }
}
