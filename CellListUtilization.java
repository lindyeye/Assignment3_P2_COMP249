import java.util.Scanner;
public class CellListUtilization {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        CellList Cell1 = new CellList();

        CellPhone c1 = new CellPhone(21891289, "Sony", 2003, 789.43);
        CellPhone c2 = new CellPhone();
        Cell1.addToStart(c2);
        Cell1.addToStart(c1);
        Cell1.showContents();
    }
}
