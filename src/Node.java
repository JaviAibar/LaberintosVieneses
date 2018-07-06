public class Node {
    private char name;
    // Number of possible routes
    private int size = 0;
    private Cross[] crosses;

    public Node(char name) {
        this.name = name;
        crosses = new Cross[10];
    }

    private void add(Node towards, int trafficLight, boolean isFirst) {
        int i = 0;
        // As names are chars, comparing them is as simple as subtracting them
        // to see whether the result is positive or negative
        // Negative means that we haven't past the alphabetical position
        // The moment when it gets positive, that is its position
        int compare = -1;

        while (i < size && crosses[i] != null && compare < 0) {
            compare = crosses[i].getDestinationName() - towards.getName();
            i++;
        }

        if (compare > 0) {
            i--;
            System.arraycopy(crosses, i, crosses, i + 1, size - i);
        }
        crosses[i] = new Cross(this, towards, trafficLight);
        size++;
        if (isFirst) {
            towards.add(this, trafficLight, false);
        }
    }

    public void add(Node towards, int trafficLight) {
        add(towards, trafficLight, true);
    }

    public Cross[] getCrosses() {
        return crosses;
    }

    public Node getNode(int i) {
        return crosses[i].getDestination();
    }

    public void showCrosses() {
        for (int i = 0; i < size; i++) {
            System.out.println(crosses[i]);
        }
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String res = "Node " + name + ", connected to: ";
        for (int i = 0; i < size; i++) {
            res += crosses[i].getDestinationName();
            if (i != size - 1) {
                res += ", ";
            }
        }
        return res;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            return this.name == ((Node) o).getName();
        }
        return false;
    }

}