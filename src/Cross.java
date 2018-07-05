public class Cross {
    private int trafficLight;
    private Node destination;
    private Node origin;

    public Cross(Node origin, Node destination, int trafficLight) {
        this.origin = origin;
        this.destination = destination;
        this.trafficLight = trafficLight;
    }

    public char getDestinationName() {
        return destination.getName();
    }

    public char getOriginName() {
        return origin.getName();
    }

    public int getTrafficLight() {
        return trafficLight;
    }

    public int getTrafficLightNow(int stepsGiven) {
        return (trafficLight + stepsGiven) % 3;
    }

    public void setTrafficLight(int trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Node getDestination() {
        return destination;
    }

    public Node getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        String trafficLightStr = "";
        switch (trafficLight) {
            case 0:
                trafficLightStr = "Green";
                break;
            case 1:
                trafficLightStr = "Yellow";
                break;
            case 2:
                trafficLightStr = "Red";
                break;
        }
        return "The conexión between nodes " + origin.getName() + " and " + destination.getName()
                + " has/had a traffic light of " + trafficLightStr;
    }
}