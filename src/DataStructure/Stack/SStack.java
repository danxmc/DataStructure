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
    String[] stack = new String[15];
    private int size = 0;

    //Methods
    //Constrcutor
    public SStack() {
    }

    public void showStack() {
        for (int i = stack.length - 1; i >= 0; i--) {
            System.out.println("[" + stack[i] + "}");
            System.out.println("|");
            System.out.println("V");
        }
        System.out.println("null\n");
    }

    public void push(String data) {
        stack[size] = data;
        ++size;
    }

    public void pop() {
        stack[size - 1] = null;
        --size;
    }

    public int getSize() {
        return size;
    }

    public String getTop() {
        return stack[size - 1];
    }
    
    public void eStack() {
        Arrays.fill(stack, null);
    }
}
