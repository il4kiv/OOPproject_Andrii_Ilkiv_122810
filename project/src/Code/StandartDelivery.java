package Code;

/*class StandartDelivery extends DeliveryOption{
    @Override
    public double calculateCost(double weight, boolean fragile, Destination destination) {
        double baseCost = 0.0;
        if (destination instanceof EuropeDestination) {
            baseCost = 25;
        } else if (destination instanceof AmericaDestination) {
            baseCost = 30;
        } else if (destination instanceof AsiaDestination){
            baseCost = 10;
        }
        double cost = baseCost + 10 * weight;
        if (fragile) {
            cost += 10;
        }
        return cost;
    }
}*/