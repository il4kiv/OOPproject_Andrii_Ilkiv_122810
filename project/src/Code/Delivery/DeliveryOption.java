package Code.Delivery;

import Code.Destinations.Destination;
import Code.Parcel.Parcel;


/**
 Represents a delivery option.
 */
public abstract class DeliveryOption {
    Parcel parcel;
    protected double baseCost;
    protected double fragileCost;

    /**
     * Constructs a DeliveryOption object with the specified base cost and fragile cost.
     *
     * @param baseCost     the base cost of the delivery option
     * @param fragileCost  the additional cost for fragile parcels
     */
    public DeliveryOption(Parcel parcel, double baseCost, double fragileCost) {
        this.parcel = parcel;
        this.baseCost = baseCost;
        this.fragileCost = fragileCost;
    }

    /**
     * Calculates the total cost of delivering a parcel to the given destination.
     *
     * @param parcel      the parcel to be delivered
     * @param destination the destination of the delivery
     * @return the total cost of the delivery
     */
    public abstract double calculateCost(Parcel parcel, Destination destination);

    /**
     * Creates an instance of DeliveryOption based on the specified option.
     * Factory method to create instances of DeliveryOption
     * @param option  the delivery option
     * @return an instance of DeliveryOption
     * @throws IllegalArgumentException if the option is invalid
     */
    public static DeliveryOption createDeliveryOption(String option) {
        switch (option.toLowerCase()) {
            case "prime":
                return new PrimeDelivery();
            case "standart":
                return new StandartDelivery();
            default:
                throw new IllegalArgumentException("Invalid delivery option: " + option);
        }
    }
}