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
public class nodeLL<T> {

    //Atributes
    private T data;
    private nodeLL next;

    //Methods
    //Constructor
    public nodeLL() {
        this.data = null;
        this.next = null;
    }

    public nodeLL(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public nodeLL getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(nodeLL next) {
        this.next = next;
    }

}
