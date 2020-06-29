package mate_discretas.Automorfismos;


import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodo> nodos;
    
    public Grafo(){
        nodos = new ArrayList<>();
    }

    public Grafo(ArrayList<Nodo> nodos) {
        this.nodos = nodos;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Grafo otro = (Grafo) obj;
        if (otro.nodos.size() != this.nodos.size()) {
            return false;
        } else {
            for (int i = 0; i < this.nodos.size(); i++) {
                boolean pertenece = false;
                for (int j = 0; j < otro.nodos.size(); j++) {
                    if (this.nodos.get(i).equals(otro.nodos.get(j))) {
                        pertenece = true;
                        break;
                    }
                }
                if (pertenece == false) {
                    return false;
                }
            }
            return true;
        }
    }

    public void addNodo(Nodo node) {
        nodos.add(node);
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    @Override
    public String toString() {
        return "Grafo [nodes=" + nodos + "\n";
    }

    public void setNodos(ArrayList<Nodo> nodos) {
        this.nodos = nodos;
    }
}

