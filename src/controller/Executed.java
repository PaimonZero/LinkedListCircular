package controller;

import com.sun.source.tree.ContinueTree;
import model.Validate;
import view.MyMenu;

public class Executed extends MyMenu{
    CircularLinkedList link = new CircularLinkedList();
    
    public Executed() {
        super("-*-*-*-*-*Round-Robin*-*-*-*-*-", new String[] {"Enter process.", 
                    "Run with Round-Robin.", "Exit!"});
    }
    
    public static void main(String[] args) {
        Executed hi = new Executed();
        hi.run();
        
    }

    @Override
    public void execute(int choice) {
        boolean isInput = true;
        switch (choice) {
            case 1:
                isInput = true;
                int num = Validate.getInt(">Enter number of process: ");
                for(int i = 0; i < num; i++){
                    System.out.println("-Process " +i+": ");
                    String nodeName = Validate.getString(">Enter name of process: ").toUpperCase();
                    double data = Validate.getDouble(">>Enter executed time: ");
                    link.insert(data, nodeName);
                }
                System.out.println("------------------------------------");
                System.out.print("New list: ");
                link.display();
                System.out.println("------------------------------------");
                break;
            case 2:
                if (link.isEmpty()) {
                    isInput = false;
                    int num2 = Validate.getInt(">Enter number of process: ");
                    for(int i = 0; i < num2; i++){
                        System.out.println("-Process " +i+": ");
                        String nodeName = Validate.getString(">Enter name of process: ").toUpperCase();
                        double data = Validate.getDouble(">>Enter executed time: ");
                        link.insert(data, nodeName);
                    }
                    System.out.println("------------------------------------");
                    System.out.print("New list: ");
                    link.display();
                    System.out.println("------------------------------------");
                }
                System.out.println(">>..>>..>>Round-Robin<<..<<..<<");
                double quantum = Validate.getDouble(">Enter time quantum: ");
                int loop = 1;
               
                System.out.println("------------------------------------");
                do {                    
                    System.out.println(">>Loop " +loop);
                    link.roundRobin(quantum);
                    loop++;
                    System.out.println("------------------------------------");
                } while(link.isEmpty() != true);
                break;
            case 3:
                System.out.println("Program closing!");
                break;
            default:
                System.err.println("Option is not valid. Please make another selection!");
                System.out.println();   // tao khoang trong
                break;
        }
    }
}
