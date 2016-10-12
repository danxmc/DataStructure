/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Search;

/**
 *
 * @author danx_
 */
public class searchClass {
    
    public searchClass() {
        
    }
    
    /**
     * Static method, busca el dato que envie el usuario de manera Binaria,
     * checando si el numero buscado es mayor o menor y cortando la busqueda a
     * la mitad del array.
     * @param array
     * @param x, el numero que se quiere encontrar
     */
    public static void binarySearch(int array[], int x) {
        int inicio, fin, centro;
        int c = 1;
        inicio = 0;
        fin = array.length;
        boolean flag = true;
        
        System.out.println("Busqueda Binaria");
        while (inicio < fin) {
            centro = (inicio + fin) / 2;
            if (array[centro] == x) {
                flag = true;
                System.out.println("Dato encontrado en la posición: " + centro);
                System.out.println("Repeticion de ciclos: " + c + "\n");
                inicio = fin + 1;
            } else if (x < array[centro]) {
                fin = centro;
            } else {
                inicio = centro;
            }
            c++;
        }
        if (!flag) {
            System.out.println("Dato no encontrado \n");
        }
        
    }

/**
 * Static method, busca el dato que ingrese el usuario en el array, de manera
 * secuencial, evaluando desde el inicio hasta el final del array.
 * 
 * @param array
 * @param x, el numero que se va a buscar en el array
 */
    public static void sequentialSearch(int array[], int x) {
        boolean flag = false;
        System.out.println("Busqueda Secuencial");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                System.out.println("Dato encontrado en la posición: " + i);
                System.out.println("Repeticion de ciclos: " + (i + 1) + "\n");
                i = array.length - 1;
                flag = true;
            }
        }
        if (!flag) {
                System.out.println("Dato no encontrado \n");
            }
    }
}
