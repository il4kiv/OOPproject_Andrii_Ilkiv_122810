package Code.Delivery;

import Code.Destinations.Destination;
import Code.Parcel.Parcel;

public abstract class DeliveryOption {
    protected double baseCost;
    protected double fragileCost;

    public DeliveryOption(double baseCost, double fragileCost) {
        this.baseCost = baseCost;
        this.fragileCost = fragileCost;
    }

    public abstract double calculateCost(Parcel parcel, Destination destination);
}