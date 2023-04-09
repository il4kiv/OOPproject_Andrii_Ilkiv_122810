package Code.Parcel;

public class SmallParcel extends Parcel {
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
