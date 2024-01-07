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

    public void insert(int data, String name) {
        Node newNode = new Node(data, name);
        if (head == null) {
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

    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        Node current = head;
        do {
            if (current.getData() > timeQuantum) {
                current.setData(current.getData() - timeQuantum);
                System.out.println("Executing process "+current.getName()+" with remaining time: " + current.getData());
                current = current.getNext(); // Move to the next process
            } else {
                System.out.println("Executing process "+current.getName()+" with remaining time: 0");
                Node nextNode = current.getNext();
                remove(current); // Remove the process that has finished
                if(head != null) {      //check condition !!!Warning!!!
                   current = nextNode; // Move to the next process
                } else {
                    break;
                }
            }
        } while (current != head || isEmpty() == true);
    }

    public void remove(Node nodeToRemove) {
        if (nodeToRemove == head) {
            if (head.getNext() == head) {
                // Only one node in the list
                head = null;
            } else {
                Node temp = head;
                while (temp.getNext() != head) {
                    temp = temp.getNext();
                }
                temp.setNext(head.getNext());
                head = head.getNext();
            }
        } else {
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
