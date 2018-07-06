import java.util.Scanner;

public class LaberintoVienes {
    private int size = 0;
    private Node[] nodes;

    public Node getNode(char name) {
        int i = 0;
        // As names are chars, comparing them is as simple as subtracting them
        // to see whether the result is positive or negative
        // Negative means that we haven't past the alphabetical position
        // The moment when it gets positive, that is its position
        int compare = -1;

        while (i < size && nodes[i] != null && compare < 0) {
            compare = nodes[i].getName() - name;
            i++;
        }


        if (compare == 0) {
            i--;
            return nodes[i];
        } else if (compare > 0) {
            i--;
            System.arraycopy(nodes, i, nodes, i + 1, size - i);
        }

        Node newNode = new Node(name);
        nodes[i] = newNode;
        size++;
        return newNode;
    }

    public LaberintoVienes(int casos) {
        nodes = new Node[casos];
    }

    public Node[] getNodes() {
        return nodes;
    }


    // This could be a solution without recursivity
    public int dijkstra(Node start, Node finish) {
        int shortestPath = Integer.MAX_VALUE;
        int steps;
        int size = 0;
        Situation[] situations = new Situation[500];


        return shortestPath;
    }

    // TODO: Limit the possibility to retorn to the back node
    // TODO: Detect loops and stop them
    public Track exploreNode(Node node, Node finish, Track track) {
        if (node.equals(finish) || track.steps >= 30) {
           // System.out.println(path+" "+steps);
            return track;
        } else {
            Cross[] crosses = node.getCrosses();
            Cross[] validCrosses = new Cross[node.getSize()];
            int routeSteps = Integer.MAX_VALUE;
            Track trackAux;
            int size = 0; // size of valid crosses
            for (int i = 0; i < node.getSize(); i++) {
                if (crosses[i].getTrafficLightNow(track.steps) < 2 && track.pastNode != crosses[i].getDestination()) {
                    validCrosses[size] = crosses[i];
                    size++;
                }
            }

            for (int i = 0; i < size; i++) {
                track.plus();
                track.pastNode = node;
                trackAux = exploreNode(validCrosses[i].getDestination(), finish, track);
                if (routeSteps > trackAux.steps) {
                    track.addPath(validCrosses[i].getDestination().getName());
                    track = trackAux;
                }
            }
            return track;
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) res += nodes[i] + "\n";
        return res;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int casos = lector.nextInt();
        LaberintoVienes laberintoVienes = new LaberintoVienes(casos * 2);
        lector.nextLine();
        for (int i = 0; i < casos; i++) {
            String linea = lector.next();
            Node a = laberintoVienes.getNode(linea.charAt(0));
            Node b = laberintoVienes.getNode(linea.charAt(1));
            a.add(b, Character.getNumericValue(linea.charAt(2)));
        }
        lector.nextLine();
        String endPoints = lector.nextLine();
        Track track = new Track(endPoints.charAt(0));
//        laberintoVienes.showCrosses();
        System.out.println(
                laberintoVienes.exploreNode(
                        laberintoVienes.getNode(endPoints.charAt(0)),
                        laberintoVienes.getNode(endPoints.charAt(1)),
                        track
                )
        );
    }

    private void showCrosses() {

        for (int i = 0; i < size; i++) {
            Cross[] cro = nodes[i].getCrosses();
            for (int j = 0; j < nodes[i].getSize();j++) {
                System.out.println("-*-"+cro[j]);
            }
        }
    }
}