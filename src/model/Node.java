
package model;

/**
 *
 * @author HoangNam
 */
public class Node {
    private String name;
    private double data;
    private Node next;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {    
        this.name = name;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node() {
    }
    
    public Node(double data) {
        this.data = data;
        this.next = null;
    }
    
    public Node(double data, String name) {
        this.data = data;
        this.name = name;
    }
}
