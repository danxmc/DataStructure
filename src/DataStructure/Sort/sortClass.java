/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Sort;

import DataStructure.Sort.iSort;

/**
 *
 * @author danx_
 */
public class sortClass implements iSort {

    public sortClass() {

    }

    /**
     *
     * @param a el vector de enteros que se ordenara con el algoritmo
     * SelectionSort
     */
    @Override
    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {//aregla los arreglos comparando el nÃºmero de la casilla con los demÃ¡s siguientes
                if (a[j] < a[i]) {
                    int au = a[j];
                    a[j] = a[i];
                    a[i] = au;
                }
            }
        }
    }

    /**
     *
     * @param a el vector de enteros que se ordenara con el algortimo 
     * BubbleSort
     */
    @Override
    public void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {//Hace que recorra todo el vector
            for (int j = 0; j < a.length - 1; j++) {//Recorre el mismo vector
                if (a[j] > a[j + 1]) {//Compara la posicion que esta enfrente y si es menor, la cambia de posicion
                    int aux = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = aux;
                }
            }
        }
    }

    /**
     *
     * @param arreglo el vector de enteros que ordenamos con el algoritmo
     * QuickSort
     * @param inicio la posicion de inicio del vector
     * @param end la posicion final del vector
     * @return arreglo
     */
    @Override
    public int[] quickSort(int[] arreglo, int inicio, int end) {
        if (end > inicio) {//el caso base de esta recursividad es mientras el inicio sea menor que el final
            int i = inicio;
            int k = end;
            int pivot = arreglo[(inicio + end) / 2];
            
            while (k > i) {
                
                while (arreglo[i] < pivot) { //obtiene la posiciÃ³n del arreglo el cual no cumple la condicion
                    i++;
                }   
                while (arreglo[k] > pivot) {//obtiene la posiciÃ³n del arreglo el cual no cumple la condicion
                    k--;
                }
                
                if (i < k) { //intercambia los que no cumplen, si es que no era solo 1 el del problema
                    int aux = arreglo[k];
                    arreglo[k] = arreglo[i];
                    arreglo[i] = aux;
                }
            }
            
            if (i > k) { //se le da la variable de i a k para dividir el rreglo en dos
                int aux = i;
                k = i;
                i = aux;
            }   
            quickSort(arreglo, inicio, k);//aqui se ordena la primera mitad

            quickSort(arreglo, i + 1, end);//se le suma 1 para empezar del otro lado del arreglo
        }
        return arreglo;
    }

    /**
     *
     * @param arr, el vector de enteros que ordenamos con el algoritmo 
     * MergeSort
     * @return arr
     */
    @Override
    public int[] mergeSort(int[] arr) {
        int i, j, k;
        if (arr.length > 1) {                              //Revisamos si el arreglo tiene mas de un elemento
            int nElementosI = arr.length / 2;               //Dividimos el arreglo a la mitad y guardamos la cantidad de lementos del arreglo izq en una variable
            int nElementosD = arr.length - nElementosI;     //Guardamos la otra cantidad de elementos del arreglo la guardamos en otra variable.
            int arrI[] = new int[nElementosI];            //Creamos el arreglo de la derecha y la izquierda con el número de elementos que corresponde a cada uno.
            int arrD[] = new int[nElementosD];

            for (i = 0; i < nElementosI; i++) {              //Desde 0 hasta la cantiddad de elementos para el arreglo Izquierdo, copia elemento por elemento.
                arrI[i] = arr[i];
            }

            for (i = nElementosI; i < arr.length; i++) {      //Desde el número de elementos de izq, hasta el tamaño total del arreglo original, copiamos elemento por elemento.
                arrD[i - nElementosI] = arr[i];
            }

            //Aquí llamamos a la recursividad
            arrI = mergeSort(arrI);
            arrD = mergeSort(arrD);

            i = 0;
            j = 0;
            k = 0;

            while (arrI.length != j && arrD.length != k) {    //Mientras cualquier arreglo, izq o der, no sea de un solo elemento.
                if (arrI[j] < arrD[k]) {
                    arr[i] = arrI[j];
                    i++;
                    j++;
                } else {
                    arr[i] = arrD[k];
                    i++;
                    k++;
                }
            }
            //Arreglo Final
            while (arrI.length != j) {
                arr[i] = arrI[j];
                i++;
                j++;
            }
            while (arrD.length != k) {
                arr[i] = arrD[k];
                i++;
                k++;
            }
        }
        return arr;
    }

}
