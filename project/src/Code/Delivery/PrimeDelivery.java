package Code.Delivery;
import Code.Destinations.Destination;
import Code.Parcel.Parcel;

/**
 Represents a prime delivery option that extends the DeliveryOption class.
 */
public class PrimeDelivery extends DeliveryOption{

    /**
     * Constructs a PrimeDelivery object with the base cost and fragile cost.
     */
    public PrimeDelivery() {
        super(15, 20);
    }

    /**
     * Calculates the total cost of delivering a parcel to the given destination.
     *
     * @param parcel      the parcel to be delivered
     * @param destination the destination of the delivery
     * @return the total cost of the delivery
     */
    @Override
    public double calculateCost(Parcel parcel, Destination destination) {
        double cost = baseCost + parcel.getWeight() + destination.getBaseCost();
        if (parcel.isFragile()) {
            cost += fragileCost;
        }
        return cost;
    }
}