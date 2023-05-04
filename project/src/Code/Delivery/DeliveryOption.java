package Code.Delivery;
import Code.Destinations.Destination;
import Code.Parcel.Parcel;
import java.io.Serializable;

public abstract class DeliveryOption implements Serializable {
    protected double baseCost;
    protected double fragileCost;
    protected DeliveryStatus deliveryStatus;

    public DeliveryOption(double baseCost, double fragileCost) {
        this.baseCost = baseCost;
        this.fragileCost = fragileCost;
        this.deliveryStatus = new DeliveryStatus("In transit", "");
    }

    public abstract double calculateCost(Parcel parcel, Destination destination);

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
}