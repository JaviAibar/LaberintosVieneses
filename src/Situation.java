public class Situation {
    Node toExplore; // The node that needs to keep tracking
    int alreadyExplored; // The number of crosses already explored
    int stepsGiven; // The moves we've made so far (this is absolute and it's important to track traffic lights' state)

    public Situation(Node toExplore, int alreadyExplored, int stepsGiven) {
        this.alreadyExplored = alreadyExplored;
        this.stepsGiven = stepsGiven;
        this.toExplore = toExplore;
    }

    public Node getToExplore() {
        return toExplore;
    }

    public void setToExplore(Node toExplore) {
        this.toExplore = toExplore;
    }

    public int getAlreadyExplored() {
        return alreadyExplored;
    }

    public void setAlreadyExplored(int alreadyExplored) {
        this.alreadyExplored = alreadyExplored;
    }

    public int getStepsGiven() {
        return stepsGiven;
    }

    public void setStepsGiven(int stepsGiven) {
        this.stepsGiven = stepsGiven;
    }
}
