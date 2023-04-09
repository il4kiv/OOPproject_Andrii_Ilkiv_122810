package Code.Delivery;

import Code.Destinations.Destination;
import Code.Parcel.Parcel;

public class StandartDelivery extends DeliveryOption {
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
}