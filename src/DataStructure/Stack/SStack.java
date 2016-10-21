/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;
import java.util.Arrays;

/**
 *
 * @author danx_
 */
class SStack {

    //Atributes
    String[] stack;
    private int size = 0;

    //Methods
    //Constructor
    public SStack(int n) {
        stack = new String[n];
    }

    /**
     * Method que sirve para imprimir el Stack
     */
    public void showStack() {
        for (int i = stack.length - 1; i >= 0; i--) {
            System.out.println("[" + stack[i] + "}");
            System.out.println("↓");
        }
        System.out.println("null\n");
    }

    /**
     * Method que inserta un Nodo al stack
     * @param data, el contenido del nodo
     */
    public void push(String data) {
        stack[size] = data;
        ++size;
    }

    /**
     * Method que hace pop(saca el dato que esta mas arriba del stack)
     */
    public void pop() {
        stack[size - 1] = null;
        --size;
    }

    /**
     * 
     * @return int size, el tamaño actual del stack   
     */
    public int getSize() {
        return size;
    }

    /**
     * 
     * @return el dato en top del stack 
     */
    public String getTop() {
        return stack[size - 1];
    }
    
    /**
     * Llena el stack con null
     */
    public void eStack() {
        Arrays.fill(stack, null);
    }
}
