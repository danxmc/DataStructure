/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Sort;

/**
 *
 * @author danx_
 */
public interface iSort {
    public void selectionSort(int[] a);
    
    public int[] mergeSort(int[] arr);

    public void bubbleSort(int[] a);

    public int[] quickSort(int[] arreglo, int inicio, int end);
}
