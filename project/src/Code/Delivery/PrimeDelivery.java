package Code.Delivery;
import Code.Destinations.Destination;
import Code.Parcel.Parcel;
import java.io.Serializable;

public class PrimeDelivery extends DeliveryOption implements Serializable{
    public PrimeDelivery() {
        super(15, 20);
    }

    @Override
    public double calculateCost(Parcel parcel, Destination destination) {
        double cost = baseCost + parcel.getWeight() + destination.getBaseCost();
        if (parcel.isFragile()) {
            cost += fragileCost;
        }
        return cost;
    }

}