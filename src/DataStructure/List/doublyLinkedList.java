/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.List;

import DataStructure.Node.nodeDLL;

/**
 *
 * @author danx_
 */
public class doublyLinkedList<T> {

    //Atributos
    private nodeDLL first;
    private nodeDLL last;

    //Methods
    //Constructor
    public doublyLinkedList() {

    }

    /**
     * Inserta un nodo al inicio de la lista
     *
     * @param data generic type, contiene informacion que se desea guardar
     */
    public void insertFirst(T data) {
        nodeDLL node = new nodeDLL(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {//Si la lista tiene elementos
            node.setNext(first); //El apuntador "next" del nuevo nodo apunta al primer nodo de la lista
            first.setPrev(node); //El apuntador "prev" del primer nodo de la lista, apunta al nuevo nodo
            first = node; //El apuntador first se cambia al nuevo nodo
        }
    }

    /**
     * Inserta un nodo en el ultimo espacio de la lista
     *
     * @param data, informacion que contiene el nodo
     */
    public void insertLast(T data) {
        nodeDLL node = new nodeDLL(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else { //Si la lista tiene elementos
            node.setPrev(last);
            last.setNext(node);
            last = node;
        }
    }

    /**
     *
     * @return dato booleano para saber si la lista esta vacia
     */
    private boolean isEmpty() {
        return (first == null && last == null);
    }

    /**
     *
     * @param data el dato que se requiere encontrar
     * @return nodeClass pointer donde se encuentra el dato, o si no se
     * encuentra devuelve null
     */
    private nodeDLL searchNode(T data) {
        nodeDLL aux;
        if (isEmpty()) {
            return null; //Si esta vacio regresa vacio
        } else { //Si contiene elementos
            aux = first; //Se inicializa el auxiliar al principio de la lista
            while (aux.getData() != data && aux != null) { //Mientras que no se encuentre el dato, o no llegue al final de la lista
                if (aux.getData() == data) { //Se retorna el apuntador si lo que contiene es igual al dato buscado
                    return aux;
                }
            }
            //Se retorna null
            return null;
        }
    }

    /**
     *
     * @param data el dato que se desea borrar
     * @return boolean, para saber si el nodo con data fue borrado o no
     */
    public boolean eNode(T data) {
        nodeDLL aux = searchNode(data);//Llama al method searchNode, para saber el pointer donde esta data
        if (aux == null) {//si es null, devuelve falso
            System.out.println("No se encontro el nodo");
            return false;
        } else if (aux == first) {//Si el pointer es al principio, manda llamar al method eFirst
            eNodeFirst();
        } else if (aux == last) {//Si el pointer es al final, manda llamar al method eLast
            eNodeLast();
        } else {//Si el pointer es enmedio
            aux.getNext().setPrev(aux.getPrev());//Se cambia el apuntador del nodo anterior para que apunte a uno despues del nodo actual
            aux.getPrev().setNext(aux.getNext());//Se cambia el apuntar del nodo siguiente para que apunte a uno antes del actual
        }
        return true;
    }

    /**
     * Ignora el primer nodo de la lista
     */
    public void eNodeFirst() { //Corremos el primero un espacio adelante
        first = first.getNext();
        first.setPrev(null);
    }

    /**
     * Ignora el ultimo nodo de la lista
     *
     */
    public void eNodeLast() { //Corremos el ultimo un espacio atras
        last = last.getPrev();
        last.setNext(null);
    }

    /**
     * Imprime la lista
     */
    public void showList() {
        if (isEmpty()) {//Si la lista esta vacia, imprime emoticon
            System.out.println("Lista vacia ☠");
        } else {//Recorre los nodos, des de first hasta fin, y los imprime
            nodeDLL aux = first;
            while (aux != null) {
                System.out.print("[" + aux.getData() + "]->");
                aux = aux.getNext();
            }
            System.out.println("");
        }
    }

    /**
     * Imprime la lista en un orden revertido
     */
    public void showListReverted() {
        if (isEmpty()) {//Si la lista esta vacia, imprime emoticon
            System.out.println("Lista vacia ☠");
        } else {//Recorre los nodos de last a first, y los imprime
            nodeDLL aux = last;
            while (aux != null) {
                System.out.print("[" + aux.getData() + "]->");
                aux = aux.getPrev();
            }
            System.out.println("");
        }
    }
}
