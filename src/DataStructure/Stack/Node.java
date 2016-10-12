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
public class Node<T> {
    //Atributes
    private T data;
    private Node next;
    
    //Constructor
    public Node(T d) {
        this.data = d;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
