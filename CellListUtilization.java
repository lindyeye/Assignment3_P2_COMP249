import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CellListUtilization {
    
    public static void main(String[] args)
    {
        Scanner sc = null;
        CellList cl1 = new CellList();
        CellList cl2 = new CellList();

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
        int count = 0;  
        while(sc.hasNextLine())
        {
            count++;
            long s = sc.nextLong();
            //System.out.println(s);
    
            String x = sc.next();
            //System.out.println(x);
    
            double p = sc.nextDouble();
            //System.out.println(p);
    
            int y = sc.nextInt();
            CellPhone c1 = new CellPhone(s,x,y,p);
            cl1.addToStart(c1);
        }
        
        cl1.showContents();
        
        
        
    }
}
