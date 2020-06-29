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
public class Prueba_Permutaciones {
   
static int j = -1;  
static Matriz_Permutacion[] vector = new Matriz_Permutacion[120];

    public static void main(String[] args) {
        String[] elementos = "1,2,3,4,5".split(",");
        int n = 5;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Perm2(elementos, "", n, r);
        
        for (int i = 0; i < vector.length; i++) {
            vector[i].PMatriz();
            System.out.println();
        }
    }
   
    private static void Perm2(String[] elem, String act, int n, int r) {   
        if (n == 0) {
            j++;
            System.out.println(act+"  ");
            vector[j] = new Matriz_Permutacion(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ",", n - 1, r);
                }
            }
        }
    }
    
   /* private static void Perm3(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
           
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r);
                   
                }
            }
        }
    }*/

}
