public class Crosses {
    private int Semaforo;
    private Node destination;
    private Node origin;

    public Crosses(Node origin, Node destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public char getDestinationName() {
        return destination.getName();
    }

    public char getOriginName() {
        return origin.getName();
    }

    public int getSemaforo() {
        return Semaforo;
    }

    public void setSemaforo(int semaforo) {
        Semaforo = semaforo;
    }
}