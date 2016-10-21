/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Node;

/**
 *
 * @author danx_
 */
public class NodeDLL<T> {
    //Atributes
    private T data;
    private NodeDLL next;
    private NodeDLL prev;
    
    //Methods
    //Constructor
    public NodeDLL(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public NodeDLL getNext() {
        return next;
    }

    public NodeDLL getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(NodeDLL next) {
        this.next = next;
    }

    public void setPrev(NodeDLL prev) {
        this.prev = prev;
    }
    
}
