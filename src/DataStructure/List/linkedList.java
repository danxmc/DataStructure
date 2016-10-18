/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.List;

import DataStructure.Node.Node;

/**
 *
 * @author danx_
 */
public class linkedList<T> {

    //Atributes
    protected Node first;
    protected Node last;

    //Methods
    //Constructor
    public linkedList() {

    }

    /**
     * Inserta al inicio de la lista un nuevo nodo
     *
     * @param n, el dato del nodo
     */
    public void insertFirst(T n) {
        Node node = new Node(n);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.setNext(first);
            first = node;
        }
    }

    /**
     * Inserta al final de la lista un nuevo nodo
     *
     * @param n, el dato del nodo
     */
    public void iLast(T n) {
        Node node = new Node(n);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    /**
     * Elimina el ultimo nodo de la lista
     */
    public void eLast() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            Node aux = first;
            while (aux.getNext() != last) {
                aux = aux.getNext();
            }
            aux.setNext(null);
            last = aux;
        }
    }

    /**
     * Elimina el primer nodo de la lista
     */
    public void eFirst() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            Node aux = first;
            first = aux.getNext();
        }
    }

    /**
     * Elimina de la lista el nodo que contenga el dato ingresado (si existe)
     * @param data, la informacion del nodo
     */
    public boolean eNode(T data) {
        Node aux;
        
        if (isEmpty()) {
            System.out.println("Lista vacia");
            return false;
        } else if (first.getData() == data) {
            eFirst();
            System.out.println("Nodo borrado");
        } else {
            aux = first;
            
            while (aux.getNext().getData() != data && aux.getNext() != null) { //Mientras que no encuentre el dato y no llegue al final de la lista. recorre la lista
                aux = aux.getNext();
            }
            
            if (aux.getNext().getData() == data && aux.getNext() != null) {
                aux.setNext(aux.getNext().getNext());
            } else {
                System.out.println("Nodo no encontrado");
                return false;
            }
        }
        return true;
    }

    private boolean isEmpty() {
        return (first == null && last == null);
    }

    public void showList() {
        if (isEmpty() == false) {
            Node aux = first;
            while (aux != null) {
                System.out.print("[" + aux.getData() + "]->");
                aux = aux.getNext();
            }
        }
    }
}
