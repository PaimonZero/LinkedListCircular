package controller;

import model.Node;

class CircularLinkedList {
    private Node head;
    
    // Example constructor
    public CircularLinkedList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(double data, String name) {
        Node newNode = new Node(data, name);
        if (head == null) {     //th ko có node trong list
            head = newNode;
            newNode.setNext(head);
        } else {
            Node temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
    }
    
    public int length() {
        if(isEmpty()) {
            return 0;
        }else {
            int count = 1;
            Node temp = head;
            while(temp.getNext() != head){
                temp = temp.getNext();
                count++;
            }
            return count;
        }
    }

    public void roundRobin(double timeQuantum) {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        Node current = head;
        int count = length();
        do {
            if (current.getData() > timeQuantum) {
                current.setData(current.getData() - timeQuantum);
                System.out.printf("Executing process %s with remaining time: %.3f\n", current.getName(), current.getData());
                current = current.getNext(); // Move to the next process
                count--;
            } else {
                System.out.println("Executing process "+current.getName()+" with remaining time: 0");
                Node nextNode = current.getNext();
                remove(current); // Remove the process that has finished
                count--;
                if(head != null) {      //check condition !!!Warning!!!
                   current = nextNode; // Move to the next process
                } else {
                    break;
                }
            }
        } while (count > 0);     //current != head
    }

    public void remove(Node nodeToRemove) {
        if (nodeToRemove == head) {
            if (head.getNext() == head) {
                // Only one node in the list
                head = null;
            } else {  //check trường hợp head cần remove
                Node temp = head;
                while (temp.getNext() != head) {
                    temp = temp.getNext();
                }
                temp.setNext(head.getNext());
                head = head.getNext();
            }
        } else {    //th bình thường 
            Node temp = head;
            while (temp.getNext() != head && temp.getNext() != nodeToRemove) {
                temp = temp.getNext();
            }
            if (temp.getNext() == nodeToRemove) {
                temp.setNext(nodeToRemove.getNext());
            }
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println(".");
    }

}
