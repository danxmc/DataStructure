/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Deque;

import DataStructure.Node.NodeDLL;

/**
 *
 * @author danx_
 */
public class Deque<T> {

    //Atributes
    private NodeDLL first;
    private NodeDLL last;
    private int size;

    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    //Getters
    public NodeDLL getFirst() {
        return first;
    }

    public NodeDLL getLast() {
        return last;
    }

    public int getsize() {
        return size;
    }
    
    /**
     * Method to insert a node in the front of the Deque
     * @param data the data of the node 
     */
    public void insertFirst(T data) {
        //Crea un nodo
        NodeDLL node = new NodeDLL(data);
        //Checa si esta vacio
        if (isEmpty()) {
            //Asigna first y last al nuevo nodo creado
            this.first = node;
            this.last = node;
        } else {
            //Se asigna first al nuevo nodo
            node.setNext(first);
            first.setPrev(node);
            first = node;
        }
         ++size;//Aumenta el size del Deque
    }

    /**
     * Method to insert a node in the back of the Deque
     * @param data the data of the node 
     */
    public void insertLast(T data) {
        //Crea un nodo
        NodeDLL node = new NodeDLL(data);
        //Checa si esta vacio
        if (isEmpty()) {
            //Asigna first y last al nuevo nodo creado
            this.first = node;
            this.last = node;
        } else {
            //Se asigna last al nuevo nodo
            node.setPrev(last);
            last.setNext(node);
            last = node;
        }
         ++size;//Aumenta el size del Deque
    }

    /**
     * Method that removes the first element of the Deque
     */
    public void eFirst() {
        if (isEmpty()) {
            System.out.println("Dequeue vacia");
        } else {
            first = first.getNext();
            first.setPrev(null);
            --size;
        }
    }

    /**
     * Method that removes the last element of the Deque
     */
    public void eLast() {
        if (isEmpty()) {
            System.out.println("Dequeue vacia");
        } else {
            last = last.getPrev();
            last.setNext(null);
            --size;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void eDeque() {
        first = null;
        last = null;
        size = 0;
    }
}
