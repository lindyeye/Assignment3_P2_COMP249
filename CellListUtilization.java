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

            if (cl1.contains(s) == false)
            {
                cl1.addToStart(c1);
            }
        }

        System.out.println("\nList one:");
        cl1.showContents();

        long serialNum = 0;

        CellPhone cell1 = null;
        CellPhone cell2 = null;
        CellPhone cell3 = null;

        System.out.println("\nEnter a serial number to find in List 1: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println("\nEnter a second serial number to find in List 2: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println("\nEnter a third serial number to find in List 3: ");
        serialNum = ui.nextLong();
        ui.nextLine();
        cl1.find(serialNum);

        System.out.println();

        System.out.println("\nList TWO:");
        cl2.showContents();
        System.out.println("\nList THREE:");
        cl3.showContents();
        System.out.println();
        System.out.println("List TWO equals list THREE: " + cl2.equals(cl3));

        System.out.println("Deleting from start of List THREE");
        cl3.deleteFromStart();

        CellPhone c3 = new CellPhone(1, "Samsonite", 1984, 419);
        System.out.println("\nAdding cellphone to List TWO");
        cl2.addToStart(c3);
        System.out.println("List TWO:");
        cl2.showContents();
        System.out.println("\nList TWO equals list THREE: " + cl2.equals(cl3));

        CellPhone c4 = new CellPhone(2, "Samsonite", 1984, 419);
        System.out.println("\nAdding cellphone to List THREE");
        cl3.addToStart(c4);
        System.out.println("List THREE:");
        cl3.showContents();
        System.out.println("\nList TWO equals list THREE: " + cl2.equals(cl3));

        CellPhone c5 = new CellPhone(3, "Apple", 2022, 99000);
        System.out.println("\nAdding cellphone to List TWO");
        cl2.addToStart(c5);
        System.out.println("List TWO:");
        cl2.showContents();

        CellPhone c6 = new CellPhone(4, "Google", 2020, 2000);
        System.out.println("Inserting cellphone in List TWO at index 1");
        cl2.insertAtIndex(c6, 1);
        System.out.println("List TWO:");
        cl2.showContents();

        CellPhone c7 = new CellPhone(5, "Panasonic", 2015, 350);
        System.out.println("\nReplacing cellphone in List TWO at index 2");
        cl2.replaceAtIndex(c7, 2);
        System.out.println("List TWO:");
        cl2.showContents();

        CellList cl4 = new CellList(cl2);
        System.out.println("\nCreating copy of list 2 and naming \"List FOUR\"");
        System.out.println("List FOUR:");
        cl4.showContents();

        System.out.println("\nDeleting cellphone from List FOUR at index 1");
        cl4.deleteFromIndex(1);
        System.out.println("List FOUR:");
        cl4.showContents();

        System.out.println("\nDeleting cellphone from start in List FOUR");
        cl4.deleteFromStart();
        System.out.println("List FOUR:");
        cl4.showContents();

        CellPhone c8 = new CellPhone(7, "GTRX", 2016, 1200);
        System.out.println("\nAdding cellphone to List FOUR");
        cl4.addToStart(c5);
        System.out.println("List FOUR:");
        cl4.showContents();
        System.out.println("\nInserting cellphone to List FOUR at index 1");
        cl4.insertAtIndex(c8, 1);
        System.out.println("List FOUR:");
        cl4.showContents();

        System.out.println("\nList TWO:");
        cl2.showContents();

        System.out.println("\nList TWO equals list FOUR: " + cl2.equals(cl4));

        System.out.println("\nInserting cellphone in List TWO at index 7");
        cl2.insertAtIndex(c6, 7);

    }
}
