/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mate_discretas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class MatrizCompleta {
    Prueba_Permutaciones p = new Prueba_Permutaciones();
    static Matriz_Permutacion[][] matrizFull =  new Matriz_Permutacion[121][121];
    static int j = 0;
    //static Matriz_Permutacion uso =  new Matriz_Permutacion();
    
    private static void Perm2(String[] elem, String act, int n, int r) {
      
        if (n == 0) {
            j++;
            //System.out.println(act);
            matrizFull [0][j] = new Matriz_Permutacion(act);
            matrizFull [j][0] = new Matriz_Permutacion(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ",", n - 1, r);
                }
            }
        }
    }
    
    private static void Compo(Matriz_Permutacion[][] matriz){
        for (int i = 0; i < 120; i++) {
            for (int k = 0; k < 120; k++) {
                for (int p = 0; p < 5; p++) {
                    int f = matriz[i+1][0].getMatriz()[0][p];
                    int fx = matriz[i+1][0].getMatriz()[1][p];
                    
                    int gx = 0;
                    for (int l = 0; l < 5; l++) {
                        if(fx == matriz[0][k+1].getMatriz()[0][l]){
                            gx = matriz[0][k+1].getMatriz()[1][l];
                            break;
                        }
                    }
                     
                    matriz[i+1][k+1].getMatriz()[0][p] = f;
                    matriz[i+1][k+1].getMatriz()[1][p] = gx;
                }
            }
        }
    }
    
    private static void llenar(Matriz_Permutacion[][] matriz){
        
        for (int i = 0; i < 121; i++) {
            for (int k = 0; k < 121; k++) {
                if(matriz[i][k]== null)
                    matriz[i][k] =  new Matriz_Permutacion(0);
            }
        }
    }
    
    public static void escribir(Matriz_Permutacion[][] matriz, String file) throws IOException{
        try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        
        for (int i = 0; i < 121; i++) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < 121; l++) {
                    if(matrizFull[i][l] != null){
                        for (int m = 0; m < 5; m++) {
                            bw.write(matrizFull[i][l].getMatriz()[k][m] + " ");
                        }                       
                    }else{
                        bw.write("0 0");
                    }
                    bw.write("||");
                }
                
                bw.newLine();
            }
            bw.newLine();
            
        }
        }
        catch (IOException e){
            System.out.println("No se pudo encontrar el archivo");
        }
    }
    
    public static void main(String[] args) throws IOException {
        String[] elementos = "1,2,3,4,5".split(",");
        int n = 5;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Perm2(elementos, "", n, r);
        llenar(matrizFull);
        Compo(matrizFull); 
        escribir(matrizFull, "arch.txt");

        for (int i = 0; i < 121; i++) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < 121; l++) {
                    if(matrizFull[i][l] != null){
                        for (int m = 0; m < 5; m++) {
                            System.out.print(matrizFull[i][l].getMatriz()[k][m] + " ");
                        }                       
                    }else{
                        System.out.print("0 0");
                    }
                    System.out.print("||");
                }
                
                System.out.println("");
            }
            System.out.println("");
            
        }
        System.out.println("Aqui termina la primera impresion");
        
        
        // Aqui se acaba la impresion
            
         
        }
    }
    
    

