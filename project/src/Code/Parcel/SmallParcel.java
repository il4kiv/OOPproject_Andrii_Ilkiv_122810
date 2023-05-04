package Code.Parcel;

import java.io.Serializable;

public class SmallParcel extends Parcel implements Serializable {
    public SmallParcel(double weight, boolean fragile) {
        super(weight, fragile);
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public boolean isFragile() {
        return super.isFragile() || true;
    }
}
