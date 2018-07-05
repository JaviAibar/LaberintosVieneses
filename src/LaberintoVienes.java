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
//WIP
//    public int dijkstra(Node start, Node finish) {
//        int shortestPath = Integer.MAX_VALUE;
//        int steps;
//        int size = 0;
//        Situation[] situations = new Situation[500];
//
//
//
//        return shortestPath;
//    }



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
        for (int i = 1; i < casos; i++) {
            String linea = lector.next();
            Node a = laberintoVienes.getNode(linea.charAt(0));
            Node b = laberintoVienes.getNode(linea.charAt(1));
            a.add(b, linea.charAt(2));
        }
        String endPoints = lector.nextLine();
//        System.out.println(
//                laberintoVienes.dijkstra(
//                        laberintoVienes.getNode(endPoints.charAt(0)),
//                        laberintoVienes.getNode(endPoints.charAt(1))
//                )
//        );
//        System.out.println(laberintoVienes);
    }
}