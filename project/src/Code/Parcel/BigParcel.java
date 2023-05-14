package Code.Parcel;
import java.io.Serializable;

/**

 The BigParcel class represents a large-sized parcel. It extends the Parcel class and implements the Serializable interface.
 */
public class BigParcel extends Parcel implements Serializable {

    /**

     Constructs a BigParcel object with the specified weight and fragility.
     @param weight The weight of the parcel in kilograms.
     @param fragile A boolean indicating whether the parcel is fragile or not.
     */
    public BigParcel(double weight, boolean fragile) {
        super(weight, fragile);
    }
    /**

     Returns the weight of the big parcel. The weight is multiplied by 1.5.
     @return The weight of the big parcel.
     */
    @Override
    public double getWeight() {
        return super.getWeight() * 1.5;
    }
    /**

     Checks if the big parcel is fragile. In addition to the fragility status of the base parcel, it always returns false.
     @return true if the big parcel is fragile, false otherwise.
     */
    @Override
    public boolean isFragile() {
        return super.isFragile() || false;
    }
}