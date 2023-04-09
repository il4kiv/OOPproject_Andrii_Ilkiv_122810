package Code.Parcel;

public class Parcel {
    private double weight;
    private boolean fragile;

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
