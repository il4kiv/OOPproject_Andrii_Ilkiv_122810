package Code.Delivery;

import Code.Destinations.Destination;
import Code.Parcel.Parcel;

import java.io.Serializable;

public class StandartDelivery extends DeliveryOption implements Serializable{
    public StandartDelivery() {
        super(0, 10);
    }

    @Override
    public double calculateCost(Parcel parcel, Destination destination) {
        double cost = baseCost + parcel.getWeight() + destination.getBaseCost();
        if (parcel.isFragile()) {
            cost += fragileCost;
        }
        return cost;
    }

    public void updateDeliveryStatus(String newStatus, String newLocation) {
        deliveryStatus = new DeliveryStatus(newStatus, newLocation);
    }
}