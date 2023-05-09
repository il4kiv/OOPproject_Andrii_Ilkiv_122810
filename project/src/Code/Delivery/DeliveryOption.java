package Code.Delivery;

import Code.Destinations.Destination;
import Code.Parcel.Parcel;
import java.io.*;

public abstract class DeliveryOption implements Serializable {
    protected double baseCost;
    protected double fragileCost;

    public DeliveryOption(double baseCost, double fragileCost) {
        this.baseCost = baseCost;
        this.fragileCost = fragileCost;
    }

    public abstract double calculateCost(Parcel parcel, Destination destination);

    public String getTtype() {
        return this.getClass().getSimpleName();
    }
}