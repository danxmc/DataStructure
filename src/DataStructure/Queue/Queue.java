/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Queue;

/**
 *
 * @author danx_
 */
public class Queue<T> {
    //Atributes
    private Node first;
    private Node last;
    private int size;
    
    //Methods
    //Constructor
    public Queue() {
        this.first = null;
        this.last = null;
        size = 0;
    }
    
    public Queue(T data) {
        insertLast(data);
    }

    //Getters
    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    //Setters
    public void setFirst(Node first) {
        this.first = first;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return this.first == null;
    }
    
    /**
     * Method to insert a node in the Queue
     * @param data the data of the node 
     */
    public void insertLast(T data) {
        //Crea un nodo
        Node node = new Node(data);
        //Checa si esta vacio
        if (isEmpty()) {
            //Asigna first y last al nuevo nodo creado
            this.first = node;
            this.last = node;
        } else {
            //Se asigna last al nuevo nodo
            node.setNext(last);
            last = node;
        }
         ++size;//Aumenta el size del Queue
    }
    
    /**
     * Method to empty the first node, and assign it to the previous one
     */
    public void eFirst() {
        Node temp;
        //Se crea un auxiliar en last;
        if (!isEmpty()) {
            temp = last;
            //Se recorre el Queue hasta un espacio antes de first
            while (temp.getNext() != first) {
                temp = temp.getNext();
            }
            //Se asigna el nodo anterior a first, como first
            temp.setNext(null);
            first = temp;
            --size;//Se reduce el size del Queue
        }
    }
    
    /**
     * Method to empty the Queue
     */
    public void eQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
}
