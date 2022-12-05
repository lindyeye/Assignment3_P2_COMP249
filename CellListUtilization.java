/**
 * Assignment 3 - Part 2
 * For COMP  249 Section D - Fall 2022
 * @author Linden Wheeler 40195748 and Matej Pederson 40209550
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CellListUtilization {
    
    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        Scanner sc = null;
        CellList cl1 = new CellList();
        CellList cl2 = new CellList();
        CellList cl3 = new CellList();


        try 
        {
            sc = new Scanner(new FileInputStream("Cell_Info.txt"));
        }
        catch(FileNotFoundException e)  
        {
            System.out.println("Problem opening file.");
            System.out.println("Program will terminate.");
            System.exit(0);	
        }   
 
        while(sc.hasNextLine())
        {
            long s = sc.nextLong();

            String x = sc.next();
    
            double p = sc.nextDouble();
    
            int y = sc.nextInt();

            CellPhone c1 = new CellPhone(s,x,y,p);

            if (cl1.find(s) == null)
            {
                cl1.addToStart(c1);
            }
        }

        System.out.println();
        
        cl1.showContents();

        long serialNum = 0;
        CellPhone c2 = null;

        System.out.println("Enter a serial number to find in list: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println("Enter a second serial number to find in list: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println("Enter a third serial number to find in list: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println();

        System.out.println(cl2.equals(cl3));

        CellPhone c3 = new CellPhone(1, "Samsonite", 1984, 420.69);
        
        cl2.addToStart(c3);

        System.out.println(cl2.equals(cl3));

        CellPhone c4 = new CellPhone(8, "Samsonite", 1984, 420.69);

        cl3.addToStart(c4);

        System.out.println(cl2.equals(cl3));

        // cl1.deleteFromIndex(3);
        // cl1.deleteFromStart();
        // cl1.showContents();
        // System.out.println(cl1.contains(2389176));
        // CellList cl3 = new CellList(cl1);
        // cl3.showContents(); 
    }
}
