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
public class circularLinkedList<T> {
    //Atributes
    private Node pivot;

    //Constructor
    public circularLinkedList() {
        pivot = null;
    }

    protected void insert(T d) {
        Node node = new Node(d);
        if (!isEmpty()) {//Si la lista no esta vacia
            //Inserta el nodo al inicio y recorremos los nodos
            node.setNext(pivot);
            findLast().setNext(node);;
            pivot = node;
        } else {//Si la lista esta vacio
            //Insertar nodo al inicio y apuntador se señala a si mismo
            pivot = node;
            node.setNext(pivot);
        }
    }

    private boolean isEmpty() {
        return pivot == null;
    }

    protected void eNode(T d) {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (findLast().getNext().getData() == d) {//Si el dato esta en el pivote
            Node aux = findLast();
            aux.setNext(aux.getNext().getNext());//El apuntador anterior ahora apunta al siguiente nodo del pivote
            pivot = aux.getNext();//El pivote ahora es el sigueinte nodo del anterior pivote
            System.out.println("Dato '" + d + "' eliminado");
        } else { //Si el dato no esta en el pivote
            Node aux = pivot;
            while (aux.getNext().getData() != d && aux.getNext() != pivot) {
                aux = aux.getNext();
            }
            if (aux.getNext().getData() == d) {
                aux.setNext(aux.getNext().getNext());
                System.out.println("Dato '" + d + "' eliminado");
            } else {
                System.out.println("No se encontro el dato");
            }
        }
    }

    private Node findLast() {
        Node aux = pivot;
        while (aux.getNext() != pivot) {
            aux = aux.getNext();
        }
        return aux;
    }

    protected Node searchNode(T d) {
        Node aux = pivot;
        do {
            if (aux.getData() == d) {
                return aux;
            } else {
                aux = aux.getNext();
            }
        } while (aux != pivot || aux.getData() != d);
        return null;
    }

    protected void showList() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            Node aux = pivot;
            System.out.print("[" + aux.getData() + "] ");
            while (aux.getNext() != pivot) {
                System.out.print("[" + aux.getNext().getData() + "] ");
                aux = aux.getNext();
            }
            System.out.println("");
        }
    }
}
