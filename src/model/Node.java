
package model;

/**
 *
 * @author HoangNam
 */
public class Node {
    private String name;
    private int data;
    private Node next;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {    
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
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
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    public Node(int data, String name) {
        this.data = data;
        this.name = name;
    }
}


//public class Node {
//    private double data;
//    private Node next;
//
//    public Node() {
//        this.data = 0;
//        this.next = null;
//    }
//
//    public Node(double data) {
//        this.data = data;
//        this.next = null;
//    }
//    
//    public Node(double data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public double getData() {
//        return data;
//    }
//
//    public void setData(double data) {
//        this.data = data;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//
//}
