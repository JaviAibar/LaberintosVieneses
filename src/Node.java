public class Nodo {
    private char name;
    // Number of possible routes
    private int size = 0;
    private Nodo[] cruces;
    
    public Nodo(char name) {
        this.name = name;
    }

    // WIP
    public void add(Nodo hacia, int trafficLight){
        int i;
        int compare = 0;
        // TODO review usage of compare
        for (i = 0; i < size && cruces[i] != null && compare < 0; i++) {
            compare = cruces[i].getDestinationName() < hacia.getName();
        }

        if (i != size) {
            cruces[size] = hacia;
            size++;
        } else {
            cruces[i].add(hacia);
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
}