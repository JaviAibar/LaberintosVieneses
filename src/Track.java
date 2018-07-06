public class Track {
    String path = "";
    int steps;
    Node pastNode;

    public Track() {

    }

    public Track(char init) {
        path += init;
    }

    public void addPath(char character) {
        path += character;
    }

    public void addPath(String character) {
        path += character;
    }

    public void plus() {
        steps++;
    }

    @Override
    public String toString() {
        return "The shortest path is " + path + " with " + steps +" moves";
    }
}
