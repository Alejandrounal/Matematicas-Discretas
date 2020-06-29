/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mate_discretas.Automorfismos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Gómez
 */
public class play {
    
    static Grafo grafo = new Grafo();
    static int j = 1;
    static ArrayList<Grafo> grafos =  new ArrayList<>();
    
    public int vertices(){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de vertices"));
        return numero;
    }
    
    public int aristas(){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de aristas"));
        return numero;
    }
    
    public int[] relaciones(){
        int[] relacion = new int[2];
        String numero = JOptionPane.showInputDialog("Ingrese la arista de origen seguida a la arista de destino se parada por una coma");
        String[] numeros = numero.split(",");
        relacion[0] = Integer.parseInt(numeros[0]);
        relacion[1] = Integer.parseInt(numeros[1]);
        return relacion;
    }
    
    public void llenarVertices(int n) {
        for (int i = 0; i < n; i++) {
            Nodo nodo = new Nodo(i + 1);
            grafo.addNodo(nodo);
        }
    }
    
    public void adherirArista(int origen, int fin) {
        grafo.getNodos().get(origen - 1).addArista(grafo.getNodos().get(fin - 1));
        grafo.getNodos().get(fin - 1).addArista(grafo.getNodos().get(origen - 1));
    }
    
    public void printgrafo(Grafo grafo){
       int aristas = grafo.getNodos().size();
        for (int i = 0; i < aristas; i++) {
             String nodos = grafo.getNodos().get(i).toString();
             System.out.println(nodos);
        }   
    }
    
    public String[] mCadena(int ele){
        String[] elementos = new String[ele];
        for (int i = 0; i < ele; i++) {
            elementos[i] = Integer.toString(i+1);
        }
        return elementos;
    }
    
    
    public Grafo copiarGrafo(Grafo grafo2, Grafo grafo){
        for (int i = 0; i < grafo.getNodos().size(); i++) {
            Nodo nodo = new Nodo(grafo.getNodos().get(i).getVertice());
            grafo2.addNodo(nodo);
        }
        for (int i = 0; i < grafo2.getNodos().size(); i++) {
            for (Nodo E : grafo.getNodos().get(i).getAristas()) {
                grafo2.getNodos().get(i).addArista(grafo2.getNodos().get(E.getVertice() - 1));
            }
        }
        return grafo2;
    }
    
    private ArrayList<Grafo> permutar(String[] elementos, String actual, int n, int r){
        if(n == 0){
            j++;
            Grafo grafo2 = new Grafo();
            copiarGrafo(grafo2,grafo);
            String act1 = actual.trim();
            String[] act = act1.split(",");
            int[] actuales = new int[act.length];
            for (int i = 0; i < actuales.length; i++) {
                actuales[i] = Integer.parseInt(act[i]);
            }

            for (int i = 0; i < grafo2.getNodos().size(); i++) {
                grafo2.getNodos().get(i).setVertice(actuales[i]);
            }
            grafos.add(grafo2);            
        }else{
             for (int i = 0; i < r; i++) {
                if (!actual.contains(elementos[i])) { // Controla que no haya repeticiones
                    permutar(elementos, actual + elementos[i] + ",", n - 1, r);
                }
             }
        }return grafos;
    }
    
    public ArrayList<Grafo> isomorfo(ArrayList<Grafo> grafos, Grafo gra){
        ArrayList<Grafo> grafitos = new ArrayList<>();
        for (Grafo grafo1 : grafos) {
            if(gra.equals(grafo1)){
                grafitos.add(grafo1);
            }
        }return grafitos;
    }
    
    public static void main(String[] args) {
        play ejecutar = new play();
        int nVertices =ejecutar.vertices();
        ejecutar.llenarVertices(nVertices);
        int nAristas = ejecutar.aristas();
        for (int i = 0; i < nAristas; i++) {
             int[] relacion = ejecutar.relaciones();
             ejecutar.adherirArista(relacion[0], relacion[1]);
        } 
        ejecutar.printgrafo(grafo);
        String[] eleme = ejecutar.mCadena(nVertices);
        grafos = ejecutar.permutar(eleme, " ", nVertices, nVertices);
        Grafo grafo3 = new Grafo();
        ejecutar.copiarGrafo(grafo3, grafo);
        System.out.println("este es el nuevo");
        ejecutar.printgrafo(grafo3);
        System.out.println("este es el permutado");
        ejecutar.printgrafo(grafos.get(1));
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Estos son los grados isomorfos");
        
        ArrayList<Grafo> isomorfos = ejecutar.isomorfo(grafos, grafo);
        for (int i = 0; i < isomorfos.size(); i++) {
            System.out.println("Grafo isomorfo Numero:    "+ (i+1));
            ejecutar.printgrafo(grafos.get(i));
        }
    }   
}
