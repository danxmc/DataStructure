/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;

/**
 *
 * @author danx_
 */
public class Stack<T> {

    //Atributes
    private Node top;
    private int size;

    //Constructor
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     *
     * @return stack's top
     */
    public Node getTop() {
        return top;
    }

    /**
     *
     * @return stack's size
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Add a new element to the top of the stack
     * @param data node's information
     */
    public void push(T data) {
        Node node = new Node(data);
        if (isEmpty()) {//if stack is empty
            top = node;
        } else {
            node.setNext(top);
            top = node;
        }
        ++size;
    }

    /**
     * Elimina el elemento en top
     */
    public void pop() {
        if (!isEmpty()) {
            top = top.getNext();
            --size;
        } else {
            System.out.println("Lista vacia");
        }
    }

    /**
     * Method to delete all the stack
     */
    public void eStack() {
        top = null;
        size = 0;
    }

    public void showStack() {
        Node aux = top;
        if (isEmpty()) {
            System.out.println("null");
        } else {
            
            while (aux.getNext() != null) {
                System.out.println("[" + aux.getData() + "]\n|\nV");
                aux = aux.getNext();
            }
            
            System.out.println("null");
        }
    }
}

