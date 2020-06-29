package mate_discretas.Automorfismos;

import java.util.HashSet;

public class Nodo {
    
    private int vertice;
    private HashSet<Nodo> aristas;

    public Nodo(int vertice) {
        this.vertice = vertice;
        aristas = new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Nodo otro = (Nodo) obj;
        if ((this.vertice != otro.vertice) || (this.aristas.size() != otro.aristas.size())) {
            return false;
        } else {
            for (Nodo A : this.aristas) {
                Boolean existe = false;
                for (Nodo B : otro.aristas) {
                    if (B.vertice == A.vertice) {
                        existe = true;
                        break;
                    }
                }
                if (existe == false) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public String toString() {
        String string = "";
        string = string + "\n Nodo{" + " vertice = " + vertice + ",  aristas = [";
        for (Nodo E : aristas) {
            string = string + "Nodo: " + E.vertice + " ";
        }
        return string;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public HashSet<Nodo> getAristas() {
        return aristas;
    }

    public void addArista(Nodo arista) {
        aristas.add(arista);
    }

}
