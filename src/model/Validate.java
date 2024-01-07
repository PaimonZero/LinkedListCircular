
package model;

import java.util.Scanner;

public class Validate {
    public static Scanner sc = new Scanner(System.in);
   // Get an integer between min..max
    public static int inputIntMinMax(String inputMsg, int min, int max) {
        if (min > max) {
            int t = min;    min = max;    max = t;
        }
        int data;
        do{
            try {
                System.out.print(inputMsg);
                data = Integer.parseInt(sc.nextLine());
                if (data >= min && data <= max) {
                    return data;
                } else {
                    System.err.println("The value must be between " +min+ " and " +max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Pls enter integer number!! Try again!");
            }
        }
        while (true);
    }
    
    public static int getInt(String inputMsg) {
        int result;
        do{
            try {
                System.out.print(inputMsg);
                result = Integer.parseInt(sc.nextLine());
                if(result > 0) { 
                    return result;
                } else { System.err.println("Value must be larger than 0"); }
            } catch (NumberFormatException e) {
                System.err.println("Pls enter integer number!! Try again!");
            }
        } while (true);
    }
    
    public static String getString(String inputMsg) {
        String result;
        do{
            try {
                System.out.print(inputMsg);
                result = sc.nextLine().trim();
                if(result.isEmpty() == true) {
                    System.out.println(">>You input nothing?");
                } else { return result; }
            } catch (Exception e) {
                System.err.println("Pls enter again!");
            }
        } while (true);
    }
}
