/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.List;

/**
 *
 * @author danx_
 */
public class nodeDLL<T> {
    //Atributes
    private T data;
    private nodeDLL next;
    private nodeDLL prev;
    
    //Methods
    //Constructor
    public nodeDLL(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public nodeDLL getNext() {
        return next;
    }

    public nodeDLL getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(nodeDLL next) {
        this.next = next;
    }

    public void setPrev(nodeDLL prev) {
        this.prev = prev;
    }
    
}
