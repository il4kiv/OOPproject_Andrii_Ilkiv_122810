package Code.Parcel;
import java.io.Serializable;

public class BigParcel extends Parcel implements Serializable {
    public BigParcel(double weight, boolean fragile) {
        super(weight, fragile);
    }

    @Override
    public double getWeight() {
        return super.getWeight() * 1.5;
    }

    @Override
    public boolean isFragile() {
        return super.isFragile() || false;
    }
}
