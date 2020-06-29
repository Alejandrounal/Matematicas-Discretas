/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mate_discretas;

/**
 *
 * @author Alejandro
 */
public class Matriz_Permutacion {
    private int[][] matriz;


    public Matriz_Permutacion(int cero) { // Sirve para llenar los espacios que es tan nulos con matrices de 0s.
        this.matriz = new int[2][5];
        for (int i = 0; i <2; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = 0;
            }
        }
        
    }

    public Matriz_Permutacion(String ent) {
        matriz = new int[2][5];                   ////////Crea la matriz y llena la primera fila con 12345
        for (int i = 0; i < 5; i++) {
            matriz[0][i] = i+1;
        }      
      
        String[] ele = ent.split(",");           ////////Crea la segunda fila y la llena con los numeros que llegan de afuera. 
        for (int i = 0; i <ele.length; i++) {
            matriz[1][i] = Integer.parseInt(ele[i]);
        }
    }
      
    public void PMatriz(){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
		System.out.print(matriz[i][j] + " ");	// Imprime elemento
	}
	System.out.println();	// Imprime salto de línea
}
    }
    
    public void pLinea(int[][] matriz, int fila){
        for (int i = 0; i < 5; i++) {
            System.out.println(matriz[fila][i]);
        }
    }
    
    public static void main(String[] args) {
        Matriz_Permutacion m = new Matriz_Permutacion("1,2,3,4,5");
        m.PMatriz();
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    
}
